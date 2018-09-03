package com.joh.sms.domain.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class AppUserDetail implements UserDetails {

	private Collection<? extends GrantedAuthority> authorities;
	private String password;
	private String username;
	private String primaryRole;
	private Integer reference;

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getPrimaryRole() {
		return primaryRole;
	}

	public void setPrimaryRole(String primaryRole) {
		this.primaryRole = primaryRole;
	}

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "AppUserDetail [authorities=" + authorities + ", password=" + password + ", username=" + username
				+ ", primaryRole=" + primaryRole + ", reference=" + reference + "]";
	}

}
