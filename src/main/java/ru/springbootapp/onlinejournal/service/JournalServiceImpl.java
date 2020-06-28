package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.repository.JournalRepository;


import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public List<Journal> getJournals() {
        return journalRepository.findAll(Sort.by(Sort.Direction.ASC, "dateLesson","numberLesson"));
    }

    @Override
    public void saveJournal(Journal theJournal) {
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
        return journalRepository.findAllByClassnameStudent(classNameStudent);
    }

    @Override
    public List<String> getListDateLesson() {
        return journalRepository.getListDateLesson();
    }

    @Override
    public List<Journal> getListByDateLesson(String dateLesson) {
        return journalRepository.getListByDateLesson(dateLesson);
    }

    @Override
    public List<Journal> getListByClassnameStudentAndByDateLesson(String classNameStudent, String dateLesson) {
        return journalRepository.getListByClassnameStudentAndByDateLesson(classNameStudent, dateLesson);
    }
}
