package com.melvin.melvinPay.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRegistrationDto {

    private String firstName;

    private String lastName;

    private String age;

    private String email;

    private String password;

    private String gender;

    private String mobile;

    private String address;
}
