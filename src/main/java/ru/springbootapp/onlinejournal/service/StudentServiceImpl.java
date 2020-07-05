package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.repository.JournalRepository;
import ru.springbootapp.onlinejournal.repository.StudentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public void saveStudent(Student theStudent) {
        Set<Journal> journal = new HashSet<>();
        journal.addAll(journalRepository.findAllByClassnameStudent(theStudent.getClassName()));
        theStudent.getJournals().addAll(journal);
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
