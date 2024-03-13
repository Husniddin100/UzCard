package com.example.UzCard.entity;

import com.example.UzCard.enums.TransactionStatus;
import com.example.UzCard.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String cardId;
    @OneToOne
    @JoinColumn(name = "card_id", insertable = false, updatable = false)
    private CardEntity card;
    @Column
    private Long amount;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column
    private String transferId;
    @ManyToOne
    @JoinColumn(name = "transfer_id")
    private TransferEntity transfer;
    @Column
    private LocalDateTime created_date;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
}
