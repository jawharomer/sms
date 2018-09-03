package com.joh.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joh.sms.domain.model.AppUserDetail;
import com.joh.sms.model.AppUser;

@Service
public class AppUserDetailService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(AppUserDetailService.class);

	@Autowired
	private AppUserService appUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser appUser = appUserService.findByUserName(username);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(appUser.getRole()));

		AppUserDetail appUserDetail = new AppUserDetail();

		appUserDetail.setAuthorities(authorities);
		appUserDetail.setUsername(appUser.getUserName());
		appUserDetail.setPassword(appUser.getPassword());
		appUserDetail.setPrimaryRole(appUser.getRole());
		if (appUser.getReference() != null)
			appUserDetail.setReference(appUser.getReference());

		logger.info("appUserDetail=" + appUserDetail);
		return appUserDetail;

	}

}