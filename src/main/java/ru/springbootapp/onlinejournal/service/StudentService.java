package ru.springbootapp.onlinejournal.service;

import ru.springbootapp.onlinejournal.entity.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student theStudent);

    public Student findByEmail(String email);

    public List<Student> getListStudent();

    /*vbbh*/
}
