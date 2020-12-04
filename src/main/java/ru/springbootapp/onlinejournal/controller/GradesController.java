package ru.springbootapp.onlinejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springbootapp.onlinejournal.dto.GradesDto;
import ru.springbootapp.onlinejournal.entity.*;
import ru.springbootapp.onlinejournal.service.*;

import java.util.List;


@Controller
public class GradesController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private JournalService journalService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private JournalDtoService journalDtoService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassScheduleService classScheduleService;

    @Autowired
    private GradesDtoService gradesDtoService;


    @RequestMapping(value = "grades", method = RequestMethod.GET)
    public String getJournal(@RequestParam(required = false) String clName,
                             @RequestParam(required = false) String datLesson,
                             @RequestParam(required = false) String courseName,
                             @RequestParam(required = false) Long studentName, @RequestParam(required = false)
                                         Long teacherName, Model model) {


        if ((null != clName && "" != clName) && ((null == datLesson || "" == datLesson) && (null == studentName)
                && (null == courseName || "" == courseName))) {
            model.addAttribute("classNameStudent", clName);
            model.addAttribute("grades",gradesDtoService.getGradesDtoClassNameStudentList(clName));

       } else if ((null != datLesson && "" != datLesson) && ((null == clName || "" == clName) && (null == studentName)
                && (null == courseName || "" == courseName))) {
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("grades", gradesDtoService.getListByDateMonthLesson(datLesson));

       } else if ((null != clName && "" != clName) && ((null != datLesson && "" != datLesson) && (null == studentName)
                && (null == courseName || "" == courseName))) {
            model.addAttribute("classNameStudent", clName);
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("grades", gradesDtoService.getListByClassnameStudentAndByDateMonthLesson(clName, datLesson));

        } else if ((null != studentName) && (null == datLesson || "" == datLesson) && (null == courseName || "" == courseName)) {
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("grades", gradesDtoService.getListGradesDtoByStudName(studentName));

        } else if ((null != studentName) && (null != datLesson && "" != datLesson)  && (null == courseName || "" == courseName)) {
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("grades", gradesDtoService.getListGradesDtoStudentNameAndDateMonthLesson(studentName, datLesson));

        } else if ((null != courseName && "" != courseName) && ((null == clName || "" == clName)
                && (null == datLesson || "" == datLesson) && (null == studentName))) {
            model.addAttribute("courseName", courseName);
            model.addAttribute("grades", gradesDtoService.getListByCourseName(courseName));

        } else if ((null != courseName && "" != courseName) && ((null != datLesson && "" != datLesson) && (null == studentName)
                && (null == clName || "" == clName))) {
            model.addAttribute("courseName", courseName);
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("grades", gradesDtoService.getListGradesDtoCourseNameAndDateMonthLesson(courseName, datLesson));

        } else if ((null != courseName && "" != courseName) && ((null != clName && "" != clName) && (null == studentName)
                && (null == datLesson || "" == datLesson))) {
            model.addAttribute("courseName", courseName);
            model.addAttribute("classNameStudent", clName);
            model.addAttribute("grades", gradesDtoService.getListGradesDtoCourseNameAndClassNameStudent(courseName, clName));

        } else if ((null != courseName && "" != courseName) && (null != studentName)  && (null == datLesson || "" == datLesson)) {
            model.addAttribute("courseName", courseName);
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("grades", gradesDtoService.getListGradesDtoCourseNameAndStudName(courseName, studentName));

        } else if ((null != courseName && "" != courseName) && ((null != datLesson && "" != datLesson) && (null == studentName))
                && (null != clName && "" != clName)) {
            model.addAttribute("courseName", courseName);
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("classNameStudent", clName);
            model.addAttribute("grades", gradesDtoService.getListGradesDtoCourseNameAndDateAndClNameStud(courseName, datLesson, clName));

        } else if ((null != courseName && "" != courseName) && (null != datLesson && "" != datLesson) && (null != studentName)) {
            model.addAttribute("courseName", courseName);
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("grades", gradesDtoService.getListGradesDtoCourseNameAndDateAndStudName(courseName, datLesson, studentName));

        } else {
            List<GradesDto> theGradesDto = gradesDtoService.getListGradesDto();
            model.addAttribute("grades", theGradesDto);
        }

        model.addAttribute("tempTeacherName", teacherName);

        return "grades";

    }




    @ModelAttribute("classnameStudentList")
    public List<String> getClassnameStudentList() {
        return journalService.getListClassnameStudent();
    }

    @ModelAttribute("scoreList")
    public List<Score> getscoreList() {
        return scoreService.getScoreList();
    }

    @ModelAttribute("dateLessonMonthList")
    public List<String> getDateLessonMonthList() {
        return journalService.getDateLessonMonthList();
    }

    @ModelAttribute("dateFullFormatLessonList")
    public List<Journal> getFullFormatDateLessonList() {
        return journalService.getListFullFormatDateLesson();
    }



    @ModelAttribute("studentList")
    public List<Student> getStudentList() {
        return studentService.getListStudent();
    }

    @ModelAttribute("teacherList")
    public List<Teacher> getTeacherList() {
        return teacherService.getListTeacher();
    }


    @ModelAttribute("courseList")
    public List<Course> getcourseList() {
        return courseService.getcourseList();
    }

    @ModelAttribute("ClassScheduleList")
    public List<ClassSchedule> getClassScheduleList() {
        return classScheduleService.getClassScheduleList();
    }


}
