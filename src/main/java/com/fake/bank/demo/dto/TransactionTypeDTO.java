package com.fake.bank.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTypeDTO {
	
	private Long id;
	
	private String code;
	private String name;
	private String category;
	
	public static final String CAT_DEBIT 	= "DEBIT";
	public static final String CAT_CREDIT 	= "CREDIT";
	public static final String CAT_EITHER 	= "EITHER";
	
	// default constructor
//	public TransactionTypeDTO () {}
	
	public TransactionTypeDTO (String code, String name, String category) {
		
		this.code = code;
		this.name = name;
		this.category = category;
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

}
