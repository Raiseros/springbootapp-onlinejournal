package ru.springbootapp.onlinejournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.dto.GradesDto;
import ru.springbootapp.onlinejournal.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {


    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM study_course ORDER BY course_name",
            nativeQuery=true)
    public List<Course> getCourseList();


    @Transactional
    @Modifying
    @Query(value="SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND journal.classname_student = :classNameStudent AND" +
            " study_course.course_name=journal.fullname_course GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseClassNameStudentList(String classNameStudent);


    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " study_course.course_name=journal.fullname_course GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseByDateMonthLesson(String dateLesson);


    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " journal.classname_student = :classNameStudent AND study_course.course_name=journal.fullname_course" +
            " GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseByClassnameStudentAndByDateMonthLesson(String classNameStudent, String dateLesson);


    @Transactional
    @Modifying
    @Query(value="SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND student.id = :theId AND" +
            " study_course.course_name=journal.fullname_course GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseByStudName(long theId);



    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " student.id = :studentName AND study_course.course_name=journal.fullname_course GROUP BY" +
            " course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseStudentNameAndDateMonthLesson(long studentName, String dateLesson);



    @Transactional
    @Modifying
    @Query(value="SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE student.id=journal_student_score.student_id AND" +
            " scores.id= journal_student_score.score_id AND journal.id=journal_student_score.journal_id AND" +
            " journal.shortname_course = :courseName AND study_course.course_name=journal.fullname_course GROUP BY" +
            " course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseByCourseName(String courseName);



    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " journal.shortname_course = :courseName AND study_course.course_name=journal.fullname_course GROUP BY" +
            " course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseCourseNameAndDateMonthLesson(String courseName, String dateLesson);



    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND journal.classname_student = :classNameStudent AND" +
            " journal.shortname_course = :courseName AND study_course.course_name=journal.fullname_course " +
            "GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseCourseNameAndClassNameStudent(String courseName, String classNameStudent);



    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND student.id = :studentName AND" +
            " journal.shortname_course = :courseName AND study_course.course_name=journal.fullname_course" +
            " GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseCourseNameAndStudName(String courseName, long studentName);


    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " journal.classname_student = :classNameStudent AND journal.shortname_course = :courseName AND" +
            " study_course.course_name=journal.fullname_course GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseCourseNameAndDateAndClNameStud(String courseName, String dateLesson, String classNameStudent);




    @Transactional
    @Modifying
    @Query(value = "SELECT study_course.* FROM journal, student, scores, journal_student_score, study_course WHERE" +
            " student.id=journal_student_score.student_id AND scores.id= journal_student_score.score_id AND" +
            " journal.id=journal_student_score.journal_id AND DATE_FORMAT(date_lesson,'%M') = :dateLesson AND" +
            " student.id = :studentName AND journal.shortname_course = :courseName AND" +
            " study_course.course_name=journal.fullname_course GROUP BY course_name ORDER BY course_name", nativeQuery=true)
    public List<Course> getCourseCourseNameAndDateAndStudName(String courseName, String dateLesson, long studentName) ;
}
