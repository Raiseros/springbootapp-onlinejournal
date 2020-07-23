package ru.springbootapp.onlinejournal.service;

import ru.springbootapp.onlinejournal.entity.Journal;


import java.util.List;


public interface JournalService {
    public List<Journal> getJournals();

    public void saveJournal(Journal theJournal);

    public void updateJournal(Journal theJournal);

    public List<String> getListClassnameStudent();

    public List<Journal> getJournalClassNameStudentList(String classNameStudent);

    public List<String> getListDateLesson();

    public List<Journal> getListByDateLesson(String dateLesson);

    public List<Journal> getListByClassnameStudentAndByDateLesson(String classNameStudent, String dateLesson);

    public List<Journal> getJournalListByStudent(long studentName);

    public List<Journal> getListByStudentNameAndByDateLesson(long studentName, String dateLesson);

    public Journal getJournal(long theId);

    public void deleteJournal(long theId);

}