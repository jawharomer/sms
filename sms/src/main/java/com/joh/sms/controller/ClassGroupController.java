package com.joh.sms.controller;

import java.util.List;

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

import com.joh.sms.model.ClassGroup;
import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.Student;
import com.joh.sms.service.ClassGroupService;
import com.joh.sms.service.ClassLevelService;
import com.joh.sms.service.StudentService;

@Controller
@RequestMapping(path = "/classGroups")
public class ClassGroupController {

	private static final Logger logger = Logger.getLogger(ClassGroupController.class);

	@Autowired
	private ClassGroupService classGroupService;
	@Autowired
	private ClassLevelService classLevelService;

	@Autowired
	private StudentService studentService;

	@GetMapping()
	public String getAdminClassGroups(Model model) {
		logger.info("getAdminClassGroups->fired");

		Iterable<ClassGroup> classGroups = classGroupService.findAll();

		logger.info("classGroups=" + classGroups);
		model.addAttribute("classGroups", classGroups);
		return "adminClassGroups";
	}

	@GetMapping(path = "/edit/{id}")
	public String getEditingClassGroup(@PathVariable int id, Model model) {
		logger.info("getEditingClassGroup->fired");
		model.addAttribute("classGroup", classGroupService.findOne(id));
		return "classGroup/editClassGroup";
	}

	@PostMapping(path = "/edit")
	public String updateClassGroup(@RequestBody @Valid ClassGroup classGroup, BindingResult result, Model model) {
		logger.info("updateClassGroup->fired");
		logger.info("classGroup=" + classGroup);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classGroup", classGroup);
			return "classGroup/editClassGroup";
		} else {
			classGroupService.update(classGroup);
			return "success";
		}

	}

	@GetMapping(path = "/classLevel/{id}")
	public String getClassLevelGroups(@PathVariable int id, Model model) {
		logger.info("getClassLevelGroups->fired");
		logger.info("id=" + id);

		ClassLevel classLevel = classLevelService.findOne(id);
		Iterable<ClassGroup> classGroups = classGroupService.findByClassLevelId(id);

		logger.info("classLevel=" + classLevel);
		logger.info("classGroups=" + classGroups);

		model.addAttribute("classLevel", classLevel);
		model.addAttribute("classGroups", classGroups);
		return "classLevelGroups";
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public String deleteClassGroup(@PathVariable int id) {
		logger.info("deleteClassGroup->fired");
		logger.info("id=" + id);
		classGroupService.delete(id);
		return "success";
	}

	@GetMapping(path = "/add/classLevel/{id}")
	public String getAddingClassGroup(@PathVariable int id, Model model) {
		logger.info("getAddingClassGroup->fired");
		model.addAttribute("classLevelId", id);
		model.addAttribute("classGroup", new ClassGroup());
		return "classGroup/addClassGroup";
	}

	@PostMapping(path = "/add/classLevel/{id}")
	public String addGroupToClassLevel(@PathVariable int id, @RequestBody @Valid ClassGroup classGroup,
			BindingResult result, Model model) {
		logger.info("addGroupToClassLevel->fired");
		logger.info("classGroup=" + classGroup);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classLevelId", id);
			model.addAttribute("classGroup", classGroup);
			return "classGroup/addClassGroup";
		} else {
			ClassLevel classLevel = new ClassLevel();
			classLevel.setId(id);
			classGroup.setClassLevel(classLevel);
			classGroupService.save(classGroup);

			return "success";
		}
	}

	@GetMapping(path = "/{id}/students")
	public String getClassGroupStudents(@PathVariable int id, Model model) {
		logger.info("getClassGroupStudents->fired");
		logger.info("classGroupId=" + id);

		ClassGroup classGroup = classGroupService.findOne(id);
		model.addAttribute("classGroup", classGroup);

		List<Student> students = studentService.findAllByClassGroupId(id);
		logger.info("students=" + students);
		model.addAttribute("students", students);

		return "classGroupStudents";
	}

}
