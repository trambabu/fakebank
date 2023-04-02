package com.fake.bank.demo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.DebitAccount;
import com.fake.bank.demo.entity.DebitAccountType;
import com.fake.bank.demo.user.Users;

@Repository
public interface DebitAccountRepository extends JpaRepository<DebitAccount, Long> {
		
	List<DebitAccount> findAll ();
	
	List<DebitAccount> findByDebitAccountType (DebitAccountType debitAccountType);
	
	List<DebitAccount> findByDebitAccountType_Category (String category);
	
	List<DebitAccount> findByOwner (Users user);
	
	List<DebitAccount> findByCoowner (Users user);
	
	List<DebitAccount> findByOwnerAndAccountType (Users user, DebitAccountType debitAccountType);
	
	List<DebitAccount> findByCoownerAndAccountType (Users user, DebitAccountType debitAccountType);
	
	List<DebitAccount> findByOwnerAndAccountType_Category (Users user, String category);
	
	List<DebitAccount> findByCoownerAndAccountType_Category (Users user, String category);
	
	void deleteByOwner(Users user);
}
