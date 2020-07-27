package ru.springbootapp.onlinejournal.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id_sc;

    @Column(name="overall_score")
    private long overallScore;


    @ManyToMany
    @JoinTable(name="course_scores", joinColumns=@JoinColumn(name="score_id"),
            inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses;





    public long getId_sc() {
        return id_sc;
    }

    public void setId_sc(long id_sc) {
        this.id_sc = id_sc;
    }

    public long getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(long overallScore) {
        this.overallScore = overallScore;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public Score() {
    }

    public Score(long overallScore, List<Course> courses){
        this.overallScore = overallScore;

        this.courses = courses;

    }

    /*nm*/
}
