package com.example.UzCard.service;

import com.example.UzCard.Util.MDUtil;
import com.example.UzCard.dto.CompanyDTO;
import com.example.UzCard.entity.CompanyEntity;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyDTO create(CompanyDTO dto) {
        CompanyEntity entity = new CompanyEntity();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setContact(dto.getContact());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setVisible(Boolean.TRUE);
        entity.setRole(dto.getRole());
        entity.setCode(dto.getCode());
        entity.setUsername(dto.getUsername());
        entity.setPassword(MDUtil.encode(dto.getPassword()));
        companyRepository.save(entity);

        dto.setId(entity.getId());
        dto.setVisible(entity.getVisible());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }


    public CompanyDTO update(String id, CompanyDTO dto) {
        Optional<CompanyEntity> optional = companyRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("company not found");
        }
        CompanyEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setContact(dto.getContact());
        entity.setVisible(dto.getVisible());
        entity.setRole(dto.getRole());
        entity.setCode(dto.getCode());
        entity.setUsername(dto.getUsername());
        companyRepository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }


    public Boolean delete(String id) {
        Optional<CompanyEntity> optional = companyRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("company not found");
        }
        int res = companyRepository.updateVisible(id);
        if (res == 0) {
            throw new AppBadException("error deleting");
        }
        return true;
    }
}
