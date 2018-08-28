package com.joh.sms.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.joh.sms.dao.ClassGroupTableDAO;
import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.model.ClassGroup;
import com.joh.sms.model.ClassGroupTable;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.LessonTime;
import com.joh.sms.model.SchoolWeekDay;
import com.joh.sms.model.Teacher;
import com.joh.sms.service.ClassGroupService;
import com.joh.sms.service.ClassGroupTableService;
import com.joh.sms.service.ClassSubjectService;
import com.joh.sms.service.LessonTimeService;
import com.joh.sms.service.TeacherService;

@Controller
@RequestMapping(path = "/classGroupTables")
public class ClassGroupTableController {

	private static final Logger logger = Logger.getLogger(ClassGroupTableController.class);

	@Autowired
	private ClassGroupTableService classGroupTableService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private ClassSubjectService classSubjectService;

	@Autowired
	private LessonTimeService lessonTimeService;

	@Autowired
	private ClassGroupService classGroupService;

	@GetMapping(path = "/classGroup/{id}")
	public String getClassGroupTables(@PathVariable int id, Model model) {
		logger.info("getClasGroupTables->fired");
		logger.info("classGroupId=" + id);
		ClassGroup classGroup = classGroupService.findOne(id);

		List<ClassGroupTableD> classGroupTableDs = classGroupTableService.findAllClassGroupTable(classGroup.getId());
		logger.info("classGroupTableDs=" + classGroupTableDs);
		Iterable<LessonTime> lessonTimes = lessonTimeService.findByClassLevelId(classGroup.getClassLevel().getId());

		logger.info("lessonTimes=" + lessonTimes);
		model.addAttribute("classGroupTableDs", classGroupTableDs);
		model.addAttribute("lessonTimes", lessonTimes);
		model.addAttribute("classGroupId", id);

		return "adminClassGroupTables";
	}

	@GetMapping(path = "/add/{id}")
	public String getAddingClassMark(@PathVariable int id, @RequestParam int schoolWeekDayId,
			@RequestParam int lessonTimeId, Model model) {
		logger.info("getAddingClassMark->fired");
		logger.info("classGroupId=" + id);

		model.addAttribute("classGroupId", id);
		model.addAttribute("schoolWeekDayId", schoolWeekDayId);
		model.addAttribute("lessonTimeId", lessonTimeId);

		ClassGroupTableD classGroupTableD = new ClassGroupTableD();
		classGroupTableD.setClassGroupId(id);
		classGroupTableD.setSchoolWeekDayId(schoolWeekDayId);
		classGroupTableD.setLessonTimeId(lessonTimeId);

		model.addAttribute("classGroupTableD", classGroupTableD);

		Iterable<Teacher> teachers = teacherService.findAll();

		ClassGroup classGroup = classGroupService.findOne(id);

		Iterable<ClassSubject> classSubjects = classSubjectService
				.findAllByClassLevelId(classGroup.getClassLevel().getId());

		logger.info("classSubjects=" + classSubjects);

		logger.info("teachers=" + teachers);

		model.addAttribute("teachers", teachers);
		model.addAttribute("classSubjects", classSubjects);

		return "classGroupTable/addClassGroupTable";
	}

	@PostMapping(path = "/add/{id}")
	public String addClassGroupTable(@PathVariable int id, @RequestBody @Valid ClassGroupTableD classGroupTableD,
			BindingResult result, Model model) {
		logger.info("addClassGroupTable->fired");
		logger.info("classGroupId=" + id);

		logger.info("error=" + result.getAllErrors());

		if (result.hasErrors()) {

			classGroupTableD.setClassGroupId(id);
			model.addAttribute("classGroupTableD", classGroupTableD);

			Iterable<Teacher> teachers = teacherService.findAll();

			ClassGroup classGroup = classGroupService.findOne(id);

			Iterable<ClassSubject> classSubjects = classSubjectService
					.findAllByClassLevelId(classGroup.getClassLevel().getId());

			logger.info("classSubjects=" + classSubjects);

			logger.info("teachers=" + teachers);
			model.addAttribute("teachers", teachers);
			model.addAttribute("classSubjects", classSubjects);

			return "classGroupTable/addClassGroupTable";
		} else {
			ClassGroupTable classGroupTable = new ClassGroupTable();

			ClassGroup classGroup = new ClassGroup();
			classGroup.setId(id);

			Teacher teacher = new Teacher();
			teacher.setId(classGroupTableD.getTeacherId());

			SchoolWeekDay schoolWeekDay = new SchoolWeekDay();
			schoolWeekDay.setId(classGroupTableD.getSchoolWeekDayId());

			LessonTime lessonTime = new LessonTime();
			lessonTime.setId(classGroupTableD.getLessonTimeId());

			ClassSubject classSubject = new ClassSubject();
			classSubject.setId(classGroupTableD.getClassSubjectId());

			classGroupTable.setClassGroup(classGroup);
			classGroupTable.setTeacher(teacher);
			classGroupTable.setSchoolWeekDay(schoolWeekDay);
			classGroupTable.setLessonTime(lessonTime);
			classGroupTable.setClassSubject(classSubject);

			logger.info("classGroupTable->saving=" + classGroupTable);

			classGroupTableService.save(classGroupTable);
			return "success";

		}
	}

	@PostMapping(path = "/delete/{id}")
	public String deleteClassGroupTable(@PathVariable int id) {

		classGroupTableService.delete(id);

		return "success";
	}

}
