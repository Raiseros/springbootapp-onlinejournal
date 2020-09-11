package ru.springbootapp.onlinejournal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.repository.JournalRepository;
import ru.springbootapp.onlinejournal.repository.StudentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

    @Override
    public List<Student> getListStudent() {
        return studentRepository.getListStudent();
    }


    @Override
    public List<Student> getAllStudentsByClassName(String className) {
        return studentRepository.findAllByClassName(className);
    }

    @Override
    public List<Student> getFullListStudent() {
        return studentRepository.getFullListStudent();
    }

    @Override
    public void updateStudent(Student theStudent, String className) {

        studentRepository.updateStudent(theStudent.getLastName(),theStudent.getFirstName(),theStudent.getMiddleName(),
                theStudent.getClassName(), theStudent.getEmail(), theStudent.getPassword(), theStudent.getId());

        if(true != className.equalsIgnoreCase(theStudent.getClassName())) {
            studentRepository.deleteStudentClass(theStudent.getId());
            Set<Journal> journal = new HashSet<>();
            journal.addAll(journalRepository.findAllByClassnameStudent(theStudent.getClassName()));

            for (Journal theJournal : journal) {
                studentRepository.updateStudentClass(theJournal.getId(), theStudent.getId());
            }
        }
    }


    @Override
    public Student getStudent(long theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if(result.isPresent()){
            theStudent = result.get();

        } else{
            throw new RuntimeException("Did not find student id - " + theId);
        }

        return theStudent;


    }

    @Override
    public void deleteStudent(long theId) {

        studentRepository.deleteById(theId);
    }

    @Override
    public void deleteJournalScoreByStudentId(long theId) {
        studentRepository.deleteJournalScoreByStudentId(theId);
    }

    @Override
    public void deleteJournalStudentsByStudentId(long theId) {
        studentRepository.deleteJournalStudentsByStudentId(theId);
    }

}
