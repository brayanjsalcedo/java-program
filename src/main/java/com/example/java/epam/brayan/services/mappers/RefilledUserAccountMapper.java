package com.example.java.epam.brayan.services.mappers;

import com.example.java.epam.brayan.config.MappingConfig;
import com.example.java.epam.brayan.data.entities.UserAccount;
import com.example.java.epam.brayan.services.data.RefilledUserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public interface RefilledUserAccountMapper {
    UserAccount refillUserAccount(RefilledUserAccount refilledUserAccount, @MappingTarget UserAccount userAccount);

    default UserAccount addBalances(UserAccount userAccount, RefilledUserAccount refilledUserAccount) {
        userAccount.setBalance(userAccount.getBalance() + refilledUserAccount.getBalance());
        return userAccount;
    }
}
