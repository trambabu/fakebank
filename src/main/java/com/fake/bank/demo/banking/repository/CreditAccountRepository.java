package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.CreditAccount;
import com.fake.bank.demo.entity.CreditAccountType;
import com.fake.bank.demo.user.Users;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {
		
	List<CreditAccount> findAll ();
	
	List<CreditAccount> findByCreditAccountType (CreditAccountType CreditAccountType);
	
	List<CreditAccount> findByCreditAccountType_Category (String category);
	
	List<CreditAccount> findByOwner (Users user);
	
	List<CreditAccount> findByCoowner (Users user);
	
	List<CreditAccount> findByOwnerAndAccountType (Users user, CreditAccountType CreditAccountType);
	
	List<CreditAccount> findByCoownerAndAccountType (Users user, CreditAccountType CreditAccountType);
	
	List<CreditAccount> findByOwnerAndAccountType_Category (Users user, String category);
	
	List<CreditAccount> findByCoownerAndAccountType_Category (Users user, String category);
	
	void deleteByOwner(Users user);
}
