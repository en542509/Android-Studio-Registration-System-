package com.example.yiweizhang.csci3130project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CourseAddActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference Instructor;
    private Button submit;
    private EditText id;
    private EditText number;
    private EditText location;
    private EditText starttime;
    private EditText endtime;
    private EditText Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_add);

        database = FirebaseDatabase.getInstance();
        Instructor = database.getReference("course");

        submit = (Button)findViewById(R.id.Submit);
        id = (EditText) findViewById(R.id.CourseID);
        number = (EditText) findViewById(R.id.Capacity);
        location = (EditText) findViewById(R.id.Location);
        starttime = (EditText) findViewById(R.id.starttime);
        endtime = (EditText)findViewById(R.id.endtime);
        Date = (EditText) findViewById(R.id.Date);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Vid = id.getText().toString();
                final String Vnumber = number.getText().toString();
                final String Vlocation = location.getText().toString();
                final String Vstarttime = starttime.getText().toString();
                final String Vendtime = endtime.getText().toString();
                final String Vdate = Date.getText().toString();
                if (TextUtils.isEmpty(Vid)){
                    id.setError("Required");
                    return;
                }
                if (TextUtils.isEmpty(Vnumber)){
                    number.setError("Required");
                    return;
                }

                if (TextUtils.isEmpty(Vlocation)){
                    location.setError("Required");
                    return;
                }
                if (TextUtils.isEmpty(Vstarttime)){
                    starttime.setError("Required");
                    return;
                }
                if (TextUtils.isEmpty(Vendtime)){
                    endtime.setError("Required");
                    return;
                }
                if (TextUtils.isEmpty(Vdate)){
                    Date.setError("Required");
                    return;
                }

                Instructor.equalTo(Vid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        AlertDialog.Builder alert = new AlertDialog.Builder(CourseAddActivity.this);

                        AlertDialog dialog = alert.setMessage("This course already existed, do you want to update it?").setPositiveButton("update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                DatabaseReference newcourse = Instructor.child(Vid);

                                DatabaseReference myid = newcourse.child("courseId");

                                DatabaseReference mynumber = newcourse.child("capacity");

                                DatabaseReference mylocation = newcourse.child("Location");

                                DatabaseReference mystime = newcourse.child("startTime");

                                DatabaseReference myetime = newcourse.child("endTime");

                                DatabaseReference mydate = newcourse.child("courseDate");

                                myid.setValue(Vid);
                                mynumber.setValue(Vnumber);
                                mylocation.setValue(Vlocation);
                                mystime.setValue(Vstarttime);
                                myetime.setValue(Vendtime);
                                mydate.setValue(Vdate);

                                Toast.makeText(getApplicationContext(), "Course Added", Toast.LENGTH_SHORT).show();

                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();

                        dialog.show();

                    }

                    @Override
                    public void onCancelled(DatabaseError error){

                        DatabaseReference newcourse = Instructor.child(Vid);

                        DatabaseReference myid = newcourse.child("courseId");

                        DatabaseReference mynumber = newcourse.child("capacity");

                        DatabaseReference mylocation = newcourse.child("Location");

                        DatabaseReference mystime = newcourse.child("startTime");

                        DatabaseReference myetime = newcourse.child("endTime");

                        DatabaseReference mydate = newcourse.child("courseDate");

                        myid.setValue(Vid);
                        mynumber.setValue(Vnumber);
                        mylocation.setValue(Vlocation);
                        mystime.setValue(Vstarttime);
                        myetime.setValue(Vendtime);
                        mydate.setValue(Vdate);

                        Toast.makeText(getApplicationContext(), "Course Added", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent intent = new Intent(CourseAddActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }

}
