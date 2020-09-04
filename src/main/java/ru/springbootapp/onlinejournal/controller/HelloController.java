package ru.springbootapp.onlinejournal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.springbootapp.onlinejournal.entity.*;
import ru.springbootapp.onlinejournal.service.*;



import java.util.List;

@Controller
@RequestMapping(value = "/")
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

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassScheduleService classScheduleService;




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
    public String getJournal(@RequestParam(required = false) String clName,
                             @RequestParam(required = false) String datLesson, @RequestParam(required = false)
                                     Long studentName, Model model) {
        if ((null != clName && "" != clName) && ((null == datLesson || "" == datLesson) && (null == studentName))) {
            model.addAttribute("classNameStudent", clName);
            model.addAttribute("journals", journalService.getJournalClassNameStudentList(clName));
        } else if ((null != datLesson && "" != datLesson) && ((null == clName || "" == clName) && (null == studentName))) {
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("journals", journalService.getListByDateLesson(datLesson));
        } else if ((null != clName && "" != clName) && ((null != datLesson && "" != datLesson) && (null == studentName))) {
            model.addAttribute("classNameStudent", clName);
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("journals", journalService.getListByClassnameStudentAndByDateLesson(clName, datLesson));
        } else if ((null != studentName) && (null == datLesson || "" == datLesson)) {
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("journal", journalDtoService.getListJournalDto(studentName));

        } else if ((null != studentName) && (null != datLesson && "" != datLesson)) {
            model.addAttribute("tempStudentName", studentName);
            model.addAttribute("datLesson", datLesson);
            model.addAttribute("journal", journalDtoService.getListJournalDtoStudentNameAndDateLesson(studentName, datLesson));
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

    @ModelAttribute("scoreList")
    public List<Score> getscoreList() {
        return scoreService.getScoreList();
    }

    @ModelAttribute("dateLessonList")
    public List<String> getDateLessonList() {
        return journalService.getListDateLesson();
    }

    @ModelAttribute("studentList")
    public List<Student> getStudentList() {
        return studentService.getListStudent();
    }


    @ModelAttribute("courseList")
    public List<Course> getcourseList() {
        return courseService.getcourseList();
    }

    @ModelAttribute("ClassScheduleList")
    public List<ClassSchedule> getClassScheduleList() {
        return classScheduleService.getClassScheduleList();
    }


    @RequestMapping(value = "registry-lesson", method = RequestMethod.GET)
    public String registryLesson(Model model) {
        Journal theJournal = new Journal();
        Score theScore = new Score();
        model.addAttribute("journal", theJournal);
        model.addAttribute("score", theScore);
        return "registry-lesson";
    }

    @RequestMapping(value = "formForUpdate", method = RequestMethod.GET)
    public String update(@RequestParam("journalId") long theId, @RequestParam(required = false)
            Long studName, @RequestParam(required = false)
            Long idScore, @RequestParam(required = false) String datLesson, @RequestParam(required = false) String clName,  Model model) {
        Journal theJournal = journalService.getJournal(theId);
        if(idScore == null){
            Score newScore = new Score();
            model.addAttribute("score", newScore);
        } else{
            Score theScore = scoreService.getScore(theId, studName);
            model.addAttribute("score", theScore);
        }

        model.addAttribute("tempStudentName", studName);
        model.addAttribute("datLesson", datLesson);
        model.addAttribute("clName", clName);
        model.addAttribute("journal", theJournal);

        return "registry-lesson";
    }


    @PostMapping("saveLesson")
    public String addJournal(@ModelAttribute("journal") Journal theJournal,
                             @RequestParam(required = false) Long studentId, @RequestParam(required = false) Long overallScore,
                             @RequestParam(required = false, name = "id_sc") Long scoreId,
                             @RequestParam(required = false) String datLesson, @RequestParam(required = false) String clName,
                             RedirectAttributes redirectAttrs) {

        if (null != theJournal && theJournal.getId() > 0) {
            journalService.updateJournal(theJournal);
        } else {
            journalService.saveJournal(theJournal);
        }


         if (null != scoreId && overallScore > 0) {
           scoreService.updateScore(theJournal, scoreId, studentId);

        }


        else if(studentId != null){
            scoreService.saveScore(scoreId, theJournal, studentId);
        }


        redirectAttrs.addAttribute("studentName", studentId);
        redirectAttrs.addAttribute("datLesson", datLesson);
        redirectAttrs.addAttribute("clName", clName);

        return "redirect:/journal";
    }

    @RequestMapping(value ="delete", method = RequestMethod.GET)
    public String delete(@RequestParam("journalId") long theId,@RequestParam(required = false) String datLesson,
                         @RequestParam(required = false) String clName,
                         RedirectAttributes redirectAttrs) {
        journalService.deleteJournalScoreByJournalId(theId);
        journalService.deleteJournal(theId);
        redirectAttrs.addAttribute("datLesson", datLesson);
        redirectAttrs.addAttribute("clName", clName);
        return "redirect:/journal";
    }


    @RequestMapping(value ="deleteScore", method = RequestMethod.GET)
    public String deleteScore(@RequestParam("journalId") long theId, @RequestParam Long idStudName,
                              @RequestParam(required = false) String datLesson, RedirectAttributes redirectAttrs) {
        journalService.deleteJournalScore(theId, idStudName);

        redirectAttrs.addAttribute("studentName", idStudName);
        redirectAttrs.addAttribute("datLesson", datLesson);

        return "redirect:/journal";
    }


    /*nnm*/

}
