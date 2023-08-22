package com.example.java.epam.brayan.controllers.requests;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class CreateUserRequest {
    String name;
    String email;
}
