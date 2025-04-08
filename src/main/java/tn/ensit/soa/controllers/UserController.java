package tn.ensit.soa.controllers;

import org.springframework.web.bind.annotation.*;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getOneUser(@PathVariable Long id) {
        return service.getOneUser(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody String username) {
        return service.createUser(username);
    }
}
