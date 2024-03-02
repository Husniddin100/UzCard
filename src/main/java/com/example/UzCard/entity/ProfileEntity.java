package com.example.UzCard.entity;

import com.example.UzCard.enums.ProfileRole;
import com.example.UzCard.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(unique = true)
    private String username;
    @Column
    private LocalDateTime createdDate;
    @Column
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;
    @Column
    @Enumerated(EnumType.STRING)
    private ProfileRole role;
    @Column
    private String password;
}
