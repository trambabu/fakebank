package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.TransactionType;


@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
	
	TransactionType findByName (String name);
	TransactionType findByCode (String code);
	
	List<TransactionType> findAll();

}
