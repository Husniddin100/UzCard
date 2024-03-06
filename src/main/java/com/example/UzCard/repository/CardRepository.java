package com.example.UzCard.repository;

import com.example.UzCard.entity.CardEntity;
import com.example.UzCard.enums.CardStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<CardEntity, String> {
    @Modifying
    @Transactional
    @Query("update CardEntity set status=?2 where id=?1")
    int changeStatus(String id, CardStatus status);

    @Modifying
    @Transactional
    @Query("update CardEntity set phone=?2 where id=?1")
    int assignPhone(String id, String phone);
}
