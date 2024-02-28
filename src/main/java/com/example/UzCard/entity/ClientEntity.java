package com.example.UzCard.entity;

import com.example.UzCard.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GenericGenerator(name = "client_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String middle_name;
    @Column
    private LocalDateTime createdDate;
    @Column
    private String phone;
    @Column
    @Enumerated(EnumType.STRING)
    private ClientStatus status;
    @Column(unique = true)
    private String password_series;
    @Column(unique = true)
    private String passport_number;
}
