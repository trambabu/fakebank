package com.fake.bank.demo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fake.bank.demo.entity.CreditAccount;
import com.fake.bank.demo.entity.DebitAccount;
import com.fake.bank.demo.model.UserProfile;
import com.fake.bank.demo.utils.Messages;
import com.fake.bank.demo.utils.Patterns;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

	private static final Logger LOG = LoggerFactory.getLogger(UserDTO.class);

	private static final long serialVersionUID = -1173435728882792083L;

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@JsonProperty(access = Access.READ_ONLY)
	private String firstname;
	
	@JsonProperty(access = Access.READ_ONLY)
	private String lastname;
	
	
	@NotEmpty (message=Messages.USER_EMAIL_REQUIRED)
	@Pattern(regexp=Patterns.USER_EMAIL, message=Messages.USER_EMAIL_FORMAT)
	@Column(nullable=false, unique=true)
	private String email;
	
	@JsonProperty(access = Access.READ_ONLY)
	private String username;

	@NotEmpty(message = Messages.USER_PASSWORD_REQUIRED)
	@JsonProperty(access = Access.WRITE_ONLY, required = true)
	@Pattern(regexp = Patterns.USER_PASSWORD, message = Messages.USER_PASSWORD_FORMAT)
	private String password;
	
	private DebitAccount debitAccount;
	
	private CreditAccount creditAccount;
	
	private boolean enabled = true;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;

	private UserProfile userProfile;



//	public Users() {
//	}

	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj instanceof UserDTO) {
          return username.equals( ((UserDTO) obj).getUsername() );
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

	public String getPassword() {

		return password;
	}

	public String getUsername() {

		return username;
	}

	public boolean isAccountNonExpired() {

		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {

		return accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {

		return credentialsNonExpired;
	}

	public boolean isEnabled() {

		return enabled;
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
	 * @param accountNonExpired the accountNotExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked the accountNotLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired the credentialNotExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the userProfile
	 */
	public UserProfile getUserProfile() {
		return userProfile;
	}

	/**
	 * @param userProfile the userProfile to set
	 */
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


	public String toString() {

		String user = "\n\nUser Profile ***********************";

		user += "\nId:\t\t\t" + this.getId();
		user += "\nUser Name:\t\t" + this.getUsername();
		user += "\nPassword:\t\t" + this.getPassword();
		user += "\nEnabled:\t\t" + this.isEnabled();
		user += "\nNon Locked:\t\t" + this.isAccountNonLocked();
		user += "\nNon Expired:\t\t" + this.isAccountNonExpired();
		user += "\nCredentials Non Expired:" + this.isCredentialsNonExpired();
		user += "\n" + this.getUserProfile();

		user += "\n*******************************************\n";

		return user;
	}

}
