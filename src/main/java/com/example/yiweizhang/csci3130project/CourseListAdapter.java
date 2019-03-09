package com.example.yiweizhang.csci3130project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yunfei on 2018-03-07.
 */

class CourseListAdapter extends ArrayAdapter<Course>{

    public static final String COURSE_ID = "COURSEID";

    private Activity context;
    private List<Course> avaliableCourses;

    public CourseListAdapter(@NonNull Activity context, List<Course> avaliableCourses) {
        super(context, R.layout.content_course_layout, avaliableCourses);

        this.context = context;
        this.avaliableCourses = avaliableCourses;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View contentCourse = inflater.inflate(R.layout.content_course_layout, null, true);

        // get view
        TextView courseName = contentCourse.findViewById(R.id.show_course_name);
        TextView courseInstructor = contentCourse.findViewById(R.id.show_course_instructor);
        TextView startTime = contentCourse.findViewById(R.id.show_startTime);
        TextView endTime = contentCourse.findViewById(R.id.show_endTime);
        TextView capatity = contentCourse.findViewById(R.id.show_capacity);
        TextView courseDate = contentCourse.findViewById(R.id.show_date);
        TextView coursepreRequirement = contentCourse.findViewById(R.id.show_pre_requirement);

        // get course
        final Course course = avaliableCourses.get(position);

        // set view
            courseName.setText(course.getName());
            courseInstructor.setText(course.getInstructor());
            startTime.setText(course.getStartTime() + "");

        endTime.setText(course.getEndTime() + "");
        capatity.setText(course.getCapacity() + "");
        coursepreRequirement.setText(course.getPre_requirement());

        String date = course.getCourseDate();
        Log.i("test", date);

        if( date.startsWith("M")){
           courseDate.setText("Monday, Wednesday, Friday");
       } else {
           courseDate.setText("Tuesday, Thursday");

       }


        return contentCourse;

    }
}
