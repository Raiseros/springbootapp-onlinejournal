package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.entity.Score;
import ru.springbootapp.onlinejournal.repository.JournalRepository;
import ru.springbootapp.onlinejournal.repository.ScoreRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class ScoreServiceImpl implements  ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;


    @Autowired
    private JournalRepository journalRepository;


    @Override
    public void saveScore(Score theScore, Journal theJournal) {
        Set<Journal> journal = new HashSet<>();
        journal.add(theJournal);
        theScore.setJournals(journal);
        scoreRepository.save(theScore);
    }

    @Override
    public void updateScore(Score theScore) {
        scoreRepository.updateJournal(theScore.getOverallScore(), theScore.getId());
    }
}
