package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.RefillUserAccountRequest;
import com.example.java.epam.brayan.services.RefillUserAccountService;
import com.example.java.epam.brayan.services.data.RefilledUserAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user-accounts")
public class UserAccountController {

    private final RefillUserAccountService refillUserAccountService;

    @PostMapping("/{userId}/refill")
    public void refillUserAccount(
            @PathVariable long userId,
            @RequestBody RefillUserAccountRequest refillUserAccountRequest
    ) {
        log.debug("Refill user account by id {}: {}", userId, refillUserAccountRequest);

        refillUserAccountService.refillUserAccount(
                userId,
                RefilledUserAccount.builder()
                        .balance(refillUserAccountRequest.getBalance())
                        .build()
        );
    }
}
