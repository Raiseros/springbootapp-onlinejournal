package ru.springbootapp.onlinejournal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootapp.onlinejournal.entity.MyUserDetails;
import ru.springbootapp.onlinejournal.entity.Student;
import ru.springbootapp.onlinejournal.entity.Teacher;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {



        Student student = studentService.findByEmail(email);
       // final MyUserDetails user = studentService.findByEmail(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (student == null){
            Teacher teacher = teacherService.findByEmail(email);
            String roleTeacher = teacher.getRole();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleTeacher));
            return new org.springframework.security.core.userdetails.User(teacher.getEmail(),
                    passwordEncoder.encode(teacher.getPassword()), grantedAuthorities);
        } else
            {
                String roleStudent = student.getRole();
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleStudent));

            return new org.springframework.security.core.userdetails.User(student.getEmail(),
                passwordEncoder.encode(student.getPassword()), grantedAuthorities);
            }

          //  return student;


    }


    /*cvbh*/
}
