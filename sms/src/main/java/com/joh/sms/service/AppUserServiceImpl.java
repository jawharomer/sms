package com.joh.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.AppUserDAO;
import com.joh.sms.exception.ItemExistsException;
import com.joh.sms.model.AppUser;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDAO appUserDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser save(AppUser appUser) {
		try {
			appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
			return appUserDAO.save(appUser);
		} catch (DataIntegrityViolationException e) {
			throw new ItemExistsException("ناوی  بەکاربەر دووبارەیە");
		}
	}

	@Override
	public AppUser findByRoleAndReference(String role, int reference) {
		return appUserDAO.findByRoleAndReference(role, reference);
	}

	@Override
	public AppUser findByUserName(String userName) {
		return appUserDAO.findByUserName(userName);
	}

}
