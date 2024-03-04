package com.example.UzCard.dto;

import com.example.UzCard.enums.CardStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CardDTO {
    private String id;
    private Integer number;
    private String expired_date;
    private String phone;
    private CardStatus status;
    private LocalDateTime createdDate;
    private Long balance;
    private String clientId;
    private String companyId;

}
