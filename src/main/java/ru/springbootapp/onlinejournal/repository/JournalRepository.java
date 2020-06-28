package ru.springbootapp.onlinejournal.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.entity.Journal;
import java.util.Date;
import java.util.List;


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

}

