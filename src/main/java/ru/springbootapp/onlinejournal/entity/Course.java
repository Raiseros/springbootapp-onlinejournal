package ru.springbootapp.onlinejournal.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="study_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id_course;

    @Column(name="course_name")
    private String courseName;

    @Column(name="course_short_name")
    private String courseShortName;

    @Column(name="class_name")
    private String className;

    @Column(name="school_building")
    private String schoolBuilding;

    @ManyToMany
    @JoinTable(name="course_scores", joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="score_id"))
    private List<Score> scores;

    public long getId_course() {
        return id_course;
    }

    public void setId_course(long id_course) {
        this.id_course = id_course;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public void setCourseShortName(String courseShortName) {
        this.courseShortName = courseShortName;
    }

    public Course(String courseName, String courseShortName, String className, String schoolBuilding,
                  List<Score> scores) {
        this.courseName = courseName;
        this.courseShortName = courseShortName;
        this.className = className;
        this.schoolBuilding = schoolBuilding;
        this.scores = scores;
    }

    public Course() {
    }

    /*bnn*/
}
