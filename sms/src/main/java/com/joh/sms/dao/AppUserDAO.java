package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.AppUser;

public interface AppUserDAO extends CrudRepository<AppUser, Integer> {
	AppUser findByRoleAndReference(String role, int reference);
	AppUser findByUserName(String userName);
}
