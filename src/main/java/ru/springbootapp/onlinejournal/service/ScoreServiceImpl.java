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
    public void saveScore(long scoreId, Journal theJournal, long studentId) {
        Set<Journal> journal = new HashSet<>();
        journal.add(theJournal);
        Optional<Student> result = studentRepository.findById(studentId);
        Student theStudent = result.get();
        Set<Student> student = new HashSet<>();
        student.add(theStudent);

         /*theStudent.getJournalStudentScore().put(theJournal, theScore);*/
       scoreRepository.updateJournalStudentScore(theJournal.getId(), theStudent.getId(), scoreId);

    }

    @Override
    public void updateScore(Journal theJournal, long scoreId, long studentId) {
        /*Optional<Score> resultScore = scoreRepository.findById(scoreId);
        Score theScore = resultScore.get();

        Optional<Student> resultStudent = studentRepository.findById(studentId);
        Student theStudent = resultStudent.get();

        theStudent.getJournalStudentScore().put(theJournal, theScore);*/

         scoreRepository.updateJournal(theJournal.getId(), scoreId, studentId );
    }

    @Override
    public Score getScore(long theId, long studName) {

        List<Score> theScore = scoreRepository.getScore(theId, studName);

        Score score = theScore.get(0);
        return score;
    }

    @Override
    public List<Score> getScoreList() {

        return scoreRepository.getScoreList();
    }



}
