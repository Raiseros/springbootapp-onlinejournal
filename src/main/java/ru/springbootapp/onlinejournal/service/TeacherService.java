package ru.springbootapp.onlinejournal.service;


import ru.springbootapp.onlinejournal.entity.Teacher;

public interface TeacherService {
    public void saveTeacher(Teacher theTeacher);

    public Teacher findByEmail(String email);

    /*vbh*/
}
