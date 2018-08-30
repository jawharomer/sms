package com.joh.sms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joh.sms.dao.ClassGroupTableDAO;
import com.joh.sms.dao.EnrollmentDAO;
import com.joh.sms.dao.StudentDAO;
import com.joh.sms.dao.StudentPresentDAO;
import com.joh.sms.dao.TestADAO;
import com.joh.sms.dao.TestBDAO;
import com.joh.sms.model.TestA;
import com.joh.sms.model.TestB;

@Controller
@RequestMapping(path = "/test")
public class Test {

	@Autowired
	private TestADAO testADAO;
	@Autowired
	private TestBDAO testBDAO;

	@GetMapping
	@ResponseBody
	public String test() {
		TestA testA = new TestA();

		testA.setA("a1");
		testADAO.save(testA);

		TestB testB = new TestB();
		testB.setB("b1");
		
		testB.setTestAs(new ArrayList<>());
		testB.getTestAs().add(testA);

		testBDAO.save(testB);
		
		testB.setBi(6);

		return "success";
	}

	@GetMapping(path = "/sec")
	@ResponseBody
	public String tesdt() {
		
		testBDAO.delete(1);
		
		return "success";
	}

}
