package com.fake.bank.demo.batchscheduler;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fake.bank.demo.dto.AccountDTO;
import com.fake.bank.demo.dto.AccountNumberSeqDTO;
import com.fake.bank.demo.dto.AccountStandingDTO;
import com.fake.bank.demo.dto.AccountTransaction;
import com.fake.bank.demo.dto.AccountTypeDTO;
import com.fake.bank.demo.dto.OwnershipTypeDTO;
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
public class DebitOrderInfo {

	private int id;
	private Long accno;
	private BigDecimal amount;
	
}
