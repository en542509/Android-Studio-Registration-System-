package com.example.yiweizhang.csci3130project;

import java.util.List;

/**
 * Created by chenenlin on 18/2/24.
 */

public class Course {
        private int capacity;
        private String courseDate;
        private String courseId;
        private String startTime;
        private String endTime;
        private String instructor;
        private String name;
        private String pre_requirement;
        private String subject;
        private String term;
        private double tuition;
        private int waitingList;
        private String timeIndex;
        private String place;
        private List<String> Wlist_list;

        public Course(){
        }

        public Course(int capacity, String courseDate, String courseId, String startTime, String endTime, String timeIndex,
                  String instructor, String name, String pre_requirement,
                  String subject, double tuition, int waitingList, String place, List<String> wlist_list, String term) {
        this.capacity = capacity;
        this.courseDate = courseDate;
        this.courseId = courseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructor = instructor;
        this.name = name;
        this.pre_requirement = pre_requirement;
        this.subject = subject;
        this.tuition = tuition;
        this.waitingList = waitingList;
        this.timeIndex = timeIndex;
        this.place = place;
        this.Wlist_list = wlist_list;
        this.term = term;
    }

    @Override
    public String toString() {
        return courseId + "\n" + name + "\n" +
                startTime + " - " + endTime + "\n" + place;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPre_requirement() {
        return pre_requirement;
    }

    public void setPre_requirement(String pre_requirement) {
        this.pre_requirement = pre_requirement;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public int getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(int waitingList) {
        this.waitingList = waitingList;
    }

    public String getTimeIndex() {
        return timeIndex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getWlist_list() {
        return Wlist_list;
    }

    public void setTimeIndex(String timeIndex) {
        this.timeIndex = timeIndex;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setWlist_list(List<String> wlist_list) {
        Wlist_list = wlist_list;
    }
}


