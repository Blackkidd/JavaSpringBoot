package com.example.hello.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.business.TestBusiness;
import com.example.hello.model.ModelRegisterRequest;
import com.example.hello.model.TestResponse;

// api 
@RestController
@RequestMapping("/test")
public class TestApi {

    // method 1 field injection
    // @Autowired
    // private TestBusiness business;

    // method 2 constructor injection best performance
    private final TestBusiness business;

    public TestApi(TestBusiness business) {
        this.business = business;
    }

    // Get
    @GetMapping
    public TestResponse test() {
        TestResponse res = new TestResponse();
        res.setName("Parinya");
        res.setFood("Noodle");
        return res;
    }

    // Post
    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody ModelRegisterRequest request) {
        String res;
        try {
            res = business.register(request);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // Http 417
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }


}
