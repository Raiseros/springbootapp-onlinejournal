package ru.springbootapp.onlinejournal.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="role")
    private String role;

    @Column(name="last_name")
    @NotNull
    @Size(min=3, max=15, message="length should be in between 3 to 15")
    @Pattern(regexp = "^[A-Za-z]+$", message = "please write in english language")
    private String lastName;

    @Column(name="first_name")
    @NotNull
    @Size(min=2, max=10, message="length should be in between 2 to 10")
    @Pattern(regexp = "^[A-Za-z]+$", message = "please write in english language")
    private String firstName;

    @Column(name="middle_name")
    @NotNull
    @Size(min=5, max=15, message="length should be in between 5 to 15")
    @Pattern(regexp = "^[A-Za-z]+$", message = "please write in english language")
    private String middleName;

    @Column(name="email")
    @NotEmpty(message="Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)+\\.+(ru|com)$", message="Invalid email pattern")
    @Pattern(regexp = "^[a-z0-9_.@-]+$", message = "please write in english language with small letters")
    private String email;

    @Column(name="password")
    @NotEmpty(message="password field should not be empty")
    @Size(min=3, max=8, message="length shoud be in between 3 to 8")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "please write in english language")
    private String password;

    @Transient
    @NotEmpty(message="password field should not be empty")
    @Size(min=3, max=8, message="length shoud be in between 3 to 8")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "please write in english language")
    private String confirmPassword;

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

    public Teacher(String role, String lastName, String firstName, String middleName, String email,
                   String password, String confirmPassword) {
        this.role = role;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Teacher() {
    }

//    bnn
}
