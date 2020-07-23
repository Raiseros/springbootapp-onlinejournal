package ru.springbootapp.onlinejournal.service;


import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.entity.Score;


import java.util.List;

public interface ScoreService {

    public void saveScore(long scoreId, Journal theJournal, long studentId);
    public void updateScore(Journal theJournal, long scoreId, long studentId);
    public Score getScore(long theId, long studName);
    public List<Score> getScoreList();
}
