package com.joh.sms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.StudentSubjectMarkD;
import com.joh.sms.model.ClassGroup;
import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.ClassMark;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.Enrollment;
import com.joh.sms.model.LessonTime;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentLevel;
import com.joh.sms.model.StudentLevelDate;
import com.joh.sms.model.StudentNotification;
import com.joh.sms.model.SubjectNotification;
import com.joh.sms.service.AuthenticationFacadeService;
import com.joh.sms.service.ClassGroupService;
import com.joh.sms.service.ClassGroupTableService;
import com.joh.sms.service.ClassLevelService;
import com.joh.sms.service.ClassMarkService;
import com.joh.sms.service.ClassSubjectService;
import com.joh.sms.service.EnrollmentService;
import com.joh.sms.service.LessonTimeService;
import com.joh.sms.service.StudentLevelDateService;
import com.joh.sms.service.StudentLevelService;
import com.joh.sms.service.StudentNotificationSerivce;
import com.joh.sms.service.StudentPresentService;
import com.joh.sms.service.StudentService;
import com.joh.sms.service.StudentSubjectMarkService;
import com.joh.sms.service.SubjectNotificationSerivce;

@Controller()
@RequestMapping(path = "/students")
public class StudentController {

	private static final Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private AuthenticationFacadeService authenticationFacadeService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ClassGroupService classGroupService;

	@Autowired
	private ClassLevelService classLevelService;

	@Autowired
	private ClassSubjectService classSubjectService;

	@Autowired
	private LessonTimeService lessonTimeService;

	@Autowired()
	private ClassGroupTableService classGroupTableService;

	@Autowired()
	private StudentSubjectMarkService studentSubjectMarkService;

	@Autowired()
	private EnrollmentService enrollmentService;

	@Autowired()
	private ClassMarkService classMarkService;

	@Autowired()
	private SubjectNotificationSerivce subjectNotificationSerivce;

	@Autowired()
	private StudentNotificationSerivce studentNotificationSerivce;

	@Autowired()
	private StudentPresentService studentPresentService;

	@Autowired()
	private StudentLevelService studentLevelService;
	@Autowired()
	private StudentLevelDateService studentLevelDateService;

	private Student getStudent() {
		return studentService.findOne(authenticationFacadeService.getAppUserDetail().getReference());
	}

	public StudentController() {
	}

	@ModelAttribute("classSubjects")
	private Iterable<ClassSubject> classSubjects() {
		logger.info("student=" + getStudent());
		try {
			ClassLevel classLevel = classLevelService.findClassLevelByStudentId(getStudent().getId());
			Iterable<ClassSubject> classSubjects = classSubjectService.findAllByClassLevelId(classLevel.getId());

			logger.info("classSubjects=" + classSubjects);
			return classSubjects;
		} catch (NullPointerException e) {
			logger.info(
					"classLevel or classSubjects is not avaiable for this student it seams this user is not enrolled to any calss groups");
		}
		return null;
	}

	@ModelAttribute("student")
	private Student student() {
		logger.info("student=" + getStudent());
		return getStudent();
	}

	@GetMapping()
	public String getStudenRoot(Model model) {
		logger.info("getStudenRoot->fired");
		return "studentRoot";
	}

	@GetMapping(path = "/classGroupTable")
	public String getClassGroupTable(Model model) {
		logger.info("getClassGroupTable->fired");

		logger.info("student=" + getStudent());

		ClassGroup classGroup = classGroupService.findByStudentId(getStudent().getId());

		logger.info("classGroup=" + classGroup);

		ClassLevel classLevel = classLevelService.findClassLevelByStudentId(getStudent().getId());
		logger.info("classLevel=" + classLevel);

		List<ClassGroupTableD> classGroupTableDs = classGroupTableService.findAllClassGroupTable(classGroup.getId());
		logger.info("classGroupTableDs=" + classGroupTableDs);
		Iterable<LessonTime> lessonTimes = lessonTimeService.findByClassLevelId(classLevel.getId());

		logger.info("lessonTimes=" + lessonTimes);
		model.addAttribute("classGroupTableDs", classGroupTableDs);
		model.addAttribute("lessonTimes", lessonTimes);

		return "studentClassGroupTable";
	}

	@GetMapping(path = "/marks")
	public String getStudentAllSubjectMark(Model model) {
		logger.info("getStudentAllSubjectMark->fired");
		logger.info("student=" + getStudent());
		List<StudentSubjectMarkD> studentSubjectMarkDs = studentSubjectMarkService
				.findAllStudentStudentSubjectMark(getStudent().getId());

		logger.info("studentSubjectMarkDs=" + studentSubjectMarkDs);
		Enrollment enrollment = enrollmentService.findEnrollmentByStudentId(getStudent().getId());

		Iterable<ClassMark> classMarks = classMarkService
				.findByClassLevelId(enrollment.getClassGroup().getClassLevel().getId());

		logger.info("classMarks=" + classMarks);

		model.addAttribute("studentSubjectMarkDs", studentSubjectMarkDs);
		model.addAttribute("classMarks", classMarks);

		return "studentStudentSubjectMarks";
	}

	@GetMapping(path = "/notifications/classSubject/{id}")
	public String getSubjectNotification(@PathVariable int id, Model model) {
		logger.info("getSubjectNotification->fired");
		logger.info("student=" + getStudent());
		logger.info("classSubjectId=" + id);

		ClassGroup classGroup = classGroupService.findByStudentId(getStudent().getId());
		List<SubjectNotification> subjectNotifications = subjectNotificationSerivce
				.findAllByClassSubjectIdAndClassGroupId(id, classGroup.getId());
		logger.info("subjectNotifications=" + subjectNotifications);

		model.addAttribute("subjectNotifications", subjectNotifications);
		model.addAttribute("classSubject", classSubjectService.findOne(id));

		return "studentSubjectNotifications";
	}

	@GetMapping(path = "/notifications")
	public String getAllStudentNotification(Model model) {
		logger.info("getAllStudentNotification->fired");
		logger.info("student=" + getStudent());
		List<StudentNotification> studentNotifications = studentNotificationSerivce
				.findAllByStudentId(getStudent().getId());

		logger.info("studentNotifications=" + studentNotifications);

		model.addAttribute("studentNotifications", studentNotifications);

		return "studentNotifications";
	}
	
	@GetMapping(path = "/studentLevelDates")
	public String getAllStudentStudenLevelDate(Model model) {
		logger.info("getAllStudentStudenLevelDate->fired");
		
		Iterable<StudentLevelDate> studentLevelDates = studentLevelDateService.findAll();

		model.addAttribute("studentLevelDates", studentLevelDates);
		return "studentStudentLevelDates";
	}

	@GetMapping(path = "/studentLevel/{studentLevelDateId}")
	public String getAllStudentStudenLevel(@PathVariable int studentLevelDateId,Model model) {
		logger.info("getAllStudentStudenLevel->fired");

		Iterable<StudentLevel> studentLevels = studentLevelService.findAllByStudentIdAndDateId(getStudent().getId(), studentLevelDateId);
		logger.info("studentLevels=" + studentLevels);

		model.addAttribute("studentLevels", studentLevels);
		return "studentStudentLevel";
	}

	@ExceptionHandler(NullPointerException.class)
	public String nullPointerExceptionHandler(Model model) {
		logger.info("nullPointerExceptionHandler->fired");
		return "studentNullPointerException";
	}

}
