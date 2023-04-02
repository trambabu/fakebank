package com.fake.bank.demo.user.role;

import com.fake.bank.demo.token.Token;
import com.fake.bank.demo.token.TokenType;
import com.fake.bank.demo.user.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userRole")
public class UserRole {
  
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
  
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private Users users;
  
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="roleId")
	private Role role;
	
//	// default constructor
//	public UserRole() {}
  
	public UserRole(Users user, Role role) {
		this.users = user;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the users
	 */
	public Users getUser() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUser(Users user) {
		this.users = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
  
	public String toString() {
	    
		String userRole = "\n\nUser Roles ***********************";
    
		userRole += "\nId:\t\t\t" 			+ this.getId();
		userRole += "\nUser:\t\t" 			+ this.getUser().getUsername();
		userRole += "\nRole:\t\t\t" 		+ this.getRole().getName();
	    return userRole;
	    
	}
}
