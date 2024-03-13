package com.example.UzCard.entity;

import com.example.UzCard.enums.TransferStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transfer")
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
   /* @Column
    private String fromCardId;
    @OneToOne
    @JoinColumn(insertable = false, updatable = false)
    private CardEntity card;
    @Column
    private String toCardId;
    @Column
    private Long totalAmount;
    @Column
    private Long amount;
    @Column
    private Long serviceAmount;
    @Column
    private Long servicePercentage;
    @Column
    private LocalDateTime createdDate;
    @Column
    private TransferStatus transferStatus;
    @Column
    private String companyId;*/

    @Enumerated(EnumType.STRING)
    @Column
    private TransferStatus status;
    @Column(name = "company_id")
    private String companyId;
    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;
}
