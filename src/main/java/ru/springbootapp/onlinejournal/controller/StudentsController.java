package ru.springbootapp.onlinejournal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.entity.Teacher;
import ru.springbootapp.onlinejournal.service.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;


    @Autowired
    private JournalService journalService;

    @Autowired
    private TeacherService teacherService;



    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String getJournal(@RequestParam(required = false) String clName, @RequestParam(required = false)
            Long teacherName, Model model) {


        if (null != clName && "" != clName) {
            model.addAttribute("classNameStudent", clName);
            model.addAttribute("students",studentService.getAllStudentsByClassName(clName));

        } else {
            model.addAttribute("students", studentService.getFullListStudent());
        }

        model.addAttribute("tempTeacherName", teacherName);

        return "students";

    }


    @ModelAttribute("classnameStudentList")
    public List<String> getClassnameStudentList() {
        return journalService.getListClassnameStudent();
    }

    @ModelAttribute("teacherList")
    public List<Teacher> getTeacherList() {
        return teacherService.getListTeacher();
    }

    @RequestMapping(value = "registry-student-list", method = RequestMethod.GET)
    public String registryStudent(Model model) {
        Student theStudent = new Student();
        model.addAttribute("student", theStudent);
        return "registry-student-list";
    }




    @RequestMapping(value = "formForStudentUpdate", method = RequestMethod.GET)
    public String updateStudent(@RequestParam("studentId") long theId, @RequestParam(required = false) String clName,
                                @RequestParam(required = false) String classNameSt, Model model) {
       Student theStudent = studentService.getStudent(theId);

        model.addAttribute("classNameSt", classNameSt);
        model.addAttribute("clName", clName);
        model.addAttribute("student", theStudent);


        return "registry-student-list";
    }

    @PostMapping("saveStudent")
    public String addStudent(@ModelAttribute("student") Student theStudent,@RequestParam(required = false) String classNameSt,
                             @RequestParam(required = false) String clName, RedirectAttributes redirectAttrs) throws SQLException {

        if(null != theStudent && theStudent.getId() > 0){
            studentService.updateStudent(theStudent, classNameSt);
        } else{

            studentService.saveStudent(theStudent);

        }

        redirectAttrs.addAttribute("clName", clName);

        return "redirect:/students";
    }

    @RequestMapping(value ="deleteStudent", method = RequestMethod.GET)
    public String delete(@RequestParam("studentId") long theId, @RequestParam(required = false) String clName,
                         RedirectAttributes redirectAttrs) {
        studentService.deleteJournalScoreByStudentId(theId);
        studentService.deleteJournalStudentsByStudentId(theId);
        studentService.deleteStudent(theId);
        redirectAttrs.addAttribute("clName", clName);
        return "redirect:/students";
    }


}
