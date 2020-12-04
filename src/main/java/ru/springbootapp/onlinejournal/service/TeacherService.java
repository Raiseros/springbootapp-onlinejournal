package ru.springbootapp.onlinejournal.service;


import ru.springbootapp.onlinejournal.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public void saveTeacher(Teacher theTeacher);

    public Teacher findByEmail(String email);

    public List<Teacher> getListTeacher();

    /*vbh*/
}
