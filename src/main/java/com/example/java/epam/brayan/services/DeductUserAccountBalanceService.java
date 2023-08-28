package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.UserAccount;
import com.example.java.epam.brayan.data.repositories.UserAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeductUserAccountBalanceService {
    private final UserAccountRepository userAccountRepository;
    public void deductBalance(Long userId, Double ticketPrice) {
        UserAccount userAccount = userAccountRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("User account not found"));

        if (userAccount.getBalance() < ticketPrice) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        userAccount.setBalance(userAccount.getBalance() - ticketPrice);
    }
}
