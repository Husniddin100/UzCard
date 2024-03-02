package com.example.UzCard.dto;

import com.example.UzCard.enums.ProfileRole;
import com.example.UzCard.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private LocalDateTime createdDate;
    private ProfileStatus status;
    private ProfileRole role;
    private String password;
    private String jwt;
}
