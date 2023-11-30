package com.melvin.melvinPay.controller;

import com.melvin.melvinPay.dto.LoginDto;
import com.melvin.melvinPay.dto.UserRegistrationDto;
import com.melvin.melvinPay.dto.UserResponse;
import com.melvin.melvinPay.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    RegistrationService registrationService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> userRegister(@RequestBody UserRegistrationDto userRegistrationDto){
        UserResponse userResponse = registrationService.register(userRegistrationDto);
        return ResponseEntity.ok(userResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDto loginDto){
        registrationService.userLogin(loginDto);
        return ResponseEntity.ok("success");
    }

}
