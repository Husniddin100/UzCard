package com.example.UzCard.service;

import com.example.UzCard.dto.CardDTO;
import com.example.UzCard.entity.CardEntity;
import com.example.UzCard.enums.CardStatus;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public CardDTO createCard(CardDTO dto) {
        CardEntity entity = new CardEntity();
        entity.setNumber(dto.getNumber());
        entity.setExpireDate(dto.getExpired_date());
        entity.setPhone(null);
        entity.setStatus(CardStatus.ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setClientId(dto.getClientId());
        entity.setCompanyId(dto.getCompanyId());
        entity.setBalance(0L);
        cardRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(dto.getCreatedDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Boolean changeStatus(String id, CardStatus status) {
        Optional<CardEntity> optional = cardRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("card not found");
        }
        int effectiveRows = cardRepository.changeStatus(id, status);
        if (effectiveRows == 0) {
            throw new AppBadException("error change status");
        }
        return true;
    }

    public Boolean assignPhone(String id, String phone) {
        Optional<CardEntity> optional = cardRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("card not found");
        }
        int effectiveRows = cardRepository.assignPhone(id, phone);
        if (effectiveRows == 0) {
            throw new AppBadException("error assign phone");
        }
        return true;
    }
}
