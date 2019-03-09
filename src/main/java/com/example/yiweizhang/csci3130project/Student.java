package com.example.yiweizhang.csci3130project;

import java.util.Map;

/**
 * Created by yunfei on 2018-03-05.
 */

public class Student {
    private String studentId;
    private String gender;
    private double GPA;
    private String pictureId;
    private boolean waitListCheck;
    private String name;
    private Map<String, String> monday_courses;
    private Map<String, String> tuesday_courses;

    private int tuition = 11000;


    public Student(){

    }

    public Student(String studentId, String gender, double GPA, String pictureId, String name,
                   Map<String, String> selectedCourse, Map<String, String> tuesday_courses, int tuition) {
        this.studentId = studentId;
        this.gender = gender;
        this.GPA = GPA;
        this.pictureId = pictureId;
        this.name = name;
        this.monday_courses = selectedCourse;
        this.tuesday_courses = tuesday_courses;
        this.tuition = tuition;
    }

    public int getTuition() {return tuition;}

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getMonday_courses() {
        return monday_courses;
    }

    public void setMonday_courses(Map<String, String> monday_courses) {
        this.monday_courses = monday_courses;
    }

    public Map<String, String> getTuesday_courses() {
        return tuesday_courses;
    }

    public void setTuesday_courses(Map<String, String> tuesday_courses) {
        this.tuesday_courses = tuesday_courses;
    }
}
