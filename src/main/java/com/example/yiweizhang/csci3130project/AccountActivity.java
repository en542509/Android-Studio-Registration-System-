package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by denghaohai on 25/02/2018.
 */

public class AccountActivity extends AppCompatActivity {
    private Button register;
    private Button logout;
    private Button courseTimeTable;
    private Button showSchedule;
    private Button updatePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_page);

        courseTimeTable = findViewById(R.id.timeTable);
        showSchedule = findViewById(R.id.weeklySchedule);

        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, AccountRegistrationActivity.class);
                startActivity(intent);

            }
        });
        updatePhoto=findViewById(R.id.button3);
        updatePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, Updatephoto.class);
                startActivity(intent);

            }
        });
        logout = (Button)findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        showSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, WeeklyScheduleActivity.class);
                startActivity(intent);

            }
        });

        courseTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load all course from firebase
                Intent intent = new Intent(AccountActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });

    }
}
