package com.example.UzCard.repository;

import com.example.UzCard.entity.CompanyEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<CompanyEntity, String>, PagingAndSortingRepository<CompanyEntity, String> {
    @Transactional
    @Modifying
    @Query("update CompanyEntity set visible=false where id=?1")
    int updateVisible(String id);

    Optional<CompanyEntity> findByUsernameAndPassword(String username, String password);
}
