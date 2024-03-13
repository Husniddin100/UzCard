package com.example.UzCard.service;

import com.example.UzCard.enums.TransactionStatus;
import com.example.UzCard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
}
