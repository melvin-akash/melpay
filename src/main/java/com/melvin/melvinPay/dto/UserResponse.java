package com.melvin.melvinPay.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserResponse {

    private String firstName;

    private String lastName;

    private String age;

    private String email;

    private String gender;

    private String mobile;

    private String address;
}
