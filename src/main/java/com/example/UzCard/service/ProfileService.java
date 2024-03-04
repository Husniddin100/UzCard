package com.example.UzCard.service;

import com.example.UzCard.Util.MDUtil;
import com.example.UzCard.dto.ProfileDTO;
import com.example.UzCard.entity.ProfileEntity;
import com.example.UzCard.enums.ProfileStatus;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public ProfileDTO create(ProfileDTO dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setRole(dto.getRole());
        entity.setUsername(dto.getUsername());
        entity.setPassword(MDUtil.encode(dto.getPassword()));
        profileRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public ProfileDTO update(String id, ProfileDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("profile not found");
        }
        ProfileEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setStatus(dto.getStatus());
        entity.setRole(dto.getRole());
        entity.setUsername(dto.getUsername());
        profileRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public Boolean changeStatus(String id, ProfileStatus status) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("profile not found");
        }
        profileRepository.changeProfileStatus(id, status);
        return true;
    }
}
