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

import com.joh.sms.model.SchoolWeekDay;
import com.joh.sms.service.SchoolWeekDayService;

@Controller()
@RequestMapping(path = "/schoolWeekDays")
public class SchoolWeekDayController {

	private static final Logger logger = Logger.getLogger(SchoolWeekDayController.class);

	@Autowired
	private SchoolWeekDayService schoolWeekDayService;

	@GetMapping()
	public String getAllSchoolWeekDay(Model model) {
		logger.info("getAllSchoolWeekDay->fired");
		model.addAttribute("schoolWeekDays", schoolWeekDayService.findAll());
		return "adminSchoolWeekDays";
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public String delteSchoolWeekDay(@PathVariable int id) {
		logger.info("delteSchoolWeekDay->fired");
		logger.info("id=" + id);
		schoolWeekDayService.delete(id);
		return "success";
	}

	@GetMapping(path = "/add")
	public String getAddingSchoolWeekDay(Model model) {
		logger.info("getAddingSchoolWeekDay->fired");
		model.addAttribute("schoolWeekDay", new SchoolWeekDay());
		return "schoolWeekDay/addSchoolWeekDay";
	}

	@PostMapping(path = "/add")
	public String addSchoolWeekDay(@RequestBody @Valid SchoolWeekDay schoolWeekDay, BindingResult result) {
		logger.info("addSchoolWeekDay->fired");
		logger.info("schoolWeekDay=" + schoolWeekDay);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			return "schoolWeekDay/addSchoolWeekDay";
		} else {
			schoolWeekDayService.save(schoolWeekDay);
			return "success";
		}

	}

	@GetMapping(path = "/edit/{id}")
	public String getEditingSchoolWeekDay(@PathVariable int id, Model model) {
		logger.info("getEditingSchoolWeekDay->fired");
		model.addAttribute("schoolWeekDay", schoolWeekDayService.findOne(id));
		return "schoolWeekDay/editSchoolWeekDay";
	}

	@PostMapping(path = "/update")
	public String updateSchoolWeekDay(@RequestBody @Valid SchoolWeekDay schoolWeekDay, BindingResult result,
			Model model) {

		logger.info("updateSchoolWeekDay->fired");
		logger.info("schoolWeekDay=" + schoolWeekDay);

		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("schoolWeekDay", schoolWeekDay);
			return "schoolWeekDay/editSchoolWeekDay";
		} else {
			schoolWeekDayService.update(schoolWeekDay);
			return "success";
		}

	}

}
