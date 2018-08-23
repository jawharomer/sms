package com.joh.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.StudentSubjectMarkD;
import com.joh.sms.domain.model.SubjectNotificationD;
import com.joh.sms.model.ClassGroup;
import com.joh.sms.model.ClassMark;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.SubjectNotification;
import com.joh.sms.model.Teacher;
import com.joh.sms.service.ClassGroupTableService;
import com.joh.sms.service.ClassMarkService;
import com.joh.sms.service.ClassSubjectService;
import com.joh.sms.service.StudentSubjectMarkService;
import com.joh.sms.service.SubjectNotificationSerivce;

@Controller()
@RequestMapping(path = "/teachers")
public class TeacherController {

	private static final Logger logger = Logger.getLogger(TeacherController.class);

	private Teacher teacher;

	@Autowired
	private ClassGroupTableService classGroupTableService;

	@Autowired
	private StudentSubjectMarkService studentSubjectMarkService;

	@Autowired
	private ClassMarkService classMarkService;

	@Autowired
	private ClassSubjectService classSubjectService;

	@Autowired
	private SubjectNotificationSerivce subjectNotificationSerivce;

	public TeacherController() {
		teacher = new Teacher();
		teacher.setId(6);
	}

	@ModelAttribute("classGroupTableDs")
	private List<ClassGroupTableD> classGroupTableDs() {
		logger.info("teacehr=" + teacher);

		List<ClassGroupTableD> classGroupTableDs = classGroupTableService
				.findAllTeacherClassGroupSubject(teacher.getId());

		logger.info("classGroupTableDs=" + classGroupTableDs);

		return classGroupTableDs;
	}

	@ModelAttribute("teacher")
	private Teacher teacher() {
		logger.info("teacehr=" + teacher);

		return teacher;
	}

	@GetMapping()
	public String getTeacherRoot(Model model) {
		logger.info("getTeacherRoot->fired");

		return "teacherRoot";
	}

	@GetMapping(path = "/marks")
	public String getClassSubjectMarks(@RequestParam int classGroupId, @RequestParam int classSubjectId, Model model) {
		logger.info("getClassSubjectMarks->fired");

		logger.info("classGroupId=" + classGroupId);
		logger.info("classSubjectId=" + classSubjectId);

		List<StudentSubjectMarkD> studentSubjectMarkDs = studentSubjectMarkService
				.findAllStudentSubjectMarkBySubjectIdAndGroupId(classSubjectId, classGroupId);

		logger.info("studentSubjectMarkDs=" + studentSubjectMarkDs);

		model.addAttribute("studentSubjectMarkDs", studentSubjectMarkDs);

		ClassSubject classSubject = classSubjectService.findOne(classSubjectId);

		Iterable<ClassMark> classMarks = classMarkService.findByClassLevelId(classSubject.getClassLevel().getId());
		logger.info("classMarks=" + classMarks);

		model.addAttribute("classMarks", classMarks);

		model.addAttribute("classGroupId", classGroupId);
		model.addAttribute("classSubjectId", classSubjectId);

		return "teacherClassSubjectMarks";
	}

	@GetMapping(path = "/notifications")
	public String getSubjectClassGroupNotifications(@RequestParam int classGroupId, @RequestParam int classSubjectId,
			Model model) {
		logger.info("getSubjectClassGroupNotifications->fired");

		logger.info("classGroupId=" + classGroupId);
		logger.info("classSubjectId=" + classSubjectId);

		List<SubjectNotification> subjectNotifications = subjectNotificationSerivce
				.findAllByClassSubjectIdAndClassGroupId(classSubjectId, classGroupId);

		logger.info("subjectNotifications=" + subjectNotifications);

		model.addAttribute("subjectNotifications", subjectNotifications);

		model.addAttribute("classGroupId", classGroupId);
		model.addAttribute("classSubjectId", classSubjectId);

		return "teacherSubjectNotifications";
	}

	@GetMapping(path = "/notifications/add")
	public String getAddingSubjectNotification(@RequestParam int classGroupId, @RequestParam int classSubjectId,
			Model model) {
		logger.info("getAddingSubjectNotification->fired");

		logger.info("classGroupId=" + classGroupId);
		logger.info("classSubjectId=" + classSubjectId);

		SubjectNotificationD subjectNotificationD = new SubjectNotificationD();

		subjectNotificationD.setClassGroupId(classGroupId);
		subjectNotificationD.setClassSubjectId(classSubjectId);

		model.addAttribute("subjectNotificationD", subjectNotificationD);

		return "teacher/addSubjectNotification";
	}

	@PostMapping(path = "/notifications/add")
	public String addSubjectNotificaion(@RequestBody @Valid SubjectNotificationD subjectNotificationD,
			BindingResult result, Model model) {
		logger.info("addSubjectNotificaion->fired");

		logger.info("subjectNotificationD=" + subjectNotificationD);

		logger.info("error=" + result.getAllErrors());

		if (result.hasErrors()) {

			model.addAttribute("subjectNotificationD", subjectNotificationD);

			return "teacher/addSubjectNotification";

		} else {
			SubjectNotification subjectNotification = new SubjectNotification();

			ClassSubject classSubject = new ClassSubject();
			classSubject.setId(subjectNotificationD.getClassSubjectId());

			ClassGroup classGroup = new ClassGroup();
			classGroup.setId(subjectNotificationD.getClassGroupId());

			subjectNotification.setClassSubject(classSubject);
			subjectNotification.setClassGroup(classGroup);
			subjectNotification.setNote(subjectNotificationD.getNote());

			subjectNotificationSerivce.save(subjectNotification);

		}

		return "teacher/addSubjectNotification";
	}

}
