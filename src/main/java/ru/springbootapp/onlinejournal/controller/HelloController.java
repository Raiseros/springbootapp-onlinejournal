package ru.springbootapp.onlinejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springbootapp.onlinejournal.entity.Journal;
import ru.springbootapp.onlinejournal.entity.Score;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.entity.Teacher;
import ru.springbootapp.onlinejournal.service.*;



import java.util.List;

@Controller
public class HelloController {

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



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHelloPage() {
        return "hello-page";
    }

    @RequestMapping(value = "showMyLoginPage", method = RequestMethod.GET)
    public String showMyLoginPage() {
        return "loginpage-student";
    }


    @RequestMapping(value = "/showMyLoginPage/registry-student", method = RequestMethod.GET)
    public String registryStudent(Model model) {
        Student theStudent = new Student();
        model.addAttribute("student", theStudent);
        return "registry-student";
    }

    @RequestMapping(value = "/showTeacherLoginPage/registry-teacher", method = RequestMethod.GET)
    public String registryTeacher(Model model) {
        Teacher theTeacher = new Teacher();
        model.addAttribute("teacher", theTeacher);
        return "registry-teacher";
    }

    @PostMapping("/showMyLoginPage/saveStudent")
    public String addStudent(@ModelAttribute("student") Student theStudent) {
        studentService.saveStudent(theStudent);
        return "redirect:/";
    }


    @RequestMapping(value = "showTeacherLoginPage", method = RequestMethod.GET)
    public String showTeacherLoginPage() {
        return "loginpage-teacher";
    }

    @PostMapping("/showTeacherLoginPage/saveTeacher")
    public String addTeacher(@ModelAttribute("teacher") Teacher theTeacher) {
        teacherService.saveTeacher(theTeacher);
        return "redirect:/";
    }


    @RequestMapping(value = "journal", method = RequestMethod.GET)
    public String getJournal(@RequestParam(required = false) String className,
                             @RequestParam(required = false) String dateLesson, @RequestParam(required = false)
                                     Long studentName, Model model) {
        if ((null != className && "" != className) && ((null == dateLesson || "" == dateLesson) && (null == studentName))) {
            model.addAttribute("classNameStudent", className);
            model.addAttribute("journals", journalService.getJournalClassNameStudentList(className));
        } else if ((null != dateLesson && "" != dateLesson) && ((null == className || "" == className) && (null == studentName))) {
            model.addAttribute("dateLesson", dateLesson);
            model.addAttribute("journals", journalService.getListByDateLesson(dateLesson));
        } else if ((null != className && "" != className) && ((null != dateLesson && "" != dateLesson) && (null == studentName))) {
            model.addAttribute("classNameStudent", className);
            model.addAttribute("dateLesson", dateLesson);
            model.addAttribute("journals", journalService.getListByClassnameStudentAndByDateLesson(className, dateLesson));
        } else if ((null != studentName) && (null == dateLesson || "" == dateLesson)) {
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("journal", journalDtoService.getListJournalDto(studentName));

        } else if ((null != studentName) && (null != dateLesson && "" != dateLesson)) {
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("dateLesson", dateLesson);
            model.addAttribute("journal", journalDtoService.getListJournalDtoStudentNameAndDateLesson(studentName, dateLesson));
        } else {
            List<Journal> theJournals = journalService.getJournals();
            model.addAttribute("journals", theJournals);
        }
        return "journal";
    }


    @ModelAttribute("classnameStudentList")
    public List<String> getClassnameStudentList() {
        return journalService.getListClassnameStudent();
    }

    @ModelAttribute("dateLessonList")
    public List<String> getDateLessonList() {
        return journalService.getListDateLesson();
    }

    @ModelAttribute("studentList")
    public List<Student> getStudentList() {
        return studentService.getListStudent();
    }

    @RequestMapping(value = "registry-lesson", method = RequestMethod.GET)
    public String registryLesson(Model model) {
        Journal theJournal = new Journal();
        model.addAttribute("journal", theJournal);
        return "registry-lesson";
    }

    @RequestMapping(value = "formForUpdate", method = RequestMethod.GET)
    public String update(@RequestParam("journalId") long theId, @RequestParam(required = false)
            Long studName, @RequestParam(required = false)
            Long overallScore, Model model) {
        Journal theJournal = journalService.getJournal(theId);
        if(overallScore == null){
            Score newScore = new Score();
            model.addAttribute("score", newScore);
        } else{
            Score theScore = scoreService.getScore(theId);
            model.addAttribute("score", theScore);
        }

        model.addAttribute("tempStudentName", studName);
        model.addAttribute("journal", theJournal);

        return "registry-lesson";
    }


    @PostMapping("saveLesson")
    public String addJournal(@ModelAttribute("journal") Journal theJournal, @ModelAttribute("score") Score theScore,
                             @RequestParam(required = false) Long studentId) {

        if (null != theJournal && theJournal.getId() > 0) {
            journalService.updateJournal(theJournal);
        } else {
            journalService.saveJournal(theJournal);
        }

        if (null != theScore && theScore.getId_sc() > 0) {
            scoreService.updateScore(theScore);
        } else {
            scoreService.saveScore(theScore, theJournal, studentId);
        }


        return "redirect:/journal";
    }

}
