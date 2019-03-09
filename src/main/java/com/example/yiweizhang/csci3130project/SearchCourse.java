package com.example.yiweizhang.csci3130project;

/**
 * Created by Shuo Yang on 2018/3/21.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchCourse extends AppCompatActivity {
    private Button CSCI;
    private Button ENGL;
    private Button FRENC;
    private Button MATH;
    private Button STAT;
    Course receivedcourse;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String courseId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchcourse);
        receivedcourse = (Course)getIntent().getSerializableExtra("Course");
        CSCI = findViewById(R.id.CSCI);
        ENGL = findViewById(R.id.ENGL);
        FRENC = findViewById(R.id.FRENC);
        MATH = findViewById(R.id.MATH);
        STAT = findViewById(R.id.STAT);
        ENGL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchen();
            }
        });
        FRENC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {searchfe();
            }
        });
        MATH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchma();
            }
        });
        STAT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchst();
            }
        });
        CSCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchcs();
            }
        });
    }
    private void searchcs(){
        Intent intent = new Intent(SearchCourse.this, CSCI.class);
        startActivity(intent);
    }
    private void searchen(){

    }
    private void searchfe(){

    }
    private void searchma(){

    }
    private void searchst(){

    }
}