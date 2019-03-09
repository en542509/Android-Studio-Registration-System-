package com.example.yiweizhang.csci3130project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by denghaohai on 11/03/2018.
 */

public class wlistActivity extends AppCompatActivity{

    private FirebaseDatabase database;
    private DatabaseReference wlist;
    private ListView wlist_view;
    private String courseid;
    private ArrayList<String> studentlist;
    private int count = 0;
    private int totalNum;
    private TextView capacity;
    private TextView wlistNum;

    private int capa;
    int new_capa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_list);

        database = FirebaseDatabase.getInstance();
        wlist = database.getReference("course");
        courseid = (String) getIntent().getSerializableExtra("CSCI1110");
        studentlist = new ArrayList<String>();
        wlist_view = (ListView)findViewById(R.id.wlist);
        capacity = (TextView)findViewById(R.id.capacity_wlist);
        wlistNum = (TextView)findViewById(R.id.wlist_number);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, studentlist);

        wlist_view.setAdapter(adapter);


        wlist.child(courseid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*List<String> namelist = (ArrayList<String>) dataSnapshot.getValue();
                showMyToast(Toast.makeText(getApplicationContext(), namelist.toString(), Toast.LENGTH_LONG), 1000000000);

                for (int i = 1; i < namelist.size(); i++){
                    studentlist.add(namelist.get(i));

                }
                adapter.notifyDataSetChanged();*/

                Course c = dataSnapshot.getValue(Course.class);
                List<String> namelist = (ArrayList<String>) c.getWlist_list();

                for (int i = 1; i < namelist.size(); i++){
                    studentlist.add(namelist.get(i));
                    count++;
                }
                //capacity.setText("cur:"+String.valueOf(c.getCapacity()));
                wlistNum.setText(String.valueOf(count));
                adapter.notifyDataSetChanged();

                wlist_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        final String student_name = adapter.getItem(i);
                        final int student_tempid = i+1;

                        AlertDialog.Builder alert = new AlertDialog.Builder(wlistActivity.this);

                        AlertDialog dialog = alert.setMessage("Do you want to add this student in the course "+courseid).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                wlist.child(courseid).child("Wlist_list").child(String.valueOf(student_tempid)).removeValue();

                                //wlist.child(courseid).child("capacity").setValue(capa);
                                //capacity.setText("cur:"+String.valueOf(capa));
                                wlistNum.setText(String.valueOf(count-1));
                                finish();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).create();

                        dialog.show();
                    }
                });

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void showMyToast(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );
    }
}
