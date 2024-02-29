package com.example.UzCard.repository;

import com.example.UzCard.entity.ProfileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity,String> {

    Optional<ProfileEntity> findByUsername(String username);
}
