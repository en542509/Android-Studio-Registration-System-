package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseListAdapter;
import java.util.ArrayList;

/**
 * Created by denghaohai on 09/03/2018.
 */

public class Instructor_mycourse extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference teacher;
    private ListView datalist;
    private FirebaseListAdapter<Course> firebaseAdapter;
    private ArrayList<String> listItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycourse);

        database = FirebaseDatabase.getInstance();
        teacher = database.getReference("course");

        listItems = new ArrayList<String>();
        datalist = (ListView)findViewById(R.id.mycourse_list);
        firebaseAdapter = new FirebaseListAdapter<Course>(this, Course.class,
                android.R.layout.simple_list_item_1, teacher.orderByChild("instructor").equalTo("Aziz")) {
            @Override
            protected void populateView(View v, Course model, int position) {
                TextView contactName = (TextView)v.findViewById(android.R.id.text1);
                contactName.setText(model.getCourseId());
            }
        };
        datalist.setAdapter(firebaseAdapter);

        datalist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Instructor_mycourse.this, wlistActivity.class);
                Course courseid = firebaseAdapter.getItem(i);
                intent.putExtra("CSCI1110", courseid.getCourseId());
                startActivity(intent);
            }
        });
        /*final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);

        datalist.setAdapter(adapter);


        teacher.orderByChild("instructor").equalTo("Brodsky").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> courselist = dataSnapshot.getChildren();
                for(DataSnapshot a : courselist){
                    Course c = a.getValue(Course.class);
                    String cid = c.getCourseId();

                    listItems.add(cid);
                    adapter.notifyDataSetChanged();
                }
               /* Course c = dataSnapshot.getValue(Course.class);

                listItems.add(c.getCourseId());
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), c.getCourseId(), Toast.LENGTH_SHORT).show();*/
          /*  }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }
}
