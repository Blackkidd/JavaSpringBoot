package com.example.hello.business;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.hello.model.ModelRegisterRequest;

@Service
public class TestBusiness {
    public String register(ModelRegisterRequest request) throws Exception {
        if (request == null) {
            // throw new IDException("null request");
            throw new Exception("null request");
        }

        // validate email
        if (Objects.isNull(request.getEmail())) {
            throw new Exception("null email");
        }
        return "";
    }
}
