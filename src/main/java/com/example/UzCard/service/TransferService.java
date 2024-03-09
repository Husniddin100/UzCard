package com.example.UzCard.service;

import com.example.UzCard.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;

}
