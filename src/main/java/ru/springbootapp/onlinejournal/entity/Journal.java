package ru.springbootapp.onlinejournal.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "journal")
public class Journal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "date_lesson")
    private String dateLesson;

    @Column(name = "number_lesson")
    private long numberLesson;

    @Column(name = "time_lesson")
    private long timeLesson;

    @Column(name = "fullname_course")
    private String fullnameCourse;

    @Column(name = "shortname_course")
    private String shortnameCourse;

    @Column(name = "class_name")
    private String className;

    @Column(name = "school_building")
    private String schoolBuilding;

    @Column(name = "homework")
    private String homework;

    @Column(name = "classname_student")
    private String classnameStudent;

    @Column(name = "time_break")
    private long timeBreak;

    @ManyToMany
    @JoinTable(name = "course_scores", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "score_id"))
    private Set<Score> scores;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateLesson() {
        return dateLesson;
    }

    public void setDateLesson(String dateLesson) {
        this.dateLesson = dateLesson;
    }

    public long getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(long numberLesson) {
        this.numberLesson = numberLesson;
    }

    public long getTimeLesson() {
        return timeLesson;
    }

    public void setTimeLesson(long timeLesson) {
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

    public long getTimeBreak() {
        return timeBreak;
    }

    public void setTimeBreak(long timeBreak) {
        this.timeBreak = timeBreak;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public Journal(String dateLesson, long numberLesson, long timeLesson, String fullnameCourse, String shortnameCourse,
                   String className, String schoolBuilding, String homework, String classnameStudent,
                   long timeBreak, Set<Score> scores) {
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
        this.scores = scores;
    }

    public Journal() {
    }
}

