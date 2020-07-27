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
    @Query(value = "UPDATE journal_student_score SET score_id = :scoreId  WHERE student_id = :studentId AND" +
            " journal_id=:journalId", nativeQuery=true)
    void updateJournal(long journalId, long scoreId, long studentId);

    @Transactional
    @Modifying
    @Query(value = "SELECT scores.* FROM scores, journal_student_score WHERE journal_student_score.journal_id = :theId" +
            " AND journal_student_score.student_id = :studName AND journal_student_score.score_id=scores.id", nativeQuery=true)
    List<Score> getScore(long theId, long studName);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO journal_student_score   (journal_id, student_id, score_id) VALUES" +
            " (:journal_id, :id, :id_sc);", nativeQuery=true)
    void updateJournalStudentScore(long journal_id, long id, long id_sc);

    @Transactional
    @Modifying
    @Query(value="SELECT DISTINCT scores.* FROM scores", nativeQuery=true)
    public List<Score> getScoreList();


  /*  bnn*/

}
