package ru.springbootapp.onlinejournal.dto;

import java.util.Date;

public interface JournalDto {

    Long getId();

    Date getDate_lesson();

    Long getNumber_lesson();

    String getTime_lesson();

    String getFullname_course();

    String getShortname_course();

    String getClass_name();

    String getSchool_building();

    String getHomework();

    String getClassname_student();

    String getTime_break();

    Long getOverall_score();

    Long getId_sc();
}
