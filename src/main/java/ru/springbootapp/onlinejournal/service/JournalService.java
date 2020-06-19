package ru.springbootapp.onlinejournal.service;

import ru.springbootapp.onlinejournal.entity.Journal;

import java.util.List;

public interface JournalService {
    public List<Journal> getJournals();
    public void saveJournal(Journal theJournal);
    public void updateJournal(Journal theJournal);
}
