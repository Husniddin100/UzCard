package com.example.UzCard.dto;

import com.example.UzCard.enums.TransferStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferDTO {
    private String id;
    private String fromCardId;
    private String toCardId;
    private Long totalAmount;
    private Long amount;
    private Long serviceAmount;
    private Long servicePercentage;
    private LocalDateTime createdDate;
    private TransferStatus status;
    private String companyId;
}
