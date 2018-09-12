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

import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.ClassMark;
import com.joh.sms.service.ClassLevelService;
import com.joh.sms.service.ClassMarkService;

@Controller
@RequestMapping("/classMarks")
public class ClassMarkController {

	private static final Logger logger = Logger.getLogger(ClassMarkController.class);

	@Autowired
	private ClassMarkService classMarkService;
	@Autowired
	private ClassLevelService classLevelService;

	@GetMapping(path = "/edit/{id}")
	public String getEditingClassMark(@PathVariable int id, Model model) {
		logger.info("getEditingClassMark->fired");
		model.addAttribute("classMark", classMarkService.findOne(id));
		return "classMark/editClassMark";
	}

	@PostMapping(path = "/edit")
	public String updateClassMark(@RequestBody @Valid ClassMark classMark, BindingResult result, Model model) {
		logger.info("updateClassMark->fired");
		logger.info("classMark=" + classMark);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classMark", classMark);
			return "classMark/editClassMark";
		} else {
			classMarkService.update(classMark);
			return "success";
		}

	}

	@GetMapping(path = "/classLevel/{id}")
	public String getClassLevelMarks(@PathVariable int id, Model model) {
		logger.info("getClassLevelMarks->fired");
		logger.info("id=" + id);

		ClassLevel classLevel = classLevelService.findOne(id);
		Iterable<ClassMark> classMarks = classMarkService.findByClassLevelId(id);

		logger.info("classLevel=" + classLevel);
		logger.info("classMarks=" + classMarks);

		model.addAttribute("classLevel", classLevel);
		model.addAttribute("classMarks", classMarks);
		return "classLevelMarks";
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public String deleteClassMark(@PathVariable int id) {
		logger.info("deleteClassMark->fired");
		logger.info("id=" + id);
		classMarkService.delete(id);
		return "success";
	}

	@GetMapping(path = "/add/classLevel/{id}")
	public String getAddingClassMark(@PathVariable int id, Model model) {
		logger.info("getAddingClassMark->fired");
		model.addAttribute("classLevelId", id);
		model.addAttribute("classMark", new ClassMark());
		return "classMark/addClassMark";
	}

	@PostMapping(path = "/add/classLevel/{id}")
	public String addMarkToClassLevel(@PathVariable int id, @RequestBody @Valid ClassMark classMark,
			BindingResult result, Model model) {
		logger.info("addMarkToClassLevel->fired");
		logger.info("classMark=" + classMark);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classLevelId", id);
			model.addAttribute("classMark", classMark);
			return "classMark/addClassMark";
		} else {
			ClassLevel classLevel = new ClassLevel();
			classLevel.setId(id);
			classMark.setClassLevel(classLevel);
			classMarkService.save(classMark);
			return "success";
		}
	}

}
