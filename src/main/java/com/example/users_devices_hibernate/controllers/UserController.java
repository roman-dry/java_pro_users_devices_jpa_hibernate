package com.example.users_devices_hibernate.controllers;

import com.example.users_devices_hibernate.models.User;
import com.example.users_devices_hibernate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userservice;

    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping()
    public String readAllUsers(Model model) {
        model.addAttribute("users", userservice.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userservice.readUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userservice.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userservice.readUserById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {

        userservice.updateUserById(user, id);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") int id) {
        userservice.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/{userId}/devices")
    public String getUserDevices(@PathVariable("userId")  Integer user_id, Model model) {
            model.addAttribute("devices", userservice.getUserDevices(user_id));
        return "show3";

    }
}
