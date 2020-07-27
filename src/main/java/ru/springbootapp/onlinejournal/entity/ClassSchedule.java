package ru.springbootapp.onlinejournal.entity;

import javax.persistence.*;


@Entity
@Table(name="class_schedule")
public class ClassSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id_classSchedule;

    @Column(name="number_lesson")
    private long numberLessonClShedule;

    @Column(name="time_lesson")
    private String timeLessonClShedule;

    @Column(name="time_break")
    private String timeBreakClShedule;


    public long getId_classSchedule() {
        return id_classSchedule;
    }

    public void setId_classSchedule(long id_classSchedule) {
        this.id_classSchedule = id_classSchedule;
    }

    public long getNumberLessonClShedule() {
        return numberLessonClShedule;
    }

    public void setNumberLessonClShedule(long numberLessonClShedule) {
        this.numberLessonClShedule = numberLessonClShedule;
    }

    public String getTimeLessonClShedule() {
        return timeLessonClShedule;
    }

    public void setTimeLessonClShedule(String timeLessonClShedule) {
        this.timeLessonClShedule = timeLessonClShedule;
    }

    public String getTimeBreakClShedule() {
        return timeBreakClShedule;
    }

    public void setTimeBreakClShedule(String timeBreakClShedule) {
        this.timeBreakClShedule = timeBreakClShedule;
    }

    public ClassSchedule(long numberLessonClShedule, String timeLessonClShedule, String timeBreakClShedule) {
        this.numberLessonClShedule = numberLessonClShedule;
        this.timeLessonClShedule = timeLessonClShedule;
        this.timeBreakClShedule = timeBreakClShedule;
    }

    public ClassSchedule() {
    }
}
