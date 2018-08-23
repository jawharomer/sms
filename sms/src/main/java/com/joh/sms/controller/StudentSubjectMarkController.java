package com.joh.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joh.sms.domain.model.StudentSubjectMarkD;
import com.joh.sms.model.ClassMark;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.Enrollment;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentSubjectMark;
import com.joh.sms.service.ClassMarkService;
import com.joh.sms.service.EnrollmentService;
import com.joh.sms.service.StudentSubjectMarkService;

@Controller()
@RequestMapping(path = "/studentSubjectMarks")
public class StudentSubjectMarkController {

	@Autowired
	private MessageSource messageSource;

	private static final Logger logger = Logger.getLogger(StudentSubjectMarkController.class);

	@Autowired
	private StudentSubjectMarkService studentSubjectMarkService;

	@Autowired
	private ClassMarkService classMarkService;

	@Autowired
	private EnrollmentService enrollmentService;

	@GetMapping(path = "/student/{id}")
	public String getStudentAllSubjectMark(@PathVariable int id, Model model) {
		logger.info("getStudentAllSubjectMark->fired");
		logger.info("studentId=" + id);

		List<StudentSubjectMarkD> studentSubjectMarkDs = studentSubjectMarkService.findAllStudentStudentSubjectMark(id);

		logger.info("studentSubjectMarkDs=" + studentSubjectMarkDs);
		Enrollment enrollment = enrollmentService.findEnrollmentByStudentId(id);
		Iterable<ClassMark> classMarks = classMarkService
				.findByClassLevelId(enrollment.getClassGroup().getClassLevel().getId());

		logger.info("classMarks=" + classMarks);

		model.addAttribute("studentSubjectMarkDs", studentSubjectMarkDs);
		model.addAttribute("classMarks", classMarks);

		return "adminStudentStudentSubjectMarks";
	}

	@GetMapping(path = "/add")
	public String getAddStudentSubjectMark(@RequestParam Integer studentId, @RequestParam Integer classSubjectId,
			@RequestParam Integer classMarkId, Model model) {
		logger.info("getAddStudentSubjectMark->fired");

		logger.info("studentId=" + studentId);
		logger.info("classSubjectId=" + classSubjectId);
		logger.info("classMarkId=" + classMarkId);

		StudentSubjectMarkD studentSubjectMarkD = new StudentSubjectMarkD();

		studentSubjectMarkD.setStudentId(studentId);
		studentSubjectMarkD.setClassSubjectId(classSubjectId);
		studentSubjectMarkD.setClassMarkId(classMarkId);

		model.addAttribute("studentSubjectMarkD", studentSubjectMarkD);

		return "studentSubjectMark/addStudentSubjectMark";
	}

	@PostMapping(path = "/add")
	public String addStudentSubjectMark(@RequestBody @Valid StudentSubjectMarkD studentSubjectMarkD,
			BindingResult result, Model model) {
		logger.info("getAddStudentSubjectMark->fired");

		logger.info("studentSubjectMarkD=" + studentSubjectMarkD);

		double markLimit = classMarkService.findOne(studentSubjectMarkD.getClassMarkId()).getLimit();

		if (studentSubjectMarkD.getMark() != null && studentSubjectMarkD.getMark() > markLimit) {
			result.rejectValue("mark", "studentSubjectMarkD.mark",
					messageSource.getMessage("studentSubjectMark.mark.max", null, null));
		}

		logger.info("error=" + result.getAllErrors());

		if (result.hasErrors()) {
			model.addAttribute("studentSubjectMarkD", studentSubjectMarkD);
			return "studentSubjectMark/addStudentSubjectMark";
		} else {

			StudentSubjectMark studentSubjectMark = new StudentSubjectMark();

			Student student = new Student();
			student.setId(studentSubjectMarkD.getStudentId());

			ClassMark classMark = new ClassMark();
			classMark.setId(studentSubjectMarkD.getClassMarkId());

			ClassSubject classSubject = new ClassSubject();
			classSubject.setId(studentSubjectMarkD.getClassSubjectId());

			studentSubjectMark.setStudent(student);
			studentSubjectMark.setClassMark(classMark);
			studentSubjectMark.setClassSubject(classSubject);

			studentSubjectMark.setMark(studentSubjectMarkD.getMark());

			studentSubjectMarkService.save(studentSubjectMark);

			return "success";
		}
	}

	@GetMapping(path = "/edit/{id}")
	public String getEditingStudentSubjectMark(@PathVariable int id, Model model) {
		logger.info("getEditingStudentSubjectMark->fired");
		logger.info("studentSubjectMarkId=" + id);
		StudentSubjectMark studentSubjectMark = studentSubjectMarkService.fineOne(id);

		StudentSubjectMarkD studentSubjectMarkD = new StudentSubjectMarkD();

		studentSubjectMarkD.setStudentId(studentSubjectMark.getStudent().getId());
		studentSubjectMarkD.setClassMarkId(studentSubjectMark.getClassSubject().getId());
		studentSubjectMarkD.setClassSubjectId(studentSubjectMark.getClassSubject().getId());
		studentSubjectMarkD.setMark(studentSubjectMark.getMark());

		model.addAttribute("studentSubjectMarkId", id);
		model.addAttribute("studentSubjectMarkD", studentSubjectMarkD);
		return "studentSubjectMark/editStudentSubjectMark";
	}

	@PostMapping(path = "/edit/{id}")
	public String updateStudentSubjectMark(@PathVariable int id,
			@RequestBody @Valid StudentSubjectMarkD studentSubjectMarkD, BindingResult result, Model model) {
		logger.info("updateStudentSubjectMark->fired");
		logger.info("studentSubjectMarkId=" + id);

		logger.info("studentSubjectMarkD=" + studentSubjectMarkD);

		double markLimit = classMarkService.findOne(studentSubjectMarkD.getClassMarkId()).getLimit();

		if (studentSubjectMarkD.getMark() != null && studentSubjectMarkD.getMark() > markLimit) {
			result.rejectValue("mark", "studentSubjectMarkD.mark",
					messageSource.getMessage("studentSubjectMark.mark.max", null, null));
		}

		logger.info("error=" + result.getAllErrors());

		if (result.hasErrors()) {
			model.addAttribute("studentSubjectMarkId", id);
			model.addAttribute("studentSubjectMarkD", studentSubjectMarkD);
			return "studentSubjectMark/editStudentSubjectMark";
		} else {
			StudentSubjectMark studentSubjectMark = new StudentSubjectMark();

			Student student = new Student();
			student.setId(studentSubjectMarkD.getStudentId());

			ClassMark classMark = new ClassMark();
			classMark.setId(studentSubjectMarkD.getClassMarkId());

			ClassSubject classSubject = new ClassSubject();
			classSubject.setId(studentSubjectMarkD.getClassSubjectId());

			studentSubjectMark.setId(id);
			studentSubjectMark.setStudent(student);
			studentSubjectMark.setClassMark(classMark);
			studentSubjectMark.setClassSubject(classSubject);

			studentSubjectMark.setMark(studentSubjectMarkD.getMark());

			studentSubjectMarkService.update(studentSubjectMark);

			return "success";
		}
	}

}
