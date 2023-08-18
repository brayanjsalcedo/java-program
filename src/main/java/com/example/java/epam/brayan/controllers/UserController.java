package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.CreateUserRequest;
import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.services.CreateUserService;
import com.example.java.epam.brayan.services.data.NewUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {
    private final CreateUserService createUserService;
    @PostMapping
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        log.debug("Creating a new user {}", createUserRequest);

        return createUserService.createUser(
                NewUser.builder()
                        .name(createUserRequest.getName())
                        .email(createUserRequest.getEmail())
                        .build()
        );
    }
}
