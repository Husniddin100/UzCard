package com.example.UzCard.service;

import com.example.UzCard.Util.JWTUtil;
import com.example.UzCard.Util.MDUtil;
import com.example.UzCard.dto.AuthDTO;
import com.example.UzCard.dto.CompanyDTO;
import com.example.UzCard.dto.ProfileDTO;
import com.example.UzCard.entity.CompanyEntity;
import com.example.UzCard.entity.ProfileEntity;
import com.example.UzCard.enums.ProfileStatus;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.CompanyRepository;
import com.example.UzCard.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public ProfileDTO login(AuthDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByUsernameAndPassword(dto.getUsername(),MDUtil.encode(dto.getPassword()));
        if (optional.isEmpty()) {
            throw new AppBadException("profile not found");
        }
        ProfileEntity entity = optional.get();

        if (!entity.getStatus().equals(ProfileStatus.ACTIVE)) {
            throw new AppBadException("your profile blocked");
        }
        ProfileDTO dto1 = new ProfileDTO();

        dto1.setName(entity.getName());
        dto1.setUsername(entity.getUsername());
        dto1.setRole(entity.getRole());
        dto1.setJwt(JWTUtil.encode(entity.getUsername(), entity.getRole()));
        return dto1;
    }

    public CompanyDTO companyLogin(AuthDTO dto) {
        Optional<CompanyEntity> optional = companyRepository.findByUsernameAndPassword(dto.getUsername(), MDUtil.encode(dto.getPassword()));
        if (optional.isEmpty()) {
            throw new AppBadException("company not found");
        }
        CompanyEntity entity = optional.get();
        CompanyDTO dto1 = new CompanyDTO();

        dto1.setName(entity.getName());
        dto1.setUsername(entity.getUsername());
        dto1.setRole(entity.getRole());
        dto1.setJwt(JWTUtil.companyEncode(entity.getUsername(), entity.getRole()));
        return dto1;
    }
}
