package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.DebitAccountType;


@Repository
public interface DebitAccountTypeRepository extends JpaRepository<DebitAccountType, Long> {
	
	DebitAccountType findByName(String name);
	DebitAccountType findByCode(String code);
	
	List<DebitAccountType> findByCategory(String category);
	List<DebitAccountType> findAll();
	
	

}
