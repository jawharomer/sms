package com.joh.sms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joh.sms.model.StudentLevelDate;
import com.joh.sms.service.StudentLevelDateService;

@Controller()
@RequestMapping(path = "/studentLevelDates")
public class StudentLevelDateController {

	private static final Logger logger = Logger.getLogger(StudentLevelDateController.class);

	@Autowired
	private StudentLevelDateService studentLevelDateService;

	@GetMapping()
	public String getAllStudentLevelDate(Model model) {
		logger.info("getAllStudentLevelDate->fired");
		Iterable<StudentLevelDate> studentLevelDates = studentLevelDateService.findAll();
		logger.info("studentLevelDates=" + studentLevelDates);
		model.addAttribute("studentLevelDates", studentLevelDates);

		return "adminStudentLevelDates";
	}

	@GetMapping(path = "/add")
	public String getAddingStudentLevelDate(Model model) {
		logger.info("getAddingStudentLevelDate->fired");

		StudentLevelDate studentLevelDate = new StudentLevelDate();
		model.addAttribute("studentLevelDate", studentLevelDate);

		return "/admin/addStudentLevelDate";

	}

	@PostMapping(path = "/add")
	public String addStudentLevelDate(@RequestBody @Validated StudentLevelDate studentLevelDate, BindingResult result,
			Model model) {
		logger.info("addStudentLevelDate->fired");
		logger.info("addStudentLevelDate=" + studentLevelDate);

		logger.info("errors=" + result.getAllErrors());

		if (result.hasErrors()) {
			model.addAttribute("studentLevelDate", studentLevelDate);

			return "/admin/addStudentLevelDate";
		} else {
			studentLevelDateService.save(studentLevelDate);
			return "success";
		}

	}

	@PostMapping(path = "/delete/{id}")
	public String deleteStudentLevelDate(@PathVariable int id) {
		logger.info("deleteStudentLevelDate->fired");
		logger.info("id=" + id);
		studentLevelDateService.delete(id);
		return "success";
	}

}
