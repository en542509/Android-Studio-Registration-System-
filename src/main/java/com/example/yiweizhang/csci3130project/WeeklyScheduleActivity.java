package com.example.yiweizhang.csci3130project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.github.lzyzsd.randomcolor.RandomColor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class WeeklyScheduleActivity extends AppCompatActivity {

    private FirebaseDatabase database;

    // code from Github
    // https://github.com/lzyzsd/AndroidRandomColor
    RandomColor randomColor = new RandomColor();
    int[] backColor = randomColor.randomColor(10);

    private List<String> mondaySchedule = new ArrayList<>();
    private List<String> tuesdaySchedule = new ArrayList<>();

    private DatabaseReference myRef;
    private DatabaseReference mDatabaseCourses;
    private TextView Mon1,Mon2,Mon3,Mon4, Mon5,Tue1,Tue2,Tue3,Tue4, Tue5 ,Wed1,Wed2,Wed3,Wed4, Wed5,Thu1,Thu2,Thu3,Thu4, Thu5,Fri1,Fri2,Fri3,Fri4, Fri5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_schedule);

       // gridLayout = findViewById(R.id.gridlayout);

        Mon1 = findViewById(R.id.monday_0);
        Mon2 = findViewById(R.id.monday_1);
        Mon3 = findViewById(R.id.monday_2);
        Mon4 = findViewById(R.id.monday_3);
        Mon5 = findViewById(R.id.monday_4);

        Tue1 = findViewById(R.id.tuesday_0);
        Tue2 = findViewById(R.id.tuesday_1);
        Tue3 = findViewById(R.id.tuesday_2);
        Tue4 = findViewById(R.id.tuesday_3);
        Tue5 = findViewById(R.id.tuesday_4);

        Wed1 = findViewById(R.id.wen_0);
        Wed2 = findViewById(R.id.wen_1);
        Wed3 = findViewById(R.id.wen_2);
        Wed4 = findViewById(R.id.wen_3);
        Wed5 = findViewById(R.id.wen_4);

        Thu1 = findViewById(R.id.thursday_0);
        Thu2 = findViewById(R.id.thursday_1);
        Thu3 = findViewById(R.id.thursday_2);
        Thu4 = findViewById(R.id.thursday_3);
        Thu5 = findViewById(R.id.thursday_4);

        Fri1 = findViewById(R.id.friday_0);
        Fri2 = findViewById(R.id.friday_1);
        Fri3 = findViewById(R.id.friday_2);
        Fri4 = findViewById(R.id.friday_3);
        Fri5 = findViewById(R.id.friday_4);

        mondaySchedule.add("monday_0");
        mondaySchedule.add("monday_1");
        mondaySchedule.add("monday_2");
        mondaySchedule.add("monday_3");
        mondaySchedule.add("monday_4");

        tuesdaySchedule.add("tuesday_0");
        tuesdaySchedule.add("tuesday_1");
        tuesdaySchedule.add("tuesday_2");
        tuesdaySchedule.add("tuesday_3");
        tuesdaySchedule.add("tuesday_4");



    }

    @Override
    protected void onStart() {
        super.onStart();
        updateUI();


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void updateUI() {

        final TextView[] mondayView = {Mon1, Mon2,Mon3, Mon4, Mon5};
        final TextView[] tuesdayView = {Tue1, Tue2,Tue3,Tue4,Tue5};

        // database
        database = FirebaseDatabase.getInstance();
        mDatabaseCourses = database.getReference("course");

        // get the current student
        myRef = database.getReference("student").child("B0011111");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {

                    Student currentStudent = dataSnapshot.getValue(Student.class);

                    Map<String, String> monday_map_schedule = currentStudent.getMonday_courses();
                    replaceUI(monday_map_schedule, mondayView, mondaySchedule, true);

                    // tuesday
                    Map<String, String> tuesday_map_schedule = currentStudent.getTuesday_courses();
                    replaceUI(tuesday_map_schedule, tuesdayView, tuesdaySchedule, false);



                }catch (Exception e){
                    Log.i("test", e + "");
                    finish();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void replaceUI(Map<String, String> map_schedule, final TextView[] arrayView, List<String> schedule, final boolean onMonday){

        final TextView[] wendesView = {Wed1,Wed2,Wed3,Wed4,Wed5};
        final TextView[] thursdayView = {Thu1,Thu2,Thu3,Thu4,Thu5};
        final TextView[] fridayView = {Fri1,Fri2,Fri3,Fri4,Fri5};


        for(Map.Entry<String, String> entry : map_schedule.entrySet()){
            String key = entry.getKey();
            final String courseId = entry.getValue();

            if(courseId != null && !courseId.equals("empty")){

                final int index = schedule.indexOf(key);

                // fetch each course which the student has choosed
                // by courseID;
                mDatabaseCourses.child(courseId).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Course currentCourse = dataSnapshot.getValue(Course.class);
                        // get course info
                        String courseInfo = currentCourse.getName() + "\n" + "Location: "+ "\n" + currentCourse.getPlace();
                        //  mondaySchedule.add(index, courseInfo);

                        arrayView[index].setText(courseInfo);

                        if(onMonday){

                            arrayView[index].setTextColor(backColor[index]);
                            // wendesday,
                            wendesView[index].setText(courseInfo);
                            wendesView[index].setTextColor(backColor[index]);

                            fridayView[index].setText(courseInfo);
                            fridayView[index].setTextColor(backColor[index]);

                        } else {
                            arrayView[index].setTextColor(backColor[index + 5]);
                            // tuesday, friday
                            thursdayView[index].setText(courseInfo);
                            thursdayView[index].setTextColor(backColor[index + 5]);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            } else {
                int index = schedule.indexOf(key);
                // mondaySchedule.add(index, "empty");
            }

        }
    }
}
