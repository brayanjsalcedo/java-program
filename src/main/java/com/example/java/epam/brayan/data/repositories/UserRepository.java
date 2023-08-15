package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.data.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
