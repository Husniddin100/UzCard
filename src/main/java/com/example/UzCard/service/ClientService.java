package com.example.UzCard.service;

import com.example.UzCard.dto.ClientDTO;
import com.example.UzCard.entity.ClientEntity;
import com.example.UzCard.enums.ClientStatus;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO create(ClientDTO dto) {
        ClientEntity entity = new ClientEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setPhone(dto.getPhone());
        entity.setStatus(ClientStatus.ACTIVE);
        entity.setPassword_series(dto.getPassword_series());
        entity.setPassport_number(dto.getPassport_number());
        clientRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ClientDTO update(String id, ClientDTO dto) {
        Optional<ClientEntity> optional = clientRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("client not found");
        }
        ClientEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setMiddle_name(dto.getMiddle_name());
        entity.setPhone(dto.getPhone());
        clientRepository.save(entity);
        return dto;
    }

    public ClientEntity findById(String id) {
        Optional<ClientEntity> optional = clientRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("profile not found ");
        }
        return optional.get();
    }

    public ClientDTO getById(String id) {
        ClientEntity entity = findById(id);
        return toDTO(entity);
    }


    public ClientDTO toDTO(ClientEntity entity) {
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setName(entity.getName());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setMiddle_name(entity.getMiddle_name());
        dto.setPassport_number(entity.getPassport_number());
        dto.setPassword_series(entity.getPassword_series());
        return dto;
    }
}
