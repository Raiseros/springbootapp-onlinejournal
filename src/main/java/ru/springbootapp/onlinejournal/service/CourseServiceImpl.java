package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.Course;
import ru.springbootapp.onlinejournal.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourseList() {
        return courseRepository.getCourseList();
    }

    @Override
    public List<Course> getCourseClassNameStudentList(String classNameStudent) {
        return courseRepository.getCourseClassNameStudentList(classNameStudent);
    }

    @Override
    public List<Course> getCourseByDateMonthLesson(String dateLesson) {
        return courseRepository.getCourseByDateMonthLesson(dateLesson);
    }

    @Override
    public List<Course> getCourseByClassnameStudentAndByDateMonthLesson(String classNameStudent, String dateLesson) {
        return courseRepository.getCourseByClassnameStudentAndByDateMonthLesson(classNameStudent, dateLesson);
    }

    @Override
    public List<Course> getCourseByStudName(long theId) {
        return courseRepository.getCourseByStudName(theId);
    }


    @Override
    public List<Course> getCourseStudentNameAndDateMonthLesson(long studentName, String dateLesson) {
        return courseRepository.getCourseStudentNameAndDateMonthLesson(studentName, dateLesson);
    }

    @Override
    public List<Course> getCourseByCourseName(String courseName) {
        return courseRepository.getCourseByCourseName(courseName);
    }


    @Override
    public List<Course> getCourseCourseNameAndDateMonthLesson(String courseName, String dateLesson) {
        return courseRepository.getCourseCourseNameAndDateMonthLesson(courseName, dateLesson);
    }


    @Override
    public List<Course> getCourseCourseNameAndClassNameStudent(String courseName, String classNameStudent) {
        return courseRepository.getCourseCourseNameAndClassNameStudent(courseName, classNameStudent);
    }

    @Override
    public List<Course> getCourseCourseNameAndStudName(String courseName, long studentName) {
        return courseRepository.getCourseCourseNameAndStudName(courseName, studentName);
    }

    @Override
    public List<Course> getCourseCourseNameAndDateAndClNameStud(String courseName, String dateLesson, String classNameStudent) {
        return courseRepository.getCourseCourseNameAndDateAndClNameStud(courseName, dateLesson, classNameStudent);
    }


    @Override
    public List<Course> getCourseCourseNameAndDateAndStudName(String courseName, String dateLesson, long studentName) {
        return courseRepository.getCourseCourseNameAndDateAndStudName(courseName, dateLesson, studentName);
    }
}
