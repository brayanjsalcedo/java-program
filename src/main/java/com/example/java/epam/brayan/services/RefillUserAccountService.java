package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.UserAccount;
import com.example.java.epam.brayan.data.repositories.UserAccountRepository;
import com.example.java.epam.brayan.services.data.RefilledUserAccount;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefillUserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Transactional
    public void refillUserAccount(long userId, RefilledUserAccount refilledUserAccount) {
        UserAccount userAccount  = userAccountRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("User account not found"));

        userAccountRepository.save(
                addBalances(userAccount, refilledUserAccount)
        );
    }

    private UserAccount addBalances(UserAccount userAccount, RefilledUserAccount refilledUserAccount) {
        userAccount.setBalance(userAccount.getBalance() + refilledUserAccount.getBalance());
        return userAccount;
    }
}
