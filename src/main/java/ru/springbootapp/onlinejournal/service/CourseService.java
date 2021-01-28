package ru.springbootapp.onlinejournal.service;


import ru.springbootapp.onlinejournal.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourseList();
    public List<Course> getCourseClassNameStudentList(String classNameStudent);
    public List<Course> getCourseByDateMonthLesson(String dateLesson);
    public List<Course> getCourseByClassnameStudentAndByDateMonthLesson(String classNameStudent, String dateLesson);
    public List<Course> getCourseByStudName(long theId);
    public List<Course> getCourseStudentNameAndDateMonthLesson(long studentName, String dateLesson);
    public List<Course> getCourseByCourseName(String courseName);
    public List<Course> getCourseCourseNameAndDateMonthLesson(String courseName, String dateLesson);
    public List<Course> getCourseCourseNameAndClassNameStudent(String courseName, String classNameStudent);
    public List<Course> getCourseCourseNameAndStudName(String courseName, long studentName);
    public List<Course> getCourseCourseNameAndDateAndClNameStud(String courseName, String dateLesson, String classNameStudent);
    public List<Course> getCourseCourseNameAndDateAndStudName(String courseName, String dateLesson, long studentName);

}
