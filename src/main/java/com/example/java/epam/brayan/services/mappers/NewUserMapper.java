package com.example.java.epam.brayan.services.mappers;

import com.example.java.epam.brayan.config.MappingConfig;
import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.services.data.NewUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public interface NewUserMapper {
    User toUser(NewUser newUser);
}
