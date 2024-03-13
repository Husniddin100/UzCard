package com.example.UzCard.repository;

import com.example.UzCard.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity,String> {
}
