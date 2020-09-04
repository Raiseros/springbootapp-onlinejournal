package ru.springbootapp.onlinejournal.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.dto.JournalDto;
import ru.springbootapp.onlinejournal.entity.Journal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Journal SET date_lesson = :dateLesson , number_lesson = :numberLesson ," +
            " time_lesson = :timeLesson , fullname_course = :fullnameCourse , shortname_course = :shortnameCourse , " +
            "class_name = :className , school_building = :schoolBuilding , homework = :homework ," +
            " classname_student = :classnameStudent , time_break = :timeBreak WHERE id = :id")
    void updateJournal(Date dateLesson, long numberLesson, String timeLesson, String fullnameCourse,
                       String shortnameCourse, String className, String schoolBuilding, String homework,
                       String classnameStudent, String timeBreak, long id);
    @Transactional
    @Modifying
    @Query("SELECT DISTINCT classnameStudent FROM Journal")
    public List<String> getListClassnameStudent();


    public List<Journal> findAllByClassnameStudent(String classNameStudent);


    @Transactional
    @Modifying
    @Query(value = "SELECT DISTINCT concat(DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson) - MOD(TO_DAYS(date_lesson) -2, 7)))," +
            " '%d %b'), ' - ', DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson) - MOD(TO_DAYS(date_lesson) -2, 7) + 4 ))," +
            "'%d %b'))  FROM journal ORDER BY date_lesson , number_lesson", nativeQuery=true)
    public List<String> getListDateLesson();

    @Transactional
    @Modifying
    @Query(value = "SELECT DISTINCT DATE_FORMAT(date_lesson,'%M') FROM journal" +
            " ORDER BY date_lesson , number_lesson", nativeQuery=true)
    public List<String> getDateLessonMonthList();

    @Transactional
    @Modifying
    @Query(value = "SELECT journal.* FROM journal GROUP BY date_lesson ORDER BY date_lesson", nativeQuery=true)
    public List<Journal> getListFullFormatDateLesson();


    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM journal WHERE concat(DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7))), '%d %b'), ' - ', DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7) + 4 )),'%d %b')) = :dateLesson " +
            " ORDER BY date_lesson , number_lesson", nativeQuery=true)
    public List<Journal> getListByDateLesson(String dateLesson);



    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM journal WHERE (concat(DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson) " +
            "- MOD(TO_DAYS(date_lesson) -2, 7))), '%d %b'), ' - ', DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7) + 4 )),'%d %b'))) = :dateLesson AND " +
            "classname_student = :classNameStudent ORDER BY date_lesson , number_lesson", nativeQuery=true)
    public List<Journal> getListByClassnameStudentAndByDateLesson(String classNameStudent, String dateLesson);

    @Transactional
    @Modifying
    @Query(value = "SELECT journal.* FROM journal, student, journal_students  WHERE" +
            " journal.id=journal_students.journal_id AND student.id=journal_students.student_id" +
            " AND student.id = :studentName ORDER BY date_lesson, number_lesson", nativeQuery=true)
    public List<Journal> getJournalListByStudent(long studentName);

    @Transactional
    @Modifying
    @Query(value = "SELECT journal.* FROM journal, student, journal_students" +
            " WHERE (concat(DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson) " +
            "- MOD(TO_DAYS(date_lesson) -2, 7))), '%d %b'), ' - ', DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7) + 4 )),'%d %b'))) = :dateLesson AND journal.id=journal_students.journal_id  AND" +
            " student.id=journal_students.student_id AND student.id = :studentName" +
            " ORDER BY date_lesson , number_lesson", nativeQuery=true)
    public List<Journal> getListByStudentNameAndByDateLesson(long studentName, String dateLesson);


    @Transactional
    @Modifying
    @Query(value = "SELECT journal.* FROM journal WHERE id = :theId ORDER BY date_lesson, number_lesson", nativeQuery=true)
    public Set<Journal> listJournalById(long theId);



    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, null as overall_score, null as id_sc FROM journal, student, journal_students WHERE" +
            " journal.id=journal_students.journal_id AND student.id=journal_students.student_id AND" +
            " student.id = :theId AND journal.id not in(select journal.id FROM" +
            " journal, student, scores, journal_student_score WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id AND" +
            " student.id = :theId ORDER BY date_lesson, number_lesson) UNION SELECT journal.*, overall_score, scores.id as" +
            " id_sc FROM journal, student, scores, journal_student_score WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id AND" +
            " student.id = :theId ORDER BY date_lesson, number_lesson", nativeQuery=true)
    public List<JournalDto> getListJournalDto(long theId);


    @Transactional
    @Modifying
    @Query(value = "SELECT journal.*, null as overall_score, null as id_sc  FROM journal, student, journal_students WHERE" +
            "(concat(DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7))), '%d %b'), ' - ', DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7) + 4 )),'%d %b'))) = :dateLesson AND" +
            " journal.id=journal_students.journal_id AND student.id=journal_students.student_id AND" +
            " student.id = :studentName AND journal.id not in(select journal.id FROM" +
            " journal, student, scores, journal_student_score WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id AND" +
            " student.id = :studentName ORDER BY date_lesson, number_lesson) UNION SELECT" +
            " journal.*, overall_score, scores.id as id_sc FROM journal, student, scores, journal_student_score WHERE" +
            " (concat(DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7))), '%d %b'), ' - ', DATE_FORMAT((FROM_DAYS(TO_DAYS(date_lesson)" +
            " - MOD(TO_DAYS(date_lesson) -2, 7) + 4 )),'%d %b'))) = :dateLesson AND" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND student.id = :studentName ORDER BY" +
            " date_lesson, number_lesson", nativeQuery=true)
    public List<JournalDto> getListJournalDtoStudentNameAndDateLesson(long studentName, String dateLesson);

    @Transactional
    @Modifying
    @Query(value = "DELETE journal_student_score FROM journal_student_score WHERE journal_id = :theId AND" +
            " student_id = :idStudName ", nativeQuery=true)
    public void deleteJournalScore(long theId, long idStudName);


    @Transactional
    @Modifying
    @Query(value = "DELETE journal_student_score FROM journal_student_score WHERE journal_id = :theId", nativeQuery=true)
    public void deleteJournalScoreByJournalId(long theId);

/*bbm*/
}

