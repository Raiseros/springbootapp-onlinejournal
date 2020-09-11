package ru.springbootapp.onlinejournal.service;

import ru.springbootapp.onlinejournal.entity.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student theStudent);

    public Student findByEmail(String email);

    public List<Student> getListStudent();

    public List<Student> getFullListStudent();

    public List<Student> getAllStudentsByClassName(String className);

    public void updateStudent(Student theStudent, String className);

    public Student getStudent(long theId);

    public void deleteStudent(long theId);

    public void deleteJournalScoreByStudentId(long theId);

    public void deleteJournalStudentsByStudentId(long theId);
}
