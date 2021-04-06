package com.madura.spring.user.registration.and.login.controller;

import com.madura.spring.user.registration.and.login.entites.User;
import com.madura.spring.user.registration.and.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String returnHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String returnRegisterPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewListUsers(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList",userList);
        return "users";
    }
}
