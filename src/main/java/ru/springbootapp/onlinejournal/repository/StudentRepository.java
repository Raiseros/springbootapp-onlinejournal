package ru.springbootapp.onlinejournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByEmail(String email);


    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM student GROUP BY last_name, first_name, middle_name ORDER BY last_name, first_name ",
            nativeQuery=true)
    public List<Student> getListStudent();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM student ORDER BY last_name, first_name ",
            nativeQuery=true)
    public List<Student> getFullListStudent();

    public List<Student> findAllByClassName(String className);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Student SET last_name = :lastName, first_name = :firstName, middle_name = :middleName," +
            "class_name = :className, email = :email, password = :password WHERE id = :id", nativeQuery=true)
    void updateStudent(String lastName, String firstName, String middleName, String className, String email,
                       String password, long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO journal_students (journal_id, student_id) VALUES (:jour_id, :st_id)", nativeQuery=true)
    public void updateStudentClass(long jour_id, long st_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE journal_students FROM journal_students WHERE student_id = :theId", nativeQuery=true)
    public void deleteStudentClass(long theId);

    @Transactional
    @Modifying
    @Query(value = "DELETE journal_student_score FROM journal_student_score WHERE student_id = :theId", nativeQuery=true)
    public void deleteJournalScoreByStudentId(long theId);


    @Transactional
    @Modifying
    @Query(value = "DELETE journal_students FROM journal_students WHERE student_id = :theId", nativeQuery=true)
    public void deleteJournalStudentsByStudentId(long theId);

}
