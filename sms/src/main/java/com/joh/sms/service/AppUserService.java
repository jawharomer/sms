package com.joh.sms.service;

import com.joh.sms.model.AppUser;

public interface AppUserService {

	AppUser save(AppUser appUser);

	AppUser findByRoleAndReference(String role, int reference);

	AppUser findByUserName(String userName);

}
