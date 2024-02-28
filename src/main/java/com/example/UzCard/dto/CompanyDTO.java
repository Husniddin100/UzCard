package com.example.UzCard.dto;

import com.example.UzCard.enums.CompanyRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CompanyDTO {
    private String id;
    private String name;
    private String address;
    private String contact;
    private LocalDateTime createdDate;
    private Boolean visible;
    private CompanyRole role;
    private String code;
    private String username;
    private String password;
}
