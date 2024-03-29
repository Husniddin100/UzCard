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
    @Column(name = "card_id")
    private String cardId;
    @OneToOne
    @JoinColumn(name = "card_id",insertable = false, updatable = false)
    private CardEntity card;
    @Column
    private Long amount;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name = "transfer_id")
    private String transferId;
    @ManyToOne
    @JoinColumn(name = "transfer_id",insertable = false,updatable = false)
    private TransferEntity transfer;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    // soon
    /*@Column
    private String transferId;
    @OneToMany
    @JoinColumn(insertable = false,updatable = false)*/
    @Column
    private LocalDateTime createdDate;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
}
