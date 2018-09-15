package com.joh.sms.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

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
import com.joh.sms.model.StudentLevel;
import com.joh.sms.model.SubjectNotification;
import com.joh.sms.model.Teacher;
import com.joh.sms.service.AuthenticationFacadeService;
import com.joh.sms.service.ClassGroupService;
import com.joh.sms.service.ClassGroupTableService;
import com.joh.sms.service.ClassMarkService;
import com.joh.sms.service.ClassSubjectService;
import com.joh.sms.service.StudentLevelService;
import com.joh.sms.service.StudentSubjectMarkService;
import com.joh.sms.service.SubjectNotificationSerivce;
import com.joh.sms.service.TeacherService;

@Controller()
@RequestMapping(path = "/teachers")
public class TeacherController {

	private static final Logger logger = Logger.getLogger(TeacherController.class);

	@Autowired
	private AuthenticationFacadeService authenticationFacadeService;

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

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private ClassGroupService classGroupService;

	@Autowired
	private StudentLevelService studentLevelService;

	private Teacher getTeacher() {
		return teacherService.findOne(authenticationFacadeService.getAppUserDetail().getReference());
	}

	@ModelAttribute("navClassGroupTableDs")
	private List<ClassGroupTableD> classGroupTableDs() {
		logger.info("teacehr=" + getTeacher());

		List<ClassGroupTableD> navClassGroupTableDs = classGroupTableService
				.findAllTeacherClassGroupSubject(getTeacher().getId());

		logger.info("navClassGroupTableDs=" + navClassGroupTableDs);

		return navClassGroupTableDs;
	}

	@ModelAttribute("teacher")
	private Teacher teacher() {
		logger.info("teacher=" + getTeacher());
		return getTeacher();
	}

	@GetMapping()
	public String getTeacherRoot(Model model) {
		logger.info("getTeacherRoot->fired");

		return "teacherRoot";
	}

	@GetMapping(path = "/marks")
	public String getClassSubjectMarks(@RequestParam int classGroupId, @RequestParam int classSubjectId, Model model)
			throws AccessDeniedException {
		logger.info("getClassSubjectMarks->fired");
		has(classGroupId, classSubjectId);

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
		model.addAttribute("classGroup", classGroupService.findOne(classGroupId));
		model.addAttribute("classSubject", classSubjectService.findOne(classSubjectId));

		return "teacherClassSubjectMarks";
	}

	@GetMapping(path = "/notifications")
	public String getSubjectClassGroupNotifications(@RequestParam int classGroupId, @RequestParam int classSubjectId,
			Model model) throws AccessDeniedException {
		logger.info("getSubjectClassGroupNotifications->fired");

		logger.info("classGroupId=" + classGroupId);
		logger.info("classSubjectId=" + classSubjectId);
		has(classGroupId, classSubjectId);

		List<SubjectNotification> subjectNotifications = subjectNotificationSerivce
				.findAllByClassSubjectIdAndClassGroupId(classSubjectId, classGroupId);

		logger.info("subjectNotifications=" + subjectNotifications);

		model.addAttribute("subjectNotifications", subjectNotifications);

		model.addAttribute("classGroupId", classGroupId);
		model.addAttribute("classSubjectId", classSubjectId);
		model.addAttribute("classGroup", classGroupService.findOne(classGroupId));
		model.addAttribute("classSubject", classSubjectService.findOne(classSubjectId));

		return "teacherSubjectNotifications";
	}

	@GetMapping(path = "/studentLevels")
	public String getAllSubjectStudentLevel(@RequestParam int classSubjectId, @RequestParam int classGroupId,
			Model model) throws AccessDeniedException {
		logger.info("getAllSubjectStudentLevel->fired");

		logger.info("classSubjectId=" + classSubjectId);
		has(classGroupId, classSubjectId);


		List<StudentLevel> studentLevels = studentLevelService.findAllSubjectStudentLevel(classSubjectId, classGroupId);

		logger.info("studentLevels=" + studentLevels);

		model.addAttribute("studentLevels", studentLevels);

		model.addAttribute("classGroupId", classGroupId);
		model.addAttribute("classSubjectId", classSubjectId);
		model.addAttribute("classGroup", classGroupService.findOne(classGroupId));
		model.addAttribute("classSubject", classSubjectService.findOne(classSubjectId));

		return "teacherStudentLevels";
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
		model.addAttribute("classGroup", classGroupService.findOne(classGroupId));
		model.addAttribute("classSubject", classSubjectService.findOne(classSubjectId));

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
			subjectNotification.setTitle(subjectNotificationD.getTitle());
			subjectNotification.setNote(subjectNotificationD.getNote());

			subjectNotificationSerivce.save(subjectNotification);

		}

		return "success";
	}

	@PostMapping(path = "/notifications/delete/{id}")
	public String deleteSubjectNotification(@PathVariable int id, Model model) {
		logger.info("deleteSubjectNotification->fired");
		logger.info("subjectNotificaionId=" + id);

		subjectNotificationSerivce.delete(id);
		return "success";
	}

	@GetMapping(path = "/classGroupTable/{id}")
	public String getTeacherClassGroupTable(@PathVariable int id, Model model) {
		logger.info("getTeacherClassGroupTable->fired");
		logger.info("teacherId=" + id);

		List<ClassGroupTableD> classGroupTableDs = classGroupTableService.findTeacherClassGroupTable(id);
		logger.info("classGroupTableDs=" + classGroupTableDs);

		model.addAttribute("classGroupTableDs", classGroupTableDs);

		return "teacherClassGroupTable";
	}

	// Helper

	private void has(int classGroupId, int classSubjectId) throws AccessDeniedException {

		List<ClassGroupTableD> navClassGroupTableDs = classGroupTableService
				.findAllTeacherClassGroupSubject(getTeacher().getId());

		Optional<ClassGroupTableD> matching = navClassGroupTableDs.stream()
				.filter(p -> p.getClassGroupId() == classGroupId && p.getClassSubjectId() == classSubjectId)
				.findFirst();

		if (!matching.isPresent())
			throw new AccessDeniedException("ناتوانی ئەمکارە ئەنجام بدەیت");

	}

}
