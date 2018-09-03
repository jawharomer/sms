package com.joh.sms.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/test")
public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("Admin2018"));
	}
}
