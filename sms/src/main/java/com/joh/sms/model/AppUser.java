package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "APP_USERS")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_APP_USER")
	private Integer id;

	@NotBlank(message = "{appUser.userName.blank}")
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String userName;

	@NotBlank(message = "{appUser.password.blank}")
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@NotBlank(message = "{appUser.role.blank}")
	@Column(name = "ROLE", nullable = false)
	private String role;

	@Column(name = "REFERENCE")
	private Integer reference;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", reference=" + reference + "]";
	}

}
