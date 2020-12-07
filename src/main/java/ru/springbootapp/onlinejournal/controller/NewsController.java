package ru.springbootapp.onlinejournal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springbootapp.onlinejournal.entity.*;
import ru.springbootapp.onlinejournal.service.*;

import java.util.List;




@Controller
public class NewsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;




    @ModelAttribute("studentList")
    public List<Student> getStudentList() {
        return studentService.getListStudent();
    }

    @ModelAttribute("teacherList")
    public List<Teacher> getTeacherList() {
        return teacherService.getListTeacher();
    }




    @RequestMapping(value = "news", method = RequestMethod.GET)
    public String getNews(@RequestParam(required = false) Long studentName, @RequestParam(required = false)
                                     Long teacherName, Model model) {


        model.addAttribute("tempStudentName", studentName);
        model.addAttribute("tempTeacherName", teacherName);

        return "news";

    }


    @RequestMapping(value = "news/content-one", method = RequestMethod.GET)
    public String getNewsOne(@RequestParam(required = false) Long studentName, @RequestParam(required = false)
            Long teacherName, Model model) {


        model.addAttribute("tempStudentName", studentName);
        model.addAttribute("tempTeacherName", teacherName);

        return "content-one";

    }

    @RequestMapping(value = "news/content-two", method = RequestMethod.GET)
    public String getNewsTwo(@RequestParam(required = false) Long studentName, @RequestParam(required = false)
            Long teacherName, Model model) {


        model.addAttribute("tempStudentName", studentName);
        model.addAttribute("tempTeacherName", teacherName);

        return "content-two";

    }


    @RequestMapping(value = "news/content-three", method = RequestMethod.GET)
    public String getNewsThree(@RequestParam(required = false) Long studentName, @RequestParam(required = false)
            Long teacherName, Model model) {


        model.addAttribute("tempStudentName", studentName);
        model.addAttribute("tempTeacherName", teacherName);

        return "content-three";

    }

    @RequestMapping(value = "news/content-four", method = RequestMethod.GET)
    public String getNewsFour(@RequestParam(required = false) Long studentName, @RequestParam(required = false)
            Long teacherName, Model model) {


        model.addAttribute("tempStudentName", studentName);
        model.addAttribute("tempTeacherName", teacherName);

        return "content-four";

    }

    @RequestMapping(value = "news/content-five", method = RequestMethod.GET)
    public String getNewsFive(@RequestParam(required = false) Long studentName, @RequestParam(required = false)
            Long teacherName, Model model) {


        model.addAttribute("tempStudentName", studentName);
        model.addAttribute("tempTeacherName", teacherName);

        return "content-five";

    }



}
