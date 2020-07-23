package ru.springbootapp.onlinejournal.entity;





import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.util.*;



@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="role")
    private String role;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="class_name")
    private String className;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Transient
    private String confirmPassword;



    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "journal_students", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "journal_id"))
    private Set<Journal> journals = new HashSet<>();


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "journal_student_score", joinColumns = {

            @JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "score_id")})
            @MapKeyJoinColumn(name = "journal_id")
    private Map<Journal, Score> journalStudentScore = new HashMap<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Set<Journal> journals) {
        this.journals = journals;
    }


    public Map<Journal, Score> getJournalStudentScore() {
        return journalStudentScore;
    }

    public void setJournalStudentScore(Map<Journal, Score> journalStudentScore) {
        this.journalStudentScore = journalStudentScore;
    }

    public Student() {
    }

    public Student(String role, String lastName, String firstName, String middleName, String className,
                   String email, String password, String confirmPassword, Set<Journal> journals,
                   Map<Journal, Score> journalStudentScore) {
        this.role = role;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.className = className;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.journals = journals;
        this.journalStudentScore = journalStudentScore;
    }
}
