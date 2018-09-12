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
import com.joh.sms.model.LessonTime;
import com.joh.sms.service.ClassLevelService;
import com.joh.sms.service.LessonTimeService;

@Controller
@RequestMapping(path = "/lessonTimes")
public class LessonTimeController {

	private static final Logger logger = Logger.getLogger(LessonTimeController.class);

	@Autowired
	private LessonTimeService lessonTimeService;
	@Autowired
	private ClassLevelService classLevelService;

	@GetMapping(path = "/edit/{id}")
	public String getEditingLessonTime(@PathVariable int id, Model model) {
		logger.info("getEditingLessonTime->fired");
		model.addAttribute("lessonTime", lessonTimeService.findOne(id));
		return "lessonTime/editLessonTime";
	}

	@PostMapping(path = "/edit")
	public String updateLessonTime(@RequestBody @Valid LessonTime lessonTime, BindingResult result, Model model) {
		logger.info("updateLessonTime->fired");
		logger.info("lessonTime=" + lessonTime);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("lessonTime", lessonTime);
			return "lessonTime/editLessonTime";
		} else {
			lessonTimeService.update(lessonTime);
			return "success";
		}

	}

	@GetMapping(path = "/classLevel/{id}")
	public String getClassLevelLessonTime(@PathVariable int id, Model model) {
		logger.info("getClassLevelLessonTime->fired");
		logger.info("id=" + id);

		ClassLevel classLevel = classLevelService.findOne(id);
		Iterable<LessonTime> lessonTimes = lessonTimeService.findByClassLevelId(id);

		logger.info("classLevel=" + classLevel);
		logger.info("lessonTimes=" + lessonTimes);

		model.addAttribute("classLevel", classLevel);
		model.addAttribute("lessonTimes", lessonTimes);
		return "classLevelLessonTimes";
	}

	@PostMapping(path = "/delete/{id}")
	@ResponseBody
	public String deleteLessonTime(@PathVariable int id) {
		logger.info("deleteLessonTime->fired");
		logger.info("id=" + id);
		lessonTimeService.delete(id);
		return "success";
	}

	@GetMapping(path = "/add/classLevel/{id}")
	public String getAddingLessonTime(@PathVariable int id, Model model) {
		logger.info("getAddingLessonTime->fired");
		model.addAttribute("classLevelId", id);
		model.addAttribute("lessonTime", new LessonTime());
		return "lessonTime/addLessonTime";
	}

	@PostMapping(path = "/add/classLevel/{id}")
	public String addLessonTimeToClassLevel(@PathVariable int id, @RequestBody @Valid LessonTime lessonTime,
			BindingResult result, Model model) {
		logger.info("addLessonTimeToClassLevel->fired");
		logger.info("lessonTime=" + lessonTime);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("classLevelId", id);
			model.addAttribute("lessonTime", lessonTime);
			return "lessonTime/addLessonTime";
		} else {
			ClassLevel classLevel = new ClassLevel();
			classLevel.setId(id);
			lessonTime.setClassLevel(classLevel);
			lessonTimeService.save(lessonTime);
			return "success";
		}
	}

}
