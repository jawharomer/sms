package com.joh.sms.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joh.sms.domain.model.EnrollmentD;
import com.joh.sms.model.ClassGroup;
import com.joh.sms.model.Enrollment;
import com.joh.sms.model.Student;
import com.joh.sms.service.ClassGroupService;
import com.joh.sms.service.EnrollmentService;
import com.joh.sms.service.StudentService;

@Controller()
@RequestMapping(path = "/enrollments")
public class EnrollmentController {

	private static final Logger logger = Logger.getLogger(EnrollmentController.class);

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ClassGroupService classGroupService;

	@GetMapping()
	public String getAllEnrollment(Model model) {
		logger.info("getAllEnrollment->fired");
		Iterable<EnrollmentD> enrollments = enrollmentService.findAllEnrollment();
		logger.info("enrollments=" + enrollments);

		model.addAttribute("enrollments", enrollments);
		return "adminEnrollments";
	}

	@GetMapping(path = "/add")
	public String getAddingEnrollment(Model model) {
		logger.info("getAddingEnrollment->fired");
		Iterable<Student> students = studentService.findAllStudent();
		Iterable<ClassGroup> classGroups = classGroupService.findAll();
		EnrollmentD enrollmentD = new EnrollmentD();
		model.addAttribute("enrollmentD", enrollmentD);
		model.addAttribute("students", students);
		model.addAttribute("classGroups", classGroups);
		return "enrollment/addEnrollment";
	}

	@PostMapping(path = "/add")
	public String addEnrollment(@RequestBody @Valid EnrollmentD enrollmentD, BindingResult result, Model model) {
		logger.info("addEnrollment->fired");

		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			Iterable<Student> students = studentService.findAllStudent();
			Iterable<ClassGroup> classGroups = classGroupService.findAll();
			model.addAttribute("enrollmentD", enrollmentD);
			model.addAttribute("students", students);
			model.addAttribute("classGroups", classGroups);
			return "enrollment/addEnrollment";
		} else {
			Enrollment enrollment = new Enrollment();
			Student student = new Student();
			student.setId(enrollmentD.getStudentId());

			ClassGroup classGroup = new ClassGroup();
			classGroup.setId(enrollmentD.getClassGroupId());

			enrollment.setStudent(student);
			enrollment.setClassGroup(classGroup);
			enrollment.setFee(enrollmentD.getFee());
			enrollment.setNote(enrollmentD.getNote());

			enrollmentService.save(enrollment);

			return "success";
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public String deleteEnrollment(@PathVariable int id) {
		logger.info("deleteEnrollment->fired");
		logger.info("id=" + id);
		enrollmentService.delete(id);
		return "success";
	}

	@GetMapping(path = "/edit/{id}")
	public String getEditintEnrollment(@PathVariable int id, Model model) {
		logger.info("getEditintEnrollment->fired");

		Enrollment enrollment = enrollmentService.findOne(id);

		EnrollmentD enrollmentD = new EnrollmentD();

		enrollmentD.setEnrollmentId(id);
		enrollmentD.setStudentId(enrollment.getStudent().getId());
		enrollmentD.setClassGroupId(enrollment.getClassGroup().getId());
		enrollmentD.setFee(enrollment.getFee());
		enrollmentD.setNote(enrollment.getNote());

		logger.info("enrollmentD=" + enrollmentD);

		model.addAttribute("enrollmentD", enrollmentD);

		Iterable<Student> students = studentService.findAllStudent();
		Iterable<ClassGroup> classGroups = classGroupService.findAll();

		model.addAttribute("students", students);
		model.addAttribute("classGroups", classGroups);

		return "enrollment/editEnrollment";
	}

	@PostMapping(path = "/edit/{id}")
	public String updateEnrollment(@RequestBody @Valid EnrollmentD enrollmentD, BindingResult result, Model model) {
		logger.info("updateEnrollment->fired");
		logger.info("enrollmentD=" + enrollmentD);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {

			model.addAttribute("enrollmentD", enrollmentD);

			Iterable<Student> students = studentService.findAllStudent();
			Iterable<ClassGroup> classGroups = classGroupService.findAll();

			model.addAttribute("students", students);
			model.addAttribute("classGroups", classGroups);

			return "enrollment/editEnrollment";
		} else {

			Enrollment enrollment = new Enrollment();

			Student student = new Student();
			student.setId(enrollmentD.getStudentId());

			ClassGroup classGroup = new ClassGroup();
			classGroup.setId(enrollmentD.getClassGroupId());

			enrollment.setId(enrollmentD.getEnrollmentId());
			enrollment.setStudent(student);
			enrollment.setClassGroup(classGroup);
			enrollment.setFee(enrollmentD.getFee());
			enrollment.setNote(enrollmentD.getNote());

			enrollmentService.update(enrollment);
			return "success";
		}

	}

}
