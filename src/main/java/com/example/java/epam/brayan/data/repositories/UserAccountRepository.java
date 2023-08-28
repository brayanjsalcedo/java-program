package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.data.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserId(Long userId);
}
