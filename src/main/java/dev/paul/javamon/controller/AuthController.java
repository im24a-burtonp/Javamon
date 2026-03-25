package dev.paul.javamon.controller;

import dev.paul.javamon.model.User;
import dev.paul.javamon.model.UserParty;
import dev.paul.javamon.repository.UserRepository;
import dev.paul.javamon.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user, HttpSession session) {
        boolean created = service.register(user);
        if (created) {
            session.setAttribute("user", user.getUsername());
        }
        return created;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user, HttpSession session) {
        boolean success = service.login(user.getUsername(), user.getPassword());
        if (success) {
            session.setAttribute("user", user.getUsername());
        }
        return success;
    }

    @GetMapping("/me")
    public String me(HttpSession session){
        return (String) session.getAttribute("user");
    }
}