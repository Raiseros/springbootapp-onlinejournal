package ru.springbootapp.onlinejournal.service;

import ru.springbootapp.onlinejournal.dto.GradesDto;
import ru.springbootapp.onlinejournal.dto.JournalDto;
import ru.springbootapp.onlinejournal.entity.Journal;

import java.util.List;

public interface GradesDtoService {

    public List<GradesDto> getListGradesDto();

    public List<GradesDto> getGradesDtoClassNameStudentList(String classNameStudent);

    public List<GradesDto> getListByDateMonthLesson(String dateLesson);

    public List<GradesDto> getListByClassnameStudentAndByDateMonthLesson(String classNameStudent, String dateLesson);

    public List<GradesDto> getListGradesDtoByStudName(long theId);

    public List<GradesDto> getListGradesDtoStudentNameAndDateMonthLesson(long studentName, String dateLesson);

    public List<GradesDto> getListByCourseName(String courseName);

    public List<GradesDto> getListGradesDtoCourseNameAndDateMonthLesson(String courseName, String dateLesson);

    public List<GradesDto> getListGradesDtoCourseNameAndClassNameStudent(String courseName, String classNameStudent);

    public List<GradesDto> getListGradesDtoCourseNameAndStudName(String courseName, long studentName);

    public List<GradesDto> getListGradesDtoCourseNameAndDateAndClNameStud(String courseName, String dateLesson, String classNameStudent);

    public List<GradesDto> getListGradesDtoCourseNameAndDateAndStudName(String courseName, String dateLesson, long studentName);

}
