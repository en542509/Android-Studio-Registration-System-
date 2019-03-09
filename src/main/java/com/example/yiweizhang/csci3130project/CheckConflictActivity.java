package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CheckConflictActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRefStudent, myRefCourse;

    private Button addCourseBtn, dropCourseBtn;

    private String currentCourseId;
    private TextView showInfoConflict;
    private String whichCourseList;
    private String timeIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_conflict);


        final TextView courseName = findViewById(R.id.show_course_name);
        final TextView courseInstructor = findViewById(R.id.show_course_instructor);
        final TextView coursePrequire = findViewById(R.id.show_pre_requirement);
        final TextView courseCapa = findViewById(R.id.show_capacity);

        // get course id from the intent
        Intent intent = getIntent();
        currentCourseId = intent.getStringExtra(CourseListAdapter.COURSE_ID);
        addCourseBtn = findViewById(R.id.click_add_course);
        dropCourseBtn = findViewById(R.id.click_drop_course);

        showInfoConflict = findViewById(R.id.check_time_conflict);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        // get the current student
        myRefStudent = database.getReference("student").child("B0011111");
        myRefCourse = database.getReference("course");


        myRefCourse.child(currentCourseId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Course currentCourse = dataSnapshot.getValue(Course.class);

                courseName.setText(currentCourse.getName());
                courseInstructor.setText(currentCourse.getInstructor());
                coursePrequire.setText(currentCourse.getPre_requirement());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // use course id to get course detail from firebase
        myRefCourse.child(currentCourseId).child("timeIndex").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // get index
                timeIndex = dataSnapshot.getValue(String.class);

                Log.i("test",  timeIndex);


                if (timeIndex.startsWith("tuesday")) {
                    // check student course list if contain this course
                    whichCourseList = "tuesday_courses";

                    checkConflict(whichCourseList, timeIndex, currentCourseId);

                } else {
                    whichCourseList = "monday_courses";
                    checkConflict(whichCourseList, timeIndex, currentCourseId);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void checkConflict(String whichCourseList, String timeIndex,
                                final String currentCourseId){

        // check student course list if contain this course
        myRefStudent.child(whichCourseList).child(timeIndex.toLowerCase())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String conflictOrNot = dataSnapshot.getValue(String.class);

                        if (conflictOrNot.equals("empty")){

                            Log.i("test", "conflict or not; " + conflictOrNot);

                            addCourseBtn.setEnabled(true);
                            dropCourseBtn.setEnabled(false);
                            showInfoConflict.setText("This course is not in your list. You can add it.");

                        } else if (conflictOrNot.equals(currentCourseId))
                        {
                            addCourseBtn.setEnabled(false);
                            dropCourseBtn.setEnabled(true);
                            showInfoConflict.setText("You already chose this course. You can drop it.");
                        }
                        else {
                            addCourseBtn.setEnabled(false);
                            dropCourseBtn.setEnabled(false);
                            showInfoConflict.setText("There is a time conflict.");
                        }

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }

    public void addCourseEvent(View view){
        // add to firebae
        if(whichCourseList != null) {
            // add course
            myRefStudent.child(whichCourseList).child(timeIndex.toLowerCase()).setValue(currentCourseId);
            // update the capacity
            if (currentCourseId != null) {
                myRefCourse.child(currentCourseId).child("capacity").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int capacity = dataSnapshot.getValue(Integer.class);
                        capacity--;
                        myRefCourse.child(currentCourseId).child("capacity").setValue(capacity);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

        }
        Toast.makeText(CheckConflictActivity.this,
                "add course successful!", Toast.LENGTH_LONG).show();
    }
    public void dropCourseEvent(View view){
        // remove from firebase
        if(whichCourseList != null){
            myRefStudent.child(whichCourseList).child(timeIndex.toLowerCase()).setValue("empty");

            // update the capacity
            if (currentCourseId != null){
                myRefCourse.child(currentCourseId).child("capacity").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int capacity = dataSnapshot.getValue(Integer.class);
                        capacity++;
                        myRefCourse.child(currentCourseId).child("capacity").setValue(capacity);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        }
        Toast.makeText(CheckConflictActivity.this,
                "drop course successful!", Toast.LENGTH_LONG).show();
    }

}
