package com.kyd3snik.travel.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private final UserDetailsManager userDetailsManager;

    public MainController(@Qualifier("securityManager") UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

//    @GetMapping("/")
//    String main() {
//        return "main";
//    }
//
//    @GetMapping("/user")
//    ModelAndView helloUser(Authentication authentication) {
//        ModelAndView modelAndView = new ModelAndView("userOld");
//        User user = (User) userDetailsManager.loadUserByUsername(authentication.getName());
//        modelAndView.addObject("username", user.getUsername());
//        modelAndView.addObject("password", user.getPassword() == null ? "NO_PASSWORD" : user.getPassword());
//        return modelAndView;
//    }
}
