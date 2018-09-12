package com.joh.sms.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentLevel;
import com.joh.sms.service.ClassGroupService;
import com.joh.sms.service.StudentLevelService;

@Controller
@RequestMapping(path = "/studentLevels")
public class StudentLevelController {

	private static final Logger logger = Logger.getLogger(StudentLevelController.class);

	@Autowired
	private StudentLevelService studentLevelService;

	@GetMapping(path = "/add")
	public String getAddingStudentLevel(@RequestParam(required = false) Integer studentLevelId,
			@RequestParam Integer classSubjectId, @RequestParam Integer studentId, Model model) {

		logger.info("getAddingStudentLevel->fired");
		logger.info("studentLevelId=" + studentLevelId);
		logger.info("classSubjectId=" + classSubjectId);
		logger.info("studentId=" + studentId);
		StudentLevel studentLevel = null;
		if (studentLevelId != null) {
			studentLevel = studentLevelService.findOne(studentLevelId);
		} else {
			studentLevel = new StudentLevel();

			Student student = new Student();
			student.setId(studentId);

			ClassSubject classSubject = new ClassSubject();
			classSubject.setId(classSubjectId);

			studentLevel.setStudent(student);
			studentLevel.setClassSubject(classSubject);
		}

		model.addAttribute("studentLevel", studentLevel);

		return "studentLevel/addStudentLevel";
	}

	@PostMapping(path = "/add")
	public String addStudentLevel(@RequestBody @Valid StudentLevel studentLevel, BindingResult result, Model model) {
		logger.info("addStudentLevel->fired");

		logger.info("studentLevel=" + studentLevel);
		logger.info("errors=" + result.getAllErrors());

		if (result.hasErrors()) {

			model.addAttribute("studentLevel", studentLevel);
			return "studentLevel/addStudentLevel";
		} else {
			studentLevelService.save(studentLevel);
			return "success";
		}

	}

	

}
