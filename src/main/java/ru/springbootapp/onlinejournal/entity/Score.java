package ru.springbootapp.onlinejournal.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="overall_score")
    private long overallScore;


    @ManyToMany(mappedBy="scores")
    private Set<Course> courses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(long overallScore) {
        this.overallScore = overallScore;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Score() {
    }
}
