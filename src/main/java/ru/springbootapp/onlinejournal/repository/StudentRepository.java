package ru.springbootapp.onlinejournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springbootapp.onlinejournal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
