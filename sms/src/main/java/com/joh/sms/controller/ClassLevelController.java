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

import com.joh.sms.commons.TestEnv;
import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.service.AcademicYearService;
import com.joh.sms.service.ClassLevelService;
import com.joh.sms.service.ClassSubjectService;

@Controller()
@RequestMapping(path = "/classLevels")
public class ClassLevelController {

	private static final Logger logger = Logger.getLogger(ClassLevelController.class);

	@Autowired
	private ClassLevelService classLevelService;
	@Autowired
	private AcademicYearService academicYearService;

	@Autowired
	private ClassSubjectService classSubjectServices;

	@GetMapping()
	public String getAllClassLevel(Model model) {
		logger.info("getAllClassLevel->fired");
		model.addAttribute("classLevels", classLevelService.findAll());
		return "adminClassLevels";
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public String deleteClassLevel(@PathVariable int id) {
		logger.info("deleteClassLevel->fired");
		logger.info("id=" + id);
		classLevelService.delete(id);
		return "success";
	}

	@GetMapping(path = "/add")
	public String getAddingClassLevels(Model model) {
		logger.info("getAddingClassLevels->fired");
		model.addAttribute("classLevel", new ClassLevel());
		return "classLevel/addClassLevel";
	}

	@PostMapping(path = "/add")
	public String addClassLevel(@RequestBody @Valid ClassLevel classLevel, BindingResult result) {
		// Test
		academicYearService.save(TestEnv.acadimicYear());
		classLevel.setAcademicYear(TestEnv.acadimicYear());

		//

		classLevel.setAcademicYear(TestEnv.acadimicYear());
		logger.info("addClassLevel->fired");
		logger.info("classLevel=" + classLevel);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			return "classLevel/addClassLevel";
		} else {

			classLevelService.save(classLevel);

			// Test
			ClassSubject classSubject = new ClassSubject();
			classSubject.setClassLevel(classLevel);
			classSubject.setName("یاکەمی ب");
			classSubjectServices.save(classSubject);

			return "success";
		}

	}

	@GetMapping(path = "/edit/{id}")
	public String getEditingClassLevel(@PathVariable int id, Model model) {
		logger.info("getEditingClassLevel->fired");
		model.addAttribute("classLevel", classLevelService.findOne(id));
		return "classLevel/editClassLevel";
	}

	@PostMapping(path = "/update")
	public String updateClassLevel(@RequestBody @Valid ClassLevel classLevel, BindingResult result, Model model) {
		logger.info("updateClassLevel->fired");
		logger.info("classLevel=" + classLevel);

		// Prevent update AcademicYear
		classLevel.setAcademicYear(classLevelService.findOne(classLevel.getId()).getAcademicYear());

		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classLevel", classLevel);
			return "classLevel/editClassLevel";
		} else {
			classLevelService.update(classLevel);
			return "success";
		}

	}

}
