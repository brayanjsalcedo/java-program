package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SufficientUserAccountBalanceService {

    public void ensureSufficientBalance(UserAccount userAccount, double ticketPrice) {
        if (userAccount.getBalance() < ticketPrice) {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }
}
