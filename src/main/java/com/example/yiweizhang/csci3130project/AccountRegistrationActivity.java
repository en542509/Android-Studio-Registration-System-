package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by denghaohai on 09/03/2018.
 */

public class AccountRegistrationActivity extends AppCompatActivity {

    private Button mycourse;
    private Button addcourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_page_registration);

        mycourse = (Button) findViewById(R.id.my_course);
        mycourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountRegistrationActivity.this, Instructor_mycourse.class);
                startActivity(intent);
            }
        });
        addcourse = (Button) findViewById(R.id.Add_new_course);
        addcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountRegistrationActivity.this, CourseAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
