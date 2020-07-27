package ru.springbootapp.onlinejournal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan(basePackages = "ru.springbootapp.onlinejournal")
public class SecurityConfigTeacher extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder);

    }



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
                .antMatchers("/", "/showTeacherLoginPage/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/showTeacherLoginPage")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/showTeacherLoginPage/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/showTeacherLoginPage/logout")
                .permitAll();

    }
    /*xcxc*/
}
