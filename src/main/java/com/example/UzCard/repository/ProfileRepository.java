package com.example.UzCard.repository;

import com.example.UzCard.entity.ProfileEntity;
import com.example.UzCard.enums.ProfileStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity, String> {
    @Query("from ProfileEntity where username=?1")
    Optional<ProfileEntity> findByUsername(String username);

    Optional<ProfileEntity> findByUsernameAndPassword(String username, String password);

    @Modifying
    @Transactional
    @Query("update ProfileEntity set status=?2  where id=?1")
    void changeProfileStatus(String id, ProfileStatus status);
}
