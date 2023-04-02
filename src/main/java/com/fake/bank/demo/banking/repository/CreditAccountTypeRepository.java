package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.CreditAccountType;


@Repository
public interface CreditAccountTypeRepository extends JpaRepository<CreditAccountType, Long> {
	
	CreditAccountType findByName(String name);
	CreditAccountType findByCode(String code);
	
	List<CreditAccountType> findByCategory(String category);
	List<CreditAccountType> findAll();
	
	

}
