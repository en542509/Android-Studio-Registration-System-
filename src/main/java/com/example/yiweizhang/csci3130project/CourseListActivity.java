package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CourseListActivity extends AppCompatActivity {

    private String termType;
    private String majorType;

    private ListView courseList;

    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Course> allCourses = new ArrayList<>();
    List<Course> termMajorCourses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        Intent intent = getIntent();
        majorType = intent.getStringExtra(MajorAndTermActivity.COURSE_MAJOR);
        termType = intent.getStringExtra(MajorAndTermActivity.COURSE_TERM);


        courseList = findViewById(R.id.course_list);


//                String courseId = clickedCourse.getCourseId();
//                //
//                Intent intent = new Intent(getApplicationContext(), CheckConflictActivity.class);
//                intent.putExtra(COURSE_ID, courseId);
//                startActivity(intent);
//
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("course");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                allCourses.clear();
                // read each course
                for (DataSnapshot courseSnap : dataSnapshot.getChildren()) {

                    Course theCourse = courseSnap.getValue(Course.class);

                    if(theCourse.getTerm().equals(termType) && theCourse.getSubject().equals(majorType)){
                        // the current major and term
                        termMajorCourses.add(theCourse);
                    }


                    //
                    allCourses.add(theCourse);
                }

                if(!termMajorCourses.isEmpty()){
                    CourseListAdapter courseListAdapter = new CourseListAdapter(CourseListActivity.this, termMajorCourses);
                    courseList.setAdapter(courseListAdapter);

                } else {
                    // no course at selected condition
                    Toast.makeText(getApplicationContext(),
                            "The course schedule is not ready yet for Subject on: " +  majorType
                                    +", and term at: "+ termType, Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
