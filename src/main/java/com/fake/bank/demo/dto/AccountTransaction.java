package com.fake.bank.demo.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransaction {

	private Long id;
	private String description;
	private BigDecimal amount;
	private BigDecimal runningBalance;
	
	private TransactionNumberSeqDTO transactionNumber;

	
	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
	private Date transactionDate;
	
	@JsonIgnore
    private AccountDTO account;
	
    private TransactionTypeDTO transactionTypeDTO;
	
    private TransactionStateDTO transactionStateDTO;
	
    private TransactionCategoryDTO transactionCategoryDTO;

	/*
	 * Constructor
	 */
//	public AccountTransaction () {
//		transactionNumber = new TransactionNumberSeqDTO();
//	}
//	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		
		
		this.amount = new BigDecimal(amount.doubleValue()).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the account
	 */
	public AccountDTO getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	/**
	 * @return the type
	 */
	public TransactionTypeDTO getTransactionType() {
		return transactionTypeDTO;
	}
	
	/**
	 * @param transactionTypeDTO the transactionTypeDTO to set
	 */
	public void setTransactionType(TransactionTypeDTO transactionTypeDTO) {
		this.transactionTypeDTO = transactionTypeDTO;
	}

	/**
	 * @return the state
	 */
	public TransactionStateDTO getTransactionState() {
		return transactionStateDTO;
	}

	/**
	 * @param state the state to set
	 */
	public void setTransactionState(TransactionStateDTO transactionStateDTO) {
		this.transactionStateDTO = transactionStateDTO;
	}

	/**
	 * @return the runningBalance
	 */
	public BigDecimal getRunningBalance() {
		return runningBalance;
	}

	/**
	 * @param runningBalance the runningBalance to set
	 */
	public void setRunningBalance(BigDecimal runningBalance) {
		this.runningBalance = new BigDecimal(runningBalance.doubleValue()).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * @return the transactionNumber
	 */
	public Long getTransactionNumber() {
		return transactionNumber.getId();
	}

	/**
	 * @return the category
	 */
	public TransactionCategoryDTO getTransactionCategory() {
		return transactionCategoryDTO;
	}

	/**
	 * @param category the category to set
	 */
	public void setTransactionCategory(TransactionCategoryDTO transactionCategoryDTO) {
		this.transactionCategoryDTO = transactionCategoryDTO;
	}

}
