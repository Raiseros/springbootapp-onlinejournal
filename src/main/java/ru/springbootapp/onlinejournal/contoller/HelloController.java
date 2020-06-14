package ru.springbootapp.onlinejournal.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.entity.Teacher;
import ru.springbootapp.onlinejournal.service.StudentService;
import ru.springbootapp.onlinejournal.service.TeacherService;

@Controller
public class HelloController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

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


}
