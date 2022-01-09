package com.pc.stockcontrol.controller;


import com.pc.stockcontrol.entity.User;
import com.pc.stockcontrol.exceptions.UserNotFoundException;
import com.pc.stockcontrol.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
@ResponseBody
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
    public ResponseEntity<String> exceptionHandler(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
    @GetMapping("/register")
    public String signIn(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "sign";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/api/unite";
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
