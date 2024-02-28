package com.example.UzCard.entity;

import com.example.UzCard.enums.CompanyRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GenericGenerator(name = "company_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column
    private String name;
    @Column(unique = true)
    private String username;
    @Column
    private String address;
    @Column
    private String contact;
    @Column
    private LocalDateTime createdDate;
    @Column
    private Boolean visible;
    @Column
    @Enumerated(EnumType.STRING)
    private CompanyRole role;
    @Column
    private String code;
    @Column
    private String password;
}
