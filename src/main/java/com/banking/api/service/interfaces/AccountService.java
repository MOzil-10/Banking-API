package com.banking.api.service.interfaces;

import com.banking.api.entity.Account;
import com.banking.api.entity.User;

public interface AccountService {

    Account createAccount(User user);
    boolean isPinCreated(String accountNumber);
    void createPin(String accountNumber, String password, String pin);
    void updatePin(String accountNumber, String oldPin, String password, String newPin);
    void cashDeposit(String accountNumber, String pin, double amount);
    void cashWithdrawal(String accountNumber, String pin, double amount);
    void transferFunds(String sourceAccountNumber, String targetAccountNumber, String pin, double amount );
}
