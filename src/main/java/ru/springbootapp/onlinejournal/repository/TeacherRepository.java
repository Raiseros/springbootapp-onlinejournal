package ru.springbootapp.onlinejournal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.entity.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findTeacherByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM teacher GROUP BY last_name, first_name, middle_name ORDER BY last_name, first_name ",
            nativeQuery=true)
    public List<Teacher> getListTeacher();


  /*  bnn*/

}
