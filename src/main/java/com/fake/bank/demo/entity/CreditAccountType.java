package com.fake.bank.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "creditaccountType")
public class CreditAccountType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	@Column
	private String code;
	@Column
	private String category;
	@Column(columnDefinition = "varchar(255) default 'DEBIT'")
	private String name;
	@Column(columnDefinition = "double default 5")
	private double interestRate;
	
	@Column(columnDefinition="Decimal(10,2) default '500.00'")
	private BigDecimal minDeposit;
	@Column(columnDefinition="Decimal(10,2) default '5000.00'")
	private BigDecimal overdraftLimit;
	@Column(columnDefinition="Decimal(10,2) default '5.00'")
	private BigDecimal overdraftFee;
	
	// default constructor
	public CreditAccountType () {}
	
	public CreditAccountType (String code, String category, String name, double interestRate, 
						BigDecimal minDeposit, BigDecimal overdraftLimit, BigDecimal overdraftFee) {
		
		this.code = code;
		this.name = name;
		this.category = category;
		this.interestRate = interestRate;
		this.minDeposit = minDeposit;
		this.overdraftLimit = overdraftLimit;
		this.overdraftFee = overdraftFee;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	/**
	 * @return the minDeposit
	 */
	public BigDecimal getMinDeposit() {
		return minDeposit;
	}
	
	/**
	 * @param minDeposit the minDeposit to set
	 */
	public void setMinDeposit(BigDecimal minDeposit) {
		this.minDeposit = minDeposit;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	

	/**
	 * @return the overdraftLimit
	 */
	public BigDecimal getOverdraftLimit() {
		return overdraftLimit;
	}

	/**
	 * @param overdraftLimit the overdraftLimit to set
	 */
	public void setOverdraftLimit(BigDecimal overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	
	/**
	 * @return the overdraftFee
	 */
	public BigDecimal getOverdraftFee() {
		return overdraftFee;
	}

	/**
	 * @param overdraftFee the overdraftFee to set
	 */
	public void setOverdraftFee(BigDecimal overdraftFee) {
		this.overdraftFee = overdraftFee;
	}

	public String toString() {
	    
		String accountType = "\n\nAccount Type ***********************";
    
		accountType += "\nId:\t\t\t" 			+ this.getId();
		accountType += "\nName:\t\t" 			+ this.getName();
		accountType += "\nCode:\t\t\t" 			+ this.getCode();
		accountType += "\nCategory:\t\t" 		+ this.getCategory();
		accountType += "\nInterest Rate:\t" 	+ this.getInterestRate();
		accountType += "\nMinimum Deposit:\t" 	+ this.getMinDeposit();
		accountType += "\nOverdraft Limit:\t" 	+ this.getOverdraftLimit();
		accountType += "\nOverdraft Fee:\t" 	+ this.getOverdraftFee();
	    
	    return accountType;
	    
	}
	
}
