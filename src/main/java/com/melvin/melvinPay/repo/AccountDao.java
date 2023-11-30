package com.melvin.melvinPay.repo;

import com.melvin.melvinPay.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<Account , Long> {
    Account findByAccountNumber(String accountNumber);
}
