package com.ccruz.multiTenancyDemo.controller;

import com.ccruz.multiTenancyDemo.entity.User;
import com.ccruz.multiTenancyDemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/greeting")
    public String greeting() {
        return "Hello my dear";
    }

    @GetMapping(path = "/user")
    public List<User> getAll() {
        return repository.findAll();
    }
}
