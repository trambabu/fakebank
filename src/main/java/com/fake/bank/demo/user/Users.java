package com.fake.bank.demo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fake.bank.demo.entity.CreditAccount;
import com.fake.bank.demo.entity.CreditAccountType;
import com.fake.bank.demo.entity.DebitAccount;
import com.fake.bank.demo.entity.DebitAccountType;
import com.fake.bank.demo.model.Notification;
import com.fake.bank.demo.model.UserProfile;
import com.fake.bank.demo.token.Token;
import com.fake.bank.demo.token.TokenType;
import com.fake.bank.demo.user.role.UserRole;
import com.fake.bank.demo.utils.Messages;
import com.fake.bank.demo.utils.Patterns;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
@Entity
@Table(name = "users")
public class Users implements UserDetails, Serializable {

	private static final Logger LOG = LoggerFactory.getLogger(Users.class);

	private static final long serialVersionUID = -1173435728882792083L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false, updatable = false)
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

//	@JsonProperty(access = Access.READ_ONLY)
//	private String firstname;
//	
//	@JsonProperty(access = Access.READ_ONLY)
//	private String lastname;
//	
//	@JsonProperty(access = Access.READ_ONLY)
//	private String email;
	
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
	
	
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "debit_acc_id")
	private DebitAccount debitAccount;
	
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "credit_acc_id")
	private CreditAccount creditAccount;

	private boolean enabled = true;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id")
	private UserProfile userProfile;

	@JsonIgnore
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserRole> userRoles = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	@OrderBy("timestamp DESC")
	private List<Notification> notifications = new ArrayList<>();
	
	@OneToMany(mappedBy = "users")
	  private List<Token> tokens;

	public List<Notification> getNotifications() {
		if (notifications == null) {
			LOG.debug("notifcations=null, returning new empty arraylist");
			return new ArrayList<Notification>();
		}
		LOG.debug("getting notifications which has size " + notifications.size());
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

//	public Users() {
//	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<GrantedAuthority> authorities = new HashSet<>();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));

		return authorities;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Users) {
          return username.equals( ((Users) obj).getUsername() );
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	public boolean isAccountNonExpired() {

		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return credentialsNonExpired;
	}

	@Override
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
