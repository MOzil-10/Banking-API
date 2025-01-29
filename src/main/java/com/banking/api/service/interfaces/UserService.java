package com.banking.api.service.interfaces;

import com.banking.api.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<String> registerUSer(User user);
}
