package com.fake.bank.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "ownershipType")
public class OwnershipType {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	private String code;
	private String name;
	
	// default constructor
	public OwnershipType () {}
	
	public OwnershipType (String code, String name) {
		
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
