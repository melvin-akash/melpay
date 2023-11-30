package com.melvin.melvinPay.repo;

import com.melvin.melvinPay.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDao extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
