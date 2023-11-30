package com.melvin.melvinPay.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String age;

    @Column(unique = true)
    private String email;

    private String password;

    private String gender;

    private String mobile;

    private String address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;


}
