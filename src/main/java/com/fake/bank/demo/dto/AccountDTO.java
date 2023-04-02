package com.fake.bank.demo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fake.bank.demo.user.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
		
	private Long id;
	private String name;
	
	private AccountNumberSeqDTO accountNumber;
	
	private BigDecimal currentBalance;
	private BigDecimal openingBalance;
	private double interestRate;
	private double paymentAmount;
	private int paymentTerm;
	
	private AccountTypeDTO accountTypeDTO;
	
	private OwnershipTypeDTO ownershipTypeDTO;
		
	private AccountStandingDTO accountStandingDTO;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
	private Date dateOpened;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
	private Date dateClosed;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
	private Date paymentDue;
	
	@JsonIgnore
	private Users owner;
	
	private Users coowner;
	
    @JsonIgnore
    private List<AccountTransaction> acountTransactionList;
	
	
}
