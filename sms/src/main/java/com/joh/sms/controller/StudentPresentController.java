package com.joh.sms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joh.sms.domain.model.StudentPresentD;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentPresent;
import com.joh.sms.service.ClassSubjectService;
import com.joh.sms.service.StudentPresentService;

@Controller()
@RequestMapping(path = "/studentPresents")
public class StudentPresentController {

	private static final Logger logger = Logger.getLogger(StudentPresentController.class);

	@Autowired
	private StudentPresentService studentPresentService;

	@Autowired
	private ClassSubjectService classSubjectServices;

	@GetMapping(path = "/classGroup/{id}")
	public String getAllStudentPresentByClassGroup(@PathVariable int id, Model model) {
		logger.info("getAllStudentPresentByClassGroup->fired");
		logger.info("classGroupId=" + id);

		List<StudentPresentD> studentPresentDs = studentPresentService.findAllStudentPresentByClassGroupId(id);

		model.addAttribute("studentPresentDs", studentPresentDs);
		model.addAttribute("classGroupId", id);

		return "adminStudentPresents";
	}

	@GetMapping(path = "/add/classGroup/{id}")

	public String getAddClassGroupStudentPresents(@PathVariable int id, Model model) {
		logger.info("getAddClassGroupStudentPresents->fired");

		logger.info("classGroupId=" + id);

		List<StudentPresentD> studentPresentDs = studentPresentService.findAllStudentPresentByClassGroupId(id);

		model.addAttribute("studentPresentDs", studentPresentDs);

		return "addClassGroupStudentPresent";
	}

	@PostMapping(path = "/add/classGroup/{date}")
	public String addClassGroupStudentPresents(@PathVariable() @DateTimeFormat(iso = ISO.DATE) Date date,
			@RequestBody List<StudentPresentD> studentPresentDs) {
		logger.info("addClassGroupStudentPresents->fired");
		logger.info("studentPresentDs=" + studentPresentDs);
		logger.info("Date=" + date);
		List<StudentPresent> studentPresents = new ArrayList<>();
		for (StudentPresentD studentPresentD : studentPresentDs) {
			StudentPresent studentPresent = new StudentPresent();
			Student student = new Student();
			student.setId(studentPresentD.getStudentId());

			studentPresent.setStudent(student);
			studentPresent.setDate(date);
			studentPresent.setAttend(studentPresentD.isAttent());

			studentPresents.add(studentPresent);
		}

		studentPresentService.save(studentPresents);

		return "success";
	}

	@GetMapping(path = "/student/{id}")
	public String getAllStudentPresent(@PathVariable int id, Model model) {
		logger.info("getAllStudentPresent->fired");
		logger.info("studentId=" + id);

		List<StudentPresent> studentPresents = studentPresentService.findAllStudentPresentByStudentIdOrderByIdDesc(id);
		logger.info("studentPresents=" + studentPresents);

		model.addAttribute("studentPresents", studentPresents);

		return "studentPresent/studentStudentPresents";
	}
}
