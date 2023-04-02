package com.fake.bank.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnershipTypeDTO {

	private Long id;
	
	private String code;
	private String name;
	
	// default constructor
//	public OwnershipTypeDTO () {}
	
	public OwnershipTypeDTO (String code, String name) {
		
		this.code = code;
		this.name = name;
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
	
	public String toString() {
	    
		String ownerType = "\n\nOwner Type ***********************";
    
		ownerType += "\nId:\t\t\t" 			+ this.getId();
		ownerType += "\nName:\t\t" 			+ this.getName();
		ownerType += "\nCode:\t\t\t" 		+ this.getCode();

	    return ownerType;
	    
	}
	
}
