package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.data.repositories.UserRepository;
import com.example.java.epam.brayan.services.data.NewUser;
import com.example.java.epam.brayan.services.mappers.NewUserMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {
    private final UserRepository userRepository;
    private final NewUserMapper newUserMapper;

    @Transactional
    public User createUser(NewUser newUser) {
        return userRepository.save(newUserMapper.toUser(newUser));
    }
}
