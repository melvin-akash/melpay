package com.melvin.melvinPay.service;

import com.melvin.melvinPay.dto.LoginDto;
import com.melvin.melvinPay.dto.UserRegistrationDto;
import com.melvin.melvinPay.dto.UserResponse;
import com.melvin.melvinPay.entity.Account;
import com.melvin.melvinPay.entity.User;
import com.melvin.melvinPay.repo.AccountDao;
import com.melvin.melvinPay.repo.RegistrationDao;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class RegistrationService {

    @Autowired
    RegistrationDao registrationDao;

    @Autowired
    AccountDao accountDao;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    ModelMapper modelMapper = new ModelMapper();
    public UserResponse register(UserRegistrationDto userRegistrationDto){
        
        log.info("testing");
        User user = modelMapper.map(userRegistrationDto , User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        registrationDao.save(user);
        createAccount(user);
        return modelMapper.map(userRegistrationDto , UserResponse.class);

    }

    public void createAccount(User user) {
        String accountNumber = generateUniqueAccountNumber();
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        accountDao.save(account);
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            // Generate a UUID as the account number
            accountNumber = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
        } while (accountDao.findByAccountNumber(accountNumber) != null);

        return accountNumber;
    }

    public void userLogin(LoginDto loginDto) {
        User user = registrationDao.findByEmail(loginDto.getEmail());
        if(!passwordEncoder.matches(loginDto.getPassword() , user.getPassword())) {
             throw new BadCredentialsException("invalid email or password");
        }
    }
}
