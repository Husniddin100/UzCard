package com.example.UzCard.entity;

import com.example.UzCard.enums.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private Integer number;
    @Column
    private String expireDate;
    @Column
    private String phone;
    @Column
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @Column
    private LocalDateTime createdDate;
    @Column
    private Long balance;
    @Column
    private String clientId;
    @ManyToOne
    @JoinColumn(updatable = false, insertable = false)
    private ClientEntity client;
    @Column
    private String companyId;
    @ManyToOne
    @JoinColumn(insertable = false,updatable = false)
    private CompanyEntity company;
}
