package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.UserAccount;
import com.example.java.epam.brayan.data.repositories.UserAccountRepository;
import com.example.java.epam.brayan.services.data.RefilledUserAccount;
import com.example.java.epam.brayan.services.mappers.RefilledUserAccountMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefillUserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final RefilledUserAccountMapper refilledUserAccountMapper;

    @Transactional
    public void refillUserAccount(long userId, RefilledUserAccount refilledUserAccount) {
        UserAccount userAccount  = userAccountRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("User account not found"));

        userAccountRepository.save(
                refilledUserAccountMapper.addBalances(userAccount, refilledUserAccount)
        );
    }
}
