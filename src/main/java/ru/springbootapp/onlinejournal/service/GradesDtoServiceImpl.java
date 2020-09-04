package ru.springbootapp.onlinejournal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.dto.GradesDto;
import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.repository.ScoreRepository;

import java.util.List;

@Service
public class GradesDtoServiceImpl implements GradesDtoService{

    @Autowired
    private ScoreRepository scoreRepository;


    @Override
    public List<GradesDto> getListGradesDto() {
        return scoreRepository.getListGradesDto();
    }

    @Override
    public List<GradesDto> getGradesDtoClassNameStudentList(String classNameStudent) {
        return scoreRepository.getGradesDtoByClassnameStudent(classNameStudent);
    }

    @Override
    public List<GradesDto> getListByDateMonthLesson(String dateLesson) {
        return scoreRepository.getListByDateMonthLesson(dateLesson);
    }

    @Override
    public List<GradesDto> getListByClassnameStudentAndByDateMonthLesson(String classNameStudent, String dateLesson) {
        return scoreRepository.getListByClassnameStudentAndByDateMonthLesson(classNameStudent, dateLesson);
    }


    @Override
    public List<GradesDto> getListGradesDtoByStudName(long theId) {
        return scoreRepository.getListGradesDtoByStudName(theId);
    }


    @Override
    public List<GradesDto> getListGradesDtoStudentNameAndDateMonthLesson(long studentName, String dateLesson) {
        return scoreRepository.getListGradesDtoStudentNameAndDateMonthLesson(studentName, dateLesson);
    }

    @Override
    public List<GradesDto> getListByCourseName(String courseName) {
        return scoreRepository.getListByCourseName(courseName);
    }


    @Override
    public List<GradesDto> getListGradesDtoCourseNameAndDateMonthLesson(String courseName, String dateLesson) {
        return scoreRepository.getListGradesDtoCourseNameAndDateMonthLesson(courseName, dateLesson);
    }

    @Override
    public List<GradesDto> getListGradesDtoCourseNameAndClassNameStudent(String courseName, String classNameStudent) {
        return scoreRepository.getListGradesDtoCourseNameAndClassNameStudent(courseName, classNameStudent);
    }

    @Override
    public List<GradesDto> getListGradesDtoCourseNameAndStudName(String courseName, long studentName) {
        return scoreRepository.getListGradesDtoCourseNameAndStudName(courseName, studentName);
    }

    @Override
    public List<GradesDto> getListGradesDtoCourseNameAndDateAndClNameStud(String courseName, String dateLesson, String classNameStudent) {
        return scoreRepository.getListGradesDtoCourseNameAndDateAndClNameStud(courseName, dateLesson, classNameStudent);
    }

    @Override
    public List<GradesDto> getListGradesDtoCourseNameAndDateAndStudName(String courseName, String dateLesson, long studentName) {
        return scoreRepository.getListGradesDtoCourseNameAndDateAndStudName(courseName, dateLesson, studentName);
    }

}
