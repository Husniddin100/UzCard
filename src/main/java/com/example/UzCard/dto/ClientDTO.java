package com.example.UzCard.dto;

import com.example.UzCard.enums.ClientStatus;
import com.example.UzCard.enums.ProfileRole;
import com.example.UzCard.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClientDTO {
    private String id;
    private String name;
    private String surname;
    private String middle_name;
    private LocalDateTime createdDate;
    private String phone;
    private ClientStatus status;
    private String password_series;
    private String passport_number;
}
