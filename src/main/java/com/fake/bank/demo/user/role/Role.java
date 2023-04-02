package com.fake.bank.demo.user.role;

import java.util.HashSet;
import java.util.Set;

import com.fake.bank.demo.token.Token;
import com.fake.bank.demo.token.TokenType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
	
	// Defined Roles
	public static final String ROLE_USER 	= "ROLE_USER";
	public static final String ROLE_ADMIN 	= "ROLE_ADMIN";
	public static final String ROLE_API 	= "ROLE_API";
  
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	private String name;
  
	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
	private Set<UserRole> userRoles = new HashSet<>();

	// default constructor
	public Role () {}
	
	public Role (String name) {
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
	 * @return the userRoles
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
  
	
}
