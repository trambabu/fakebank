package com.fake.bank.demo.banking.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fake.bank.demo.entity.DebitAccount;
import com.fake.bank.demo.entity.AccountTransaction;
import com.fake.bank.demo.entity.TransactionCategory;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
	
	public List<AccountTransaction> findAllByAccount (DebitAccount debitAccount);
	public AccountTransaction findTopByAccountOrderByTransactionDateDesc (DebitAccount debitAccount);
	public List<AccountTransaction> findTop2ByAccountOrderByTransactionDateDesc (DebitAccount debitAccount);
	
	public List<AccountTransaction> findAllByAccountAndAmountGreaterThan (DebitAccount debitAccount, BigDecimal amount);
	public List<AccountTransaction> findAllByAccountAndAmountLessThan (DebitAccount debitAccount, BigDecimal amount);
	
	public List<AccountTransaction> findAllByAccountAndAmountGreaterThanAndTransactionDateAfter (DebitAccount debitAccount, BigDecimal amount, Date date);
	public List<AccountTransaction> findAllByAccountAndAmountLessThanAndTransactionDateAfter (DebitAccount debitAccount, BigDecimal amount, Date date);
	
	public List<AccountTransaction> findAllByAccountAndTransactionCategory (DebitAccount debitAccount, TransactionCategory category);
	public List<AccountTransaction> findAllByAccountAndTransactionCategoryAndTransactionDateAfter (DebitAccount debitAccount, TransactionCategory category, Date date);

}
