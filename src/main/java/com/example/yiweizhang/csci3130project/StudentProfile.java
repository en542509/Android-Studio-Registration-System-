package com.example.yiweizhang.csci3130project;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by phili on 2018-02-27.
 */

public class StudentProfile {

    private String student;
    private String studentID;

    private Set<Course> selectedCourses = new HashSet<>();


    public String getStudent() {
        return student;
    }

    public void addCourse(Course course){
        selectedCourses.add(course);
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Set<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(Set<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }
}
