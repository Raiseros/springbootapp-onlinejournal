package ru.springbootapp.onlinejournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.entity.Score;

import java.util.List;


@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Score SET overall_score = :overallScore  WHERE id = :id")
    void updateJournal(long overallScore, long id);

    @Transactional
    @Modifying
    @Query(value = "SELECT scores.* FROM scores, journal_scores WHERE journal_scores.journal_id = :theId" +
            " AND journal_scores.score_id=scores.id", nativeQuery=true)
    List<Score> getScore(long theId);

}
