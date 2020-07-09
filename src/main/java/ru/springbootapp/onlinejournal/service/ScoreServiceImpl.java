package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.entity.Score;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.repository.JournalRepository;
import ru.springbootapp.onlinejournal.repository.ScoreRepository;
import ru.springbootapp.onlinejournal.repository.StudentRepository;

import java.util.*;


@Service
public class ScoreServiceImpl implements  ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;


    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private StudentRepository studentRepository;



    @Override
    public void saveScore(Score theScore, Journal theJournal, long studentId) {
        Set<Journal> journal = new HashSet<>();
        journal.add(theJournal);
        theScore.setJournals(journal);
        Optional<Student> result = studentRepository.findById(studentId);
        Student theStudent = result.get();
        Set<Student> student = new HashSet<>();
        student.add(theStudent);
        theScore.setStudents(student);
        scoreRepository.save(theScore);
    }

    @Override
    public void updateScore(Score theScore) {
        scoreRepository.updateJournal(theScore.getOverallScore(), theScore.getId_sc());
    }

    @Override
    public Score getScore(long theId) {

        List<Score> theScore = scoreRepository.getScore(theId);

        Score score = theScore.get(0);
        return score;
    }
}
