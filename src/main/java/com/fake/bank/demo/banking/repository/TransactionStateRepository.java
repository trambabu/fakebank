package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.TransactionState;

@Repository
public interface TransactionStateRepository extends JpaRepository<TransactionState, Long> {
	
	TransactionState findByName (String name);
	TransactionState findByCode (String code);
	
	List<TransactionState> findAll();

}
