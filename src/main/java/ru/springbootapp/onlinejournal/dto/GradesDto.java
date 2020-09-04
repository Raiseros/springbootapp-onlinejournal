package ru.springbootapp.onlinejournal.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public interface GradesDto {

    Long getId();


    java.util.Date getDate_lesson();

    String getFullname_course();

    String getShortname_course();

    String getClassname_student();

    Long getNumber_lesson();

    Long getOverall_score();

    Long getId_sc();

    String getLast_name();

    String getFirst_name();

    String getMiddle_name();




}
