package com.joh.sms.controller;

import java.util.Date;

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

import com.joh.sms.model.Student;
import com.joh.sms.model.Teacher;
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
