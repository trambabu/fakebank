package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.AccountStanding;


@Repository
public interface AccountStandingRepository extends JpaRepository<AccountStanding, Long> {
	
	AccountStanding findByName (String name);
	AccountStanding findByCode (String code);
	
	List<AccountStanding> findAll ();

}
