package com.joh.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joh.sms.dao.ClassGroupTableDAO;
import com.joh.sms.dao.EnrollmentDAO;
import com.joh.sms.dao.StudentDAO;
import com.joh.sms.dao.StudentPresentDAO;

@Controller
@RequestMapping(path = "/test")
public class Test {

	@Autowired
	private StudentPresentDAO studentPresentDAO;

	// @Autowired
	// private ClassGroupTableDAO classGroupTableDAO;

	@GetMapping
	@ResponseBody
	public String test() {
		System.out.println("this  is me test");
		System.out.println(studentPresentDAO.findAllStudentPresentByClassGroupId(1));
		return "test";
	}

}
