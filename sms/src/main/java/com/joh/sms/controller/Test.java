package com.joh.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joh.sms.dao.StudentLevelDAO;
import com.joh.sms.model.StudentLevel;

@Controller
@RequestMapping(path = "/justfortest")
public class Test {
	
	@GetMapping()
	private String te() {
		return "sdfdsf";
	}
}
