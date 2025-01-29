package com.banking.api.service.implementation;

import com.banking.api.entity.User;
import com.banking.api.service.interfaces.AccountService;
import com.banking.api.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;

public class UserServiceImpl implements UserService {

    private final AccountService accountService;

    public UserServiceImpl(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<String> registerUSer(User user) {
        return null;
    }
}
