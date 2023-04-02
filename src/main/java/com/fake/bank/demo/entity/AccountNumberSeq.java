package com.fake.bank.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
//import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "accountNumberSeq")
@SequenceGenerator(name="ACCT_NO_SEQ", initialValue=486130001, allocationSize=50)
public class AccountNumberSeq {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCT_NO_SEQ")
	@Column(nullable=false, updatable=false, unique=true)
	@JsonProperty (access = Access.READ_ONLY)
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}
