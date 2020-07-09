package ru.springbootapp.onlinejournal.entity;

import javax.persistence.*;
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

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "journal_scores", joinColumns = @JoinColumn(name = "score_id"),
            inverseJoinColumns = @JoinColumn(name = "journal_id"))
    private Set<Journal> journals;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "student_scores", joinColumns = @JoinColumn(name = "score_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;

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

    public Set<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Set<Journal> journals) {
        this.journals = journals;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Score(long overallScore, Set<Journal> journals, Set<Student> students, List<Course> courses) {
        this.overallScore = overallScore;
        this.journals = journals;
        this.students = students;
        this.courses = courses;
    }

    public Score() {
    }
}
