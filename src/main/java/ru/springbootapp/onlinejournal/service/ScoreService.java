package ru.springbootapp.onlinejournal.service;


import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.entity.Score;

public interface ScoreService {

    public void saveScore(Score theScore, Journal theJournal);
    public void updateScore(Score theScore);
}
