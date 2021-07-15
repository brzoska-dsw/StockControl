package com.pc.stockcontrol.controller;

import com.pc.stockcontrol.entity.User;
import com.pc.stockcontrol.exceptions.userNotFoundException;
import com.pc.stockcontrol.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}/user")
    public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(userNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
    @GetMapping("/sign-in")
    public String singup(Model model) {
        model.addAttribute("user", new User());
        return "sign-in";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "sign-in";
    }

//    @PostMapping("/register")
//    public ResponseEntity<User> newUser(@RequestBody User newUser) {
//
//        if (newUser.equals(null)) {
//            throw new RuntimeException("You must define new user");
//        } else {
//            return userService.save(newUser);
//        }
//    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
