package com.swathimart.swathi_mart;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swathimart.swathi_mart.User;

@RestController
public class AuthController {

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return user;
    }
}
