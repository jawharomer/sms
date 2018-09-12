package com.joh.sms.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.joh.sms.dao.StudentLevelDAO;
import com.joh.sms.domain.model.AppUserDetail;
import com.joh.sms.service.AuthenticationFacadeService;

@Controller
public class AppController {

	@Autowired
	private AuthenticationFacadeService authenticationFacadeService;

	private static final Logger logger = Logger.getLogger(AppController.class);

	@GetMapping("/login")
	public String login() {
		logger.info("login->fired");

		return "login";
	}

	@GetMapping("/app")
	public String app(Principal principal) {
		logger.info("app->fired");
		AppUserDetail appUserDetail = authenticationFacadeService.getAppUserDetail();
		logger.info("appUserDetail=" + appUserDetail);
		if (appUserDetail.getPrimaryRole().equals("ROLE_ADMIN")) {
			return "redirect:/admin";
		} else if (appUserDetail.getPrimaryRole().equals("ROLE_STUDENT")
				|| appUserDetail.getPrimaryRole().equals("ROLE_PARENT")) {
			return "redirect:/students";
		} else if (appUserDetail.getPrimaryRole().equals("ROLE_TEACHER")) {
			return "redirect:/teachers";
		} else {
			logger.info("user primary role not found ");
			return "redirect:/students";
		}

	}
}
