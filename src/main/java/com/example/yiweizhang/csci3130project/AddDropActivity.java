package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddDropActivity extends AppCompatActivity {
    private TextView ClassInformation;
    private Button AddClassBtn;
    private Button DropClassBtn;
    private ListView courseList;

    FirebaseDatabase database;
    DatabaseReference myRef;
    String courseId;

    List<String> courseNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drop);

        // GET
        Intent intent = getIntent();
        courseId = intent.getStringExtra(CourseListAdapter.COURSE_ID);

        ClassInformation=findViewById(R.id.currentCourse);
        AddClassBtn=findViewById(R.id.AddClassbtn);
        DropClassBtn=findViewById(R.id.DropClassBtn);
        courseList=findViewById(R.id.chooseCourselist);

        // firebase
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("course");
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}
