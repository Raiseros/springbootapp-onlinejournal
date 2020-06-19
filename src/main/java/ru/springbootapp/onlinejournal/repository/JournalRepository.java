package ru.springbootapp.onlinejournal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.entity.Journal;


@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Journal SET date_lesson = :dateLesson , number_lesson = :numberLesson ," +
            " time_lesson = :timeLesson , fullname_course = :fullnameCourse , shortname_course = :shortnameCourse , " +
            "class_name = :className , school_building = :schoolBuilding , homework = :homework ," +
            " classname_student = :classnameStudent , time_break = :timeBreak WHERE id = :id")
    void updateJournal(String dateLesson, long numberLesson, long timeLesson, String fullnameCourse,
                       String shortnameCourse, String className, String schoolBuilding, String homework,
                       String classnameStudent, long timeBreak, long id);

}

