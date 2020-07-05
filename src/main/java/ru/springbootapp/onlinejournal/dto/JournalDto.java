package ru.springbootapp.onlinejournal.dto;

import java.util.Date;

public class JournalDto{

    long journalId;

    Date dateLesson;

    long numberLesson;

    String timeLesson;

    String fullnameCourse;

    String shortnameCourse;

    String className;

    String schoolBuilding;

    String homework;

    String classnameStudent;

    String timeBreak;

    long overallScore;


    public long getJournalId() {
        return journalId;
    }

    public void setJournalId(long journalId) {
        this.journalId = journalId;
    }

    public Date getDateLesson() {
        return dateLesson;
    }

    public void setDateLesson(Date dateLesson) {
        this.dateLesson = dateLesson;
    }

    public long getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(long numberLesson) {
        this.numberLesson = numberLesson;
    }

    public String getTimeLesson() {
        return timeLesson;
    }

    public void setTimeLesson(String timeLesson) {
        this.timeLesson = timeLesson;
    }

    public String getFullnameCourse() {
        return fullnameCourse;
    }

    public void setFullnameCourse(String fullnameCourse) {
        this.fullnameCourse = fullnameCourse;
    }

    public String getShortnameCourse() {
        return shortnameCourse;
    }

    public void setShortnameCourse(String shortnameCourse) {
        this.shortnameCourse = shortnameCourse;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolBuilding() {
        return schoolBuilding;
    }

    public void setSchoolBuilding(String schoolBuilding) {
        this.schoolBuilding = schoolBuilding;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getClassnameStudent() {
        return classnameStudent;
    }

    public void setClassnameStudent(String classnameStudent) {
        this.classnameStudent = classnameStudent;
    }

    public String getTimeBreak() {
        return timeBreak;
    }

    public void setTimeBreak(String timeBreak) {
        this.timeBreak = timeBreak;
    }

    public long getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(long overallScore) {
        this.overallScore = overallScore;
    }

    public JournalDto(long journalId, Date dateLesson, long numberLesson, String timeLesson, String fullnameCourse,
                      String shortnameCourse, String className, String schoolBuilding, String homework,
                      String classnameStudent, String timeBreak, long overallScore) {
        this.journalId = journalId;
        this.dateLesson = dateLesson;
        this.numberLesson = numberLesson;
        this.timeLesson = timeLesson;
        this.fullnameCourse = fullnameCourse;
        this.shortnameCourse = shortnameCourse;
        this.className = className;
        this.schoolBuilding = schoolBuilding;
        this.homework = homework;
        this.classnameStudent = classnameStudent;
        this.timeBreak = timeBreak;
        this.overallScore = overallScore;
    }

    public JournalDto() {
    }
}
