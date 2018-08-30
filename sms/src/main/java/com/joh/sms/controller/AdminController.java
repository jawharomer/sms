package com.joh.sms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joh.sms.domain.model.StudentNotificaionD;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentNotification;
import com.joh.sms.model.Teacher;
import com.joh.sms.service.StudentNotificationSerivce;
import com.joh.sms.service.StudentService;
import com.joh.sms.service.TeacherService;

@Controller()
@RequestMapping(path = "/admin")
public class AdminController {

	private static final Logger logger = Logger.getLogger(AdminController.class);

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentNotificationSerivce studentNotificationSerivce;

	@GetMapping()
	public String getAmdinPage() {
		return "adminRoot";
	}

	@GetMapping(path = "/students")
	public String getStudents(Model model) {
		Iterable<Student> students = studentService.findAllStudent();
		logger.info("students=" + students);
		model.addAttribute("students", students);

		return "adminStudents";
	}

	@PostMapping(path = "/students/{id}")
	@ResponseBody
	public String deleteStudent(@PathVariable int id) {
		logger.info("deleteStudent->fired");
		logger.info("id=" + id);
		studentService.delete(id);
		return "success";
	}

	@GetMapping(path = "/students/add")
	public String getAddingStudent(Model model) {
		logger.info("getAddingStudent->fired");
		model.addAttribute("student", new Student());
		return "admin/addStudent";
	}

	@PostMapping(path = "/students/add")
	public String addStudent(@RequestBody @Valid Student student, BindingResult result) {
		logger.info("addStudent->fired");
		logger.info("student=" + student);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			return "admin/addStudent";
		} else {
			studentService.save(student);
			return "success";
		}

	}

	@GetMapping(path = "/students/edit/{id}")
	public String getEditingStudent(@PathVariable int id, Model model) {
		logger.info("getEditingStudent->fired");
		model.addAttribute("student", studentService.findOne(id));
		return "admin/editStudent";
	}

	@PostMapping(path = "/students/update")
	public String updateStudent(@RequestBody @Valid Student student, BindingResult result, Model model) {
		logger.info("updateStudent->fired");
		logger.info("student=" + student);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("student", student);
			return "admin/editStudent";
		} else {
			studentService.update(student);
			return "success";
		}

	}

	// Student Notificaions

	@GetMapping(path = "/students/notificaions")
	public String getAllStudentNotificaions(Model model) {

		Iterable<StudentNotification> studentNotifications = studentNotificationSerivce.findAll();
		model.addAttribute("studentNotifications", studentNotifications);
		return "adminStudentNotifications";
	}

	@GetMapping(path = "/students/notificaions/add")
	public String getAddingStudentNotificaions(@RequestParam("studentIds[]") Integer[] studentIds, Model model)
			throws JsonProcessingException {
		logger.info("getAddingStudentNotificaions->fired");
		logger.info("studnetIds=" + studentIds);
		StudentNotificaionD studentNotificaionD = new StudentNotificaionD();

		ObjectMapper objectMapper = new ObjectMapper();
		model.addAttribute("studentIds", objectMapper.writeValueAsString(studentIds));
		model.addAttribute("studentNotificaionD", studentNotificaionD);
		return "notification/addStudentNotification";
	}

	@PostMapping(path = "/students/notificaions/add")
	public String addStudentNotificaions(@RequestBody @Valid StudentNotificaionD studentNotificaionD,
			BindingResult result, Model model) throws JsonProcessingException {
		logger.info("addStudentNotificaions->fired");
		logger.info("studentNotificaionD=" + studentNotificaionD);
		logger.info("errors=" + result.getAllErrors());
		if (result.hasErrors()) {

			ObjectMapper objectMapper = new ObjectMapper();
			model.addAttribute("studentIds", objectMapper.writeValueAsString(studentNotificaionD.getStudentIds()));
			model.addAttribute("studentNotificaionD", studentNotificaionD);
			return "notification/addStudentNotification";
		} else {

			List<Student> students = new ArrayList<>();
			for (Integer studentId : studentNotificaionD.getStudentIds()) {
				Student student = new Student();
				student.setId(studentId);
				students.add(student);
			}

			StudentNotification studentNotification = new StudentNotification();
			studentNotification.setStudents(students);
			studentNotification.setTitle(studentNotificaionD.getTitle());
			studentNotification.setNote(studentNotificaionD.getNote());
			studentNotificationSerivce.save(studentNotification);
			return "success";
		}
	}

	@PostMapping(path = "/students/notificaions/delete/{id}")
	public String deleteStudentNotification(@PathVariable int id) {
		logger.info("getAddingStudentNotificaions->fired");
		logger.info("id=" + id);
		studentNotificationSerivce.delete(id);
		return "success";
	}

	@GetMapping(path = "/notificaions/{id}/students")
	public String getStudentNotificaionStudents(@PathVariable int id, Model model) {
		logger.info("getStudentNotificaionStudents->fired");
		logger.info("id=" + id);
		List<Student> students = studentService.findAllByNotificationId(id);
		model.addAttribute("students", students);
		return "notification/notificaionStudents";
	}

	// Teachers

	@GetMapping(path = "/teachers")
	public String getTeachers(Model model) {

		Iterable<Teacher> teachers = teacherService.findAll();
		logger.info("teachers=" + teachers);
		model.addAttribute("teachers", teachers);
		return "adminTeachers";
	}

	@GetMapping(path = "/teachers/add")
	public String getAddingTeacher(Model model) {
		logger.info("getAddingTeacher->fired");
		model.addAttribute("teacher", new Teacher());
		return "admin/addTeacher";
	}

	@PostMapping(path = "/teachers/add")
	public String addTeacher(@RequestBody @Valid Teacher teacher, BindingResult result) {
		logger.info("addTeacher->fired");
		logger.info("student=" + teacher);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			return "admin/addTeacher";
		} else {
			teacherService.save(teacher);
			return "success";
		}

	}

	@PostMapping(path = "/teachers/{id}")
	@ResponseBody
	public String deleteTeacher(@PathVariable int id) {
		logger.info("fired");
		logger.info("id=" + id);
		teacherService.delete(id);
		return "success";
	}

	@GetMapping(path = "/teachers/edit/{id}")
	public String getEditingTeacher(@PathVariable int id, Model model) {
		logger.info("getEditingTeacher->fired");
		model.addAttribute("teacher", teacherService.findOne(id));
		return "admin/editTeacher";
	}

	@PostMapping(path = "/teachers/update")
	public String updateTeacher(@RequestBody @Valid Teacher teacher, BindingResult result, Model model) {
		logger.info("updateTeacher->fired");
		logger.info("teacher=" + teacher);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("teacher", teacher);
			return "admin/editTeacher";
		} else {
			teacherService.update(teacher);
			return "success";
		}

	}

}
