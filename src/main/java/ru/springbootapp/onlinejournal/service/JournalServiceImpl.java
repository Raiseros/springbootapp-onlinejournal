package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Journal> getJournals() {
        return journalRepository.findAll(Sort.by(Sort.Direction.ASC, "dateLesson","numberLesson"));
    }

    @Override
    public void saveJournal(Journal theJournal) {
        Set<Student> theStudent = new HashSet<>();
        theStudent.addAll(studentRepository.findAllByClassName(theJournal.getClassnameStudent()));
        theJournal.getStudents().addAll(theStudent);

      journalRepository.save(theJournal);
    }

    @Override
    public void updateJournal(Journal theJournal) {
        journalRepository.updateJournal(theJournal.getDateLesson(), theJournal.getNumberLesson(),
                theJournal.getTimeLesson(), theJournal.getFullnameCourse(), theJournal.getShortnameCourse(),
                theJournal.getClassName(), theJournal.getSchoolBuilding(), theJournal.getHomework(),
                theJournal.getClassnameStudent(), theJournal.getTimeBreak(), theJournal.getId());
    }

    @Override
    public List<String> getListClassnameStudent() {
        return journalRepository.getListClassnameStudent();
    }

    @Override
    public List<Journal> getJournalClassNameStudentList(String classNameStudent) {
        return journalRepository.findAllByClassnameStudentOrderByDateLessonAscNumberLessonAsc(classNameStudent);
    }

    @Override
    public List<String> getListDateLesson() {
        return journalRepository.getListDateLesson();
    }

    @Override
    public List<String> getDateLessonMonthList() {
        return journalRepository.getDateLessonMonthList();
    }

    @Override
    public List<Journal> getListFullFormatDateLesson() {
        return journalRepository.getListFullFormatDateLesson();
    }

    @Override
    public List<Journal> getListByDateLesson(String dateLesson) {
        return journalRepository.getListByDateLesson(dateLesson);
    }


    @Override
    public List<Journal> getListByClassnameStudentAndByDateLesson(String classNameStudent, String dateLesson) {
        return journalRepository.getListByClassnameStudentAndByDateLesson(classNameStudent, dateLesson);
    }

    @Override
    public List<Journal> getJournalListByStudent(long studentName) {
        return journalRepository.getJournalListByStudent(studentName);
    }

    @Override
    public List<Journal> getListByStudentNameAndByDateLesson(long studentName, String dateLesson) {
        return journalRepository.getListByStudentNameAndByDateLesson(studentName, dateLesson);
    }

    @Override
    public Journal getJournal(long theId) {
        Optional<Journal> result = journalRepository.findById(theId);

        Journal theJournal = null;

        if(result.isPresent()){
            theJournal = result.get();

        } else{
            throw new RuntimeException("Did not find student id - " + theId);
        }

        return theJournal;

    }

    @Override
    public void deleteJournal(long theId) {

        journalRepository.deleteById(theId);
    }

    @Override
    public void deleteJournalScore(long theId, long idStudName) {

        journalRepository.deleteJournalScore(theId, idStudName);

    }

    @Override
    public void deleteJournalScoreByJournalId(long theId) {
        journalRepository.deleteJournalScoreByJournalId(theId);
    }

    /* vbh*/

}
