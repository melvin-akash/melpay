package com.melvin.melvinPay.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(unique = true)
    private String accountNumber;
    private double balance;
    private String account_type = "Saving";
    private String branch = "Stillorgan";
    @Column(name = "eircode")
    private String EIR_CODE = "D04";
    private String Pin;
    private String accountstatus;
    @OneToOne
    @JoinColumn(name = "user")
    private User user;
}
