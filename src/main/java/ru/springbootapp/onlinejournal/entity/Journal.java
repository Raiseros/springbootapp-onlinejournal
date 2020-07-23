package ru.springbootapp.onlinejournal.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "journal")
public class Journal implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_lesson")
    private java.util.Date dateLesson;

    @Column(name = "number_lesson")
    private long numberLesson;

    @Column(name = "time_lesson")
    private String timeLesson;

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
    private String timeBreak;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "journal_students", joinColumns = @JoinColumn(name = "journal_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students = new HashSet<>();



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }



    public Journal() {
    }

    public Journal(Date dateLesson, long numberLesson, String timeLesson, String fullnameCourse,
                   String shortnameCourse, String className, String schoolBuilding, String homework,
                   String classnameStudent, String timeBreak, Set<Student> students ) {
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
        this.students = students;
    }
}

