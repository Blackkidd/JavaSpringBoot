package com.example.hello.model;

import lombok.Data;

@Data
public class ModelRegisterRequest {
    private String email;
    private String password;
    private String username;
}
