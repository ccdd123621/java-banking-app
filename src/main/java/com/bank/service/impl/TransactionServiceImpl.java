package com.bank.service.impl;

import com.bank.entity.Transaction;
import com.bank.repository.TransactionRepository;
import com.bank.service.NotificationService;
import com.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Send email notification
        if (transaction.getAccount() != null && transaction.getAccount().getUser() != null) {
            String email = transaction.getAccount().getUser().getEmail();
            if (email != null && !email.isEmpty()) {
                String subject = "Transaction Alert - Banking App";
                String message = "Dear " + transaction.getAccount().getUser().getUsername() +
                        ",\n\nYour account was " + transaction.getType() + "ed with amount: " +
                        transaction.getAmount() + ".\n\nThank you for banking with us.";
                notificationService.sendTransactionEmail(email, subject, message);
            }
        }

        return savedTransaction;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
