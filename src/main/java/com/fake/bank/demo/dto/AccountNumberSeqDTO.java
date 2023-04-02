package com.fake.bank.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountNumberSeqDTO {
	
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}
