package com.fake.bank.demo.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "accountTransaction")
public class AccountTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	private String description;
	private BigDecimal amount;
	private BigDecimal runningBalance;
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "transaction_number")
	@JsonProperty (access = Access.READ_ONLY)
	private TransactionNumberSeq transactionNumber;

	
	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
	private Date transactionDate;
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "dbaccount_id")
    private DebitAccount debitAccount;
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "craccount_id")
    private CreditAccount creditAccount;
	
	@ManyToOne (fetch = FetchType.EAGER)
    private TransactionType transactionType;
	
	@ManyToOne (fetch = FetchType.EAGER)
    private TransactionState transactionState;
	
	@ManyToOne (fetch = FetchType.EAGER)
    private TransactionCategory transactionCategory;

	/*
	 * Constructor
	 */
	public AccountTransaction () {
		transactionNumber = new TransactionNumberSeq();
	}
	
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
	 * @return the debitAccount
	 */
	public DebitAccount getAccount() {
		return debitAccount;
	}

	/**
	 * @param debitAccount the debitAccount to set
	 */
	public void setAccount(DebitAccount debitAccount) {
		this.debitAccount = debitAccount;
	}

	/**
	 * @return the type
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the state
	 */
	public TransactionState getTransactionState() {
		return transactionState;
	}

	/**
	 * @param state the state to set
	 */
	public void setTransactionState(TransactionState transactionState) {
		this.transactionState = transactionState;
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
	public TransactionCategory getTransactionCategory() {
		return transactionCategory;
	}

	/**
	 * @param category the category to set
	 */
	public void setTransactionCategory(TransactionCategory transactionCategory) {
		this.transactionCategory = transactionCategory;
	}

}
