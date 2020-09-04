package ru.springbootapp.onlinejournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.dto.GradesDto;
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

    @Transactional
    @Modifying
    @Query(value="SELECT journal.*, student.id as id_st, student.class_name as cl_student," +
            " student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as id_sc FROM" +
            " journal, student, scores, journal_student_score WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id ORDER BY date_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDto();


    @Transactional
    @Modifying
    @Query(value="SELECT journal.*, student.id as id_st, student.class_name as cl_student," +
            " student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as id_sc FROM" +
            " journal, student, scores, journal_student_score WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id AND journal.classname_student = :classNameStudent ORDER BY date_lesson", nativeQuery=true)
    public List<GradesDto> getGradesDtoByClassnameStudent(String classNameStudent);


    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListByDateMonthLesson(String dateLesson);

    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " journal.classname_student = :classNameStudent ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListByClassnameStudentAndByDateMonthLesson(String classNameStudent, String dateLesson);



    @Transactional
    @Modifying
    @Query(value="SELECT journal.*, student.id as id_st, student.class_name as cl_student," +
            " student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as id_sc FROM" +
            " journal, student, scores, journal_student_score WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id AND" +
            " student.id = :theId ORDER BY date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDtoByStudName(long theId);



    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " student.id = :studentName ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDtoStudentNameAndDateMonthLesson(long studentName, String dateLesson);


    @Transactional
    @Modifying
    @Query(value="SELECT journal.*, student.id as id_st, student.class_name as cl_student," +
            " student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as id_sc FROM" +
            " journal, student, scores, journal_student_score WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id AND" +
            " journal.shortname_course = :courseName ORDER BY date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListByCourseName(String courseName);


    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " journal.shortname_course = :courseName ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDtoCourseNameAndDateMonthLesson(String courseName, String dateLesson);

    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND journal.classname_student = :classNameStudent AND" +
            " journal.shortname_course = :courseName ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDtoCourseNameAndClassNameStudent(String courseName, String classNameStudent);


    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND student.id = :studentName AND" +
            " journal.shortname_course = :courseName ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDtoCourseNameAndStudName(String courseName, long studentName);

    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " journal.classname_student = :classNameStudent AND journal.shortname_course = :courseName ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDtoCourseNameAndDateAndClNameStud(String courseName, String dateLesson, String classNameStudent);


    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, student.id as id_st, student.class_name as" +
            " cl_student, student.first_name, student.last_name, student.middle_name,  overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " student.id = :studentName AND journal.shortname_course = :courseName ORDER BY" +
            " date_lesson , number_lesson", nativeQuery=true)
    public List<GradesDto> getListGradesDtoCourseNameAndDateAndStudName(String courseName, String dateLesson, long studentName);


  /*  bnn*/

}
