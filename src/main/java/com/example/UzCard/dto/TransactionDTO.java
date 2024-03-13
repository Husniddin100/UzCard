package com.example.UzCard.dto;

import com.example.UzCard.enums.TransactionStatus;
import com.example.UzCard.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDTO {
    private String id;
    private String cardId;
    private Long amount;
    private TransactionType transactionType;
    private String transferId;
    private LocalDateTime created_date;
    private TransactionStatus transactionStatus;
    private LocalDateTime createdDate;
    private TransactionStatus status;
}
