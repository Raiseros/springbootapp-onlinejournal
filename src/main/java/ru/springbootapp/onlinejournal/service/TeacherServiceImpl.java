package ru.springbootapp.onlinejournal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.springbootapp.onlinejournal.entity.Teacher;
import ru.springbootapp.onlinejournal.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void saveTeacher(Teacher theTeacher) {
        teacherRepository.save(theTeacher);
    }

    @Override
    public Teacher findByEmail(String email) {
        return teacherRepository.findTeacherByEmail(email);
    }

    @Override
    public List<Teacher> getListTeacher() {
        return teacherRepository.getListTeacher();
    }

    /*vbbh*/

}