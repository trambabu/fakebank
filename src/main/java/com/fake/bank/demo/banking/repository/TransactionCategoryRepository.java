package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.TransactionCategory;

@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long>{
	
	TransactionCategory findByName (String name);
	TransactionCategory findByCode (String code);
	
	List<TransactionCategory> findAll();

}
