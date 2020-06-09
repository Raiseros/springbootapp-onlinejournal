package ru.springbootapp.onlinejournal.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="study_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="course_name")
    private String courseName;

    @Column(name="class_name")
    private String className;

    @Column(name="school_building")
    private String schoolBuilding;

    @ManyToMany
    @JoinTable(name="course_scores", joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="score_id"))
    private Set<Score> scores;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public Course(String courseName, String className, String schoolBuilding) {
        this.courseName = courseName;
        this.className = className;
        this.schoolBuilding = schoolBuilding;
    }

    public Course() {
    }
}
