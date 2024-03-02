package com.example.UzCard.service;

import com.example.UzCard.Util.MDUtil;
import com.example.UzCard.dto.CompanyDTO;
import com.example.UzCard.entity.CompanyEntity;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
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

    public PageImpl pagination(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");

        Pageable paging = PageRequest.of(page - 1, size, sort);
        Page<CompanyEntity> channelPage = companyRepository.findAll(paging);

        List<CompanyEntity> entityList = channelPage.getContent();
        Long totalElements = channelPage.getTotalElements();

        List<CompanyDTO> dtoList = new LinkedList<>();
        for (CompanyEntity entity : entityList) {
            dtoList.add(toDTO(entity));
        }
        return new PageImpl<>(dtoList, paging, totalElements);
    }

    private CompanyDTO toDTO(CompanyEntity entity) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setContact(entity.getContact());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setVisible(entity.getVisible());
        dto.setRole(entity.getRole());
        dto.setCode(entity.getCode());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }
}
