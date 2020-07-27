package ru.springbootapp.onlinejournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {


    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM study_course",
            nativeQuery=true)
    public List<Course> getcourseList();

    /*bnn*/
}
