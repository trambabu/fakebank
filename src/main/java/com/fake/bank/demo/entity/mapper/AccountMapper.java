package com.fake.bank.demo.entity.mapper;


import org.springframework.beans.BeanUtils;

import com.fake.bank.demo.dto.AccountDTO;
import com.fake.bank.demo.entity.DebitAccount;

/**
 * 
 * @author USER
 *	Copying Data from DTO to Entity class and vice versa
 */
public class AccountMapper extends BaseMapper<DebitAccount, AccountDTO> {


	@Override
	public DebitAccount convertToEntity(AccountDTO dto, Object... args) {
		// TODO Auto-generated method stub
		DebitAccount debitAccount = new DebitAccount();
		 if (dto != null) {
	            BeanUtils.copyProperties(dto, debitAccount);
	        }
	        return debitAccount;
	}

	@Override
	public AccountDTO convertToDto(DebitAccount entity, Object... args) {
		// TODO Auto-generated method stub
		AccountDTO accountDTO = new AccountDTO();
		if (entity != null) {
            BeanUtils.copyProperties(entity, accountDTO);
        }
        return accountDTO;
	}
}
