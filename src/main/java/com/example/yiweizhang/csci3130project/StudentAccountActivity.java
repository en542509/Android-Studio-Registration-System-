package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Shuo Yang enlin chen on 2018/3/21.
 */

public class StudentAccountActivity extends AppCompatActivity {

    private Button profile;
    private Button register;
    private Button logout;
    private Button courseTimeTable;
    private Button showSchedule;
    private Button updatePhoto;
    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_account);

          courseTimeTable = findViewById(R.id.timeTable1);

        showSchedule = (Button) findViewById(R.id.student_week_schedule);
        showSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentAccountActivity.this, WeeklyScheduleActivity.class);
                startActivity(intent);

            }
        });

        //set on click to student account detail
        profile = (Button)findViewById(R.id.profile1);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentAccountActivity.this, StudentAccountDetail.class);
                startActivity(intent);

            }
        });

        updatePhoto=(Button)findViewById(R.id.update);
        updatePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentAccountActivity.this, Updatephoto.class);
                startActivity(intent);
            }
        });
        search=(Button)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentAccountActivity.this, SearchCourse.class);
                startActivity(intent);
            }
        });

//        //need to fixed in iteration 3
//        register = (Button)findViewById(R.id.register);
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(StudentAccountActivity.this, AccountRegistrationActivity.class);
//                startActivity(intent);
//
//            }
//        });
//        logout = (Button)findViewById(R.id.Logout);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(StudentAccountActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//
//

//
        courseTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load all course from firebase
                Intent intent = new Intent(StudentAccountActivity.this, MajorAndTermActivity.class);
                startActivity(intent);
            }
        });


    }
}
