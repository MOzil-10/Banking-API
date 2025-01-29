package com.banking.api.service.implementation;

import com.banking.api.entity.Account;
import com.banking.api.entity.Transaction;
import com.banking.api.entity.TransactionType;
import com.banking.api.entity.User;
import com.banking.api.exceptions.InvalidAmountException;
import com.banking.api.exceptions.NotFoundException;
import com.banking.api.exceptions.UnauthorizedException;
import com.banking.api.repository.AccountRepository;
import com.banking.api.repository.TransactionRepository;
import com.banking.api.service.interfaces.AccountService;
import com.banking.api.util.ApiMessages;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

public class AccountImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final TransactionRepository transactionRepository;

    public AccountImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder, TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Account createAccount(User user) {
        Account account = new Account();
        account.setAccountNumber(generateUniqueAccountNumber());
        account.setBalance(0.0);
        account.setUser(user);

        return accountRepository.save(account);
    }

    @Override
    public boolean isPinCreated(String accountNumber) {
        return false;
    }

    @Override
    public void createPin(String accountNumber, String password, String pin) {

    }

    @Override
    public void updatePin(String accountNumber, String oldPin, String password, String newPin) {

    }

    @Override
    public void cashDeposit(String accountNumber, String pin, double amount) {

    }

    @Override
    public void cashWithdrawal(String accountNumber, String pin, double amount) {

    }

    @Override
    public void transferFunds(String sourceAccountNumber, String targetAccountNumber, String pin, double amount) {

    }

    private Account getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()-> new NotFoundException(ApiMessages.ACCOUNT_NOT_FOUND.getMessage()));
    }

    private String generateUniqueAccountNumber(){
        String accountNumber;
        do{
            accountNumber = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
        } while (accountRepository.findByAccountNumber(accountNumber).isPresent());
        return accountNumber;
    }

    private void validatePin(String accountNumber, String pin) {
        Account account = getAccountByAccountNumber(accountNumber);

        if(account.getPin() == null) {
            throw new UnauthorizedException(ApiMessages.PIN_INVALID_ERROR.getMessage());
        }

        if (pin == null || pin.isEmpty() || !passwordEncoder.matches(pin, account.getPin())) {
            throw new UnauthorizedException(ApiMessages.PIN_INVALID_ERROR.getMessage());
        }
    }

    private void validatePassword(String accountNumber, String password) {
        Account account = getAccountByAccountNumber(accountNumber);

        if(password == null || password.isEmpty() || !passwordEncoder.matches(password, account.getUser().getPassword())) {
            throw new UnauthorizedException(ApiMessages.PASSWORD_INVALID_ERROR.getMessage());
        }
    }

    private void validateAmount(double amount) {
        if(amount <= 0) {
            throw new InvalidAmountException(ApiMessages.NEGATIVE_AMOUNT.getMessage());
        }
        if(amount % 100 !=0) {
            throw new InvalidAmountException(ApiMessages.AMOUNT_NOT_MULTIPLE_OF_100_ERROR.getMessage());
        }
        if(amount > 100000) {
            throw new InvalidAmountException(ApiMessages.AMOUNT_EXCEED_100_100_ERROR.getMessage());
        }
    }

    private void validatePinFormat(String pin) {
        if(pin == null | pin.isEmpty() || !pin.matches("[0-9]{4}")) {
            throw new InvalidAmountException(ApiMessages.PIN_FORMAT_INVALID_ERROR.getMessage());
        }
    }

    private void saveTransaction(Account source, Account target, double amount, TransactionType type) {
        Transaction transaction = new Transaction();

        transaction.setAmount(amount);
        transaction.setTransactionType(type);
        transaction.setTransactionDate(LocalDate.now());
        transaction.setSourceAccount(source);
        transaction.setTragetAccount(target);

        transactionRepository.save(transaction);

    }
}
