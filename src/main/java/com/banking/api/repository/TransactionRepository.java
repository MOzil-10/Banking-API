package com.banking.api.repository;

import com.banking.api.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> findBySourceAccount(String sourceAccountNumber);
}
