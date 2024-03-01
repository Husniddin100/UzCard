package com.example.UzCard.service;

import com.example.UzCard.Util.JWTUtil;
import com.example.UzCard.dto.AuthDTO;
import com.example.UzCard.dto.ProfileDTO;
import com.example.UzCard.entity.ProfileEntity;
import com.example.UzCard.enums.ProfileStatus;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;

    public ProfileDTO login(AuthDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
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
        dto1.setJwt(JWTUtil.encode(entity.getUsername(),entity.getRole()));
        return dto1;
    }
}
