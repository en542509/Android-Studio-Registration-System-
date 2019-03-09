package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MajorAndTermActivity extends AppCompatActivity {

    public static final String COURSE_TERM = "TERM";
    public static final String COURSE_MAJOR = "MAJOR";


    private String majorType = "CS";
    private String termType = "winter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_term);
    }




    public void searchCourseBtn(View view){
        // get the term and major
        Toast.makeText(this, "term and major: " + termType + majorType, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MajorAndTermActivity.this, CourseListActivity.class);
        intent.putExtra(COURSE_TERM, termType);
        intent.putExtra(COURSE_MAJOR, majorType);
        startActivity(intent);

    }

    public void onRadioMajorClicked(View view){
        //
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_cs:
                if (checked)
                    majorType = "CS";
                break;
            case R.id.radio_economy:
                if(checked)
                    majorType = "ECON";
                break;
            case R.id.radio_chemistry:
                if(checked)
                    majorType = "CHEM";
                break;
        }
    }

    public void onRadioTermClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_winter:
                if (checked)
                    termType = "winter";
                break;
            case R.id.radio_summer:
                if (checked)
                    termType = "summer";
                break;
            case R.id.radio_fall:
                if (checked)
                    termType = "fall";
                break;
        }


    }





}
