package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    public List<Student> getListStudent() {
        return studentRepository.getListStudent();
    }
}
