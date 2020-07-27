package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.entity.ClassSchedule;
import ru.springbootapp.onlinejournal.repository.ClassScheduleRepository;

import java.util.List;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {

    @Autowired
    private ClassScheduleRepository ClassScheduleRepository;


    @Override
    public List<ClassSchedule> getClassScheduleList() {
        return  ClassScheduleRepository.getClassScheduleList();
    }
}
