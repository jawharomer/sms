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
import org.springframework.web.bind.annotation.ResponseBody;

import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.service.ClassLevelService;
import com.joh.sms.service.ClassSubjectService;

@Controller
@RequestMapping(path = "/classSubjects")
public class ClassSubjectController {

	private static final Logger logger = Logger.getLogger(ClassSubjectController.class);

	@Autowired
	private ClassSubjectService classSubjectServices;
	@Autowired
	private ClassLevelService classLevelService;

	@GetMapping(path = "/edit/{id}")
	public String getEditingClassSubject(@PathVariable int id, Model model) {
		logger.info("getEditingClassSubject->fired");
		model.addAttribute("classSubject", classSubjectServices.findOne(id));
		return "classSubject/editClassSubject";
	}

	@PostMapping(path = "/edit")
	public String updateClassSubject(@RequestBody @Valid ClassSubject classSubject, BindingResult result, Model model) {
		logger.info("updateClassSubject->fired");
		logger.info("classSubject=" + classSubject);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classSubject", classSubject);
			return "classSubject/editClassSubject";
		} else {
			classSubjectServices.update(classSubject);
			return "success";
		}

	}

	@GetMapping(path = "/classLevel/{id}")
	public String getClassLevelSubjects(@PathVariable int id, Model model) {
		logger.info("getClassLevelSubjects->fired");
		logger.info("id=" + id);

		ClassLevel classLevel = classLevelService.findOne(id);
		Iterable<ClassSubject> classSubjects = classSubjectServices.findAllByClassLevelId(id);

		logger.info("classLevel=" + classLevel);
		logger.info("classSubjects=" + classSubjects);

		model.addAttribute("classLevel", classLevel);
		model.addAttribute("classSubjects", classSubjects);
		return "classLevelSubjects";
	}

	@PostMapping(path = "/delete/{id}")
	@ResponseBody
	public String deleteClasSubject(@PathVariable int id) {
		logger.info("deleteClasSubject->fired");
		logger.info("id=" + id);
		classSubjectServices.delete(id);
		return "success";
	}

	@GetMapping(path = "/add/classLevel/{id}")
	public String getAddingClassSubject(@PathVariable int id, Model model) {
		logger.info("getAddingClassSubject->fired");
		model.addAttribute("classLevelId", id);
		model.addAttribute("classSubject", new ClassSubject());
		return "classSubject/addClassSubject";
	}

	@PostMapping(path = "/add/classLevel/{id}")
	public String addSubjectToClassLevel(@PathVariable int id, @RequestBody @Valid ClassSubject classSubject,
			BindingResult result, Model model) {
		logger.info("addSubjectToClassLevel->fired");
		logger.info("classSubject=" + classSubject);

		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classLevelId", id);
			model.addAttribute("classSubject", classSubject);
			return "classSubject/addClassSubject";
		} else {
			ClassLevel classLevel = new ClassLevel();
			classLevel.setId(id);
			classSubject.setClassLevel(classLevel);
			classSubjectServices.save(classSubject);
			return "success";
		}
	}

}
