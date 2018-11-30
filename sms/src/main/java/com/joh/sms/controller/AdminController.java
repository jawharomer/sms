package com.joh.sms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joh.sms.domain.model.StudentNotificaionD;
import com.joh.sms.domain.model.StudentSubjectMarkD;
import com.joh.sms.domain.model.TeacherLecturePresentD;
import com.joh.sms.model.AppUser;
import com.joh.sms.model.AttachedFile;
import com.joh.sms.model.ClassMark;
import com.joh.sms.model.Enrollment;
import com.joh.sms.model.SMSMessage;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentLevel;
import com.joh.sms.model.StudentLevelDate;
import com.joh.sms.model.StudentNotification;
import com.joh.sms.model.Teacher;
import com.joh.sms.model.TeacherPresent;
import com.joh.sms.service.AppUserService;
import com.joh.sms.service.AttachedFileService;
import com.joh.sms.service.ClassMarkService;
import com.joh.sms.service.EnrollmentService;
import com.joh.sms.service.MessageService;
import com.joh.sms.service.StudentLevelDateService;
import com.joh.sms.service.StudentLevelService;
import com.joh.sms.service.StudentNotificationSerivce;
import com.joh.sms.service.StudentService;
import com.joh.sms.service.StudentSubjectMarkService;
import com.joh.sms.service.TeacherPresentService;
import com.joh.sms.service.TeacherService;
import com.joh.sms.validator.TeacherPresentValidator;

@Controller()
@RequestMapping(path = "/admin")
public class AdminController {

	private static final Logger logger = Logger.getLogger(AdminController.class);

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentNotificationSerivce studentNotificationSerivce;

	@Autowired
	private StudentSubjectMarkService studentSubjectMarkService;

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private ClassMarkService classMarkService;

	@Autowired
	private TeacherPresentService teacherPresentService;

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private AttachedFileService attachedFileService;

	@Autowired
	private StudentLevelService studentLevelService;

	@Autowired
	private StudentLevelDateService studentLevelDateService;

	@Autowired
	private MessageService messageService;

	@GetMapping()
	public String getAmdinPage() {
		return "adminRoot";
	}

	@GetMapping(path = "/students")
	public String getStudents(Model model) {
		Iterable<Student> students = studentService.findAllStudent();
		logger.info("students=" + students);
		model.addAttribute("students", students);

		return "adminStudents";
	}

	@PostMapping(path = "/students/{id}")
	@ResponseBody
	public String deleteStudent(@PathVariable int id) {
		logger.info("deleteStudent->fired");
		logger.info("id=" + id);
		studentService.delete(id);
		return "success";
	}

	@GetMapping(path = "/students/add")
	public String getAddingStudent(Model model) {
		logger.info("getAddingStudent->fired");
		model.addAttribute("student", new Student());
		return "admin/addStudent";
	}

	@PostMapping(path = "/students/add")
	public String addStudent(@RequestParam MultipartFile file, @Valid Student student, BindingResult result)
			throws IOException {
		logger.info("addStudent->fired");
		logger.info("FileName=" + file.getOriginalFilename());
		logger.info("student=" + student);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			return "admin/addStudent";
		} else {

			if (!file.isEmpty()) {
				AttachedFile attachedFile = attachedFileService.save(file);
				logger.info("attachedFile=" + attachedFile);
				student.setAttachedFile(attachedFile);
			}

			studentService.save(student);
			return "success";
		}

	}

	@GetMapping(path = "/students/edit/{id}")
	public String getEditingStudent(@PathVariable int id, Model model) {
		logger.info("getEditingStudent->fired");
		model.addAttribute("student", studentService.findOne(id));
		return "admin/editStudent";
	}

	@PostMapping(path = "/students/update")
	public String updateStudent(@RequestParam MultipartFile file, @Valid Student student, BindingResult result,
			Model model) throws IOException {
		logger.info("updateStudent->fired");
		logger.info("student=" + student);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("student", student);
			return "admin/editStudent";
		} else {

			AttachedFile oldAttachedFile = studentService.findOne(student.getId()).getAttachedFile();

			logger.info("oldAttachedFile=" + oldAttachedFile);

			boolean newAttachedFileExists = false;

			if (!file.isEmpty()) {
				newAttachedFileExists = true;
				logger.info("attache new image to student");
				AttachedFile attachedFile = attachedFileService.save(file);
				logger.info("attachedFile=" + attachedFile);
				student.setAttachedFile(attachedFile);
			} else {
				// Keep old attached file
				student.setAttachedFile(studentService.findOne(student.getId()).getAttachedFile());
			}

			studentService.update(student);

			// Remove Old Image
			if (oldAttachedFile != null && newAttachedFileExists) {
				attachedFileService.delete(oldAttachedFile);
			}

			return "success";
		}

	}

	@GetMapping(path = "/students/{id}/marks")
	public String getStudentMakrs(@PathVariable int id, Model model) {
		logger.info("getStudentMakrs->fired");
		logger.info("studentId=" + id);

		Student student = studentService.findOne(id);

		List<StudentSubjectMarkD> studentSubjectMarkDs = studentSubjectMarkService
				.findAllStudentStudentSubjectMark(student.getId());

		logger.info("studentSubjectMarkDs=" + studentSubjectMarkDs);
		Enrollment enrollment = enrollmentService.findEnrollmentByStudentId(student.getId());
		Iterable<ClassMark> classMarks = classMarkService
				.findByClassLevelId(enrollment.getClassGroup().getClassLevel().getId());

		logger.info("classMarks=" + classMarks);

		model.addAttribute("studentSubjectMarkDs", studentSubjectMarkDs);
		model.addAttribute("classMarks", classMarks);

		return "student/studentStudentSubjectMarks";

	}

	// Student Notificaions

	@GetMapping(path = "/students/notificaions")
	public String getAllStudentNotificaions(Model model) {

		Iterable<StudentNotification> studentNotifications = studentNotificationSerivce.findAll();
		model.addAttribute("studentNotifications", studentNotifications);
		return "adminStudentNotifications";
	}

	@GetMapping(path = "/students/notificaions/add")
	public String getAddingStudentNotificaions(@RequestParam("studentIds[]") Integer[] studentIds, Model model)
			throws JsonProcessingException {
		logger.info("getAddingStudentNotificaions->fired");
		logger.info("studnetIds=" + studentIds);
		StudentNotificaionD studentNotificaionD = new StudentNotificaionD();

		ObjectMapper objectMapper = new ObjectMapper();
		model.addAttribute("studentIds", objectMapper.writeValueAsString(studentIds));
		model.addAttribute("studentNotificaionD", studentNotificaionD);
		return "notification/addStudentNotification";
	}

	@PostMapping(path = "/students/notificaions/add")
	public String addStudentNotificaions(@RequestBody @Valid StudentNotificaionD studentNotificaionD,
			BindingResult result, Model model) throws JsonProcessingException {
		logger.info("addStudentNotificaions->fired");
		logger.info("studentNotificaionD=" + studentNotificaionD);
		logger.info("errors=" + result.getAllErrors());
		if (result.hasErrors()) {

			ObjectMapper objectMapper = new ObjectMapper();
			model.addAttribute("studentIds", objectMapper.writeValueAsString(studentNotificaionD.getStudentIds()));
			model.addAttribute("studentNotificaionD", studentNotificaionD);
			return "notification/addStudentNotification";
		} else {

			List<Student> students = new ArrayList<>();
			for (Integer studentId : studentNotificaionD.getStudentIds()) {
				Student student = new Student();
				student.setId(studentId);
				students.add(student);
			}

			StudentNotification studentNotification = new StudentNotification();
			studentNotification.setStudents(students);
			studentNotification.setTitle(studentNotificaionD.getTitle());
			studentNotification.setNote(studentNotificaionD.getNote());
			studentNotificationSerivce.save(studentNotification);
			return "success";
		}
	}

	@GetMapping(path = "/students/sms/add")
	public String getAddingStudentSMS(@RequestParam("studentIds[]") Integer[] studentIds, Model model)
			throws JsonProcessingException {
		logger.info("getAddingStudentSMS->fired");
		logger.info("studnetIds=" + studentIds);
		StudentNotificaionD studentNotificaionD = new StudentNotificaionD();
		ObjectMapper objectMapper = new ObjectMapper();
		model.addAttribute("studentIds", objectMapper.writeValueAsString(studentIds));
		model.addAttribute("studentNotificaionD", studentNotificaionD);
		return "notification/addStudentSMS";
	}

	@PostMapping(path = "/students/sms/add")
	public String addStudentSMS(@RequestBody @Valid StudentNotificaionD studentNotificaionD, BindingResult result,
			Model model) throws JsonProcessingException {
		logger.info("addStudentSMS->fired");
		logger.info("studentNotificaionD=" + studentNotificaionD);
		logger.info("errors=" + result.getAllErrors());
		if (result.hasErrors()) {

			ObjectMapper objectMapper = new ObjectMapper();
			model.addAttribute("studentIds", objectMapper.writeValueAsString(studentNotificaionD.getStudentIds()));
			model.addAttribute("studentNotificaionD", studentNotificaionD);
			return "notification/addStudentSMS";
		} else {

			int selectedContact = Integer.parseInt(studentNotificaionD.getTitle());

			logger.info("selectedContact=" + selectedContact);

			List<Student> students = new ArrayList<>();
			for (Integer studentId : studentNotificaionD.getStudentIds()) {
				students.add(studentService.findOne(studentId));
			}

			logger.info("students=" + students);

			List<SMSMessage> smsMessages = new ArrayList<>();

			String signature = "قوتابخانەی کۆرەک";

			for (Student student : students) {

				if ((selectedContact == 0 || selectedContact == 2) && student.getMobile() != null
						&& !student.getMobile().isEmpty()) {
					String fullName = String.format("%s %s %s ", student.getFirstName(), student.getMiddleName(),
							student.getLastName());
					SMSMessage forStudent = new SMSMessage();
					forStudent.setTo(student.getMobile());
					String message = String.format("%s \n %s \n %s", signature, fullName,
							studentNotificaionD.getNote());
					forStudent.setMessage(message);
					smsMessages.add(forStudent);
				}

				if ((selectedContact == 1 || selectedContact == 2) && student.getParentMobile() != null
						&& !student.getParentMobile().isEmpty()) {
					String fullName = String.format("بەخێوکەری قوتابی %s %s %s \n", student.getFirstName(),
							student.getMiddleName(), student.getLastName());
					SMSMessage forParent = new SMSMessage();
					forParent.setTo(student.getParentMobile());
					String message = String.format("%s \n %s \n %s", signature, fullName,
							studentNotificaionD.getNote());
					forParent.setMessage(message);
					smsMessages.add(forParent);
				}

			}

			logger.info("smsMessages=" + smsMessages);

			try {
				messageService.saveSMS(smsMessages);// Put Message in queue
				messageService.sendSMS();
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failed";
			}

		}
	}

	@PostMapping(path = "/students/notificaions/delete/{id}")
	public String deleteStudentNotification(@PathVariable int id) {
		logger.info("getAddingStudentNotificaions->fired");
		logger.info("id=" + id);
		studentNotificationSerivce.delete(id);
		return "success";
	}

	@GetMapping(path = "/notificaions/{id}/students")
	public String getStudentNotificaionStudents(@PathVariable int id, Model model) {
		logger.info("getStudentNotificaionStudents->fired");
		logger.info("id=" + id);
		List<Student> students = studentService.findAllByNotificationId(id);
		model.addAttribute("students", students);
		return "notification/notificaionStudents";
	}

	@GetMapping(path = "/students/{id}/studentLevelDates")
	public String getAllStudentLevelDates(@PathVariable int id, Model model) {
		logger.info("getAllStudentLevelDates->fired");
		logger.info("id=" + id);
		Iterable<StudentLevelDate> studentLevelDates = studentLevelDateService.findAll();

		model.addAttribute("studentLevelDates", studentLevelDates);
		model.addAttribute("id", id);

		return "admin/studentStudentLevelDates";
	}

	@GetMapping(path = "/students/{id}/studentLevel")
	public String getAllStudentStudenLevel(@PathVariable int id, @RequestParam int studentLevelDateId, Model model) {
		logger.info("getAllStudentStudenLevel->fired");
		logger.info("studentId=" + id);
		logger.info("studentLevelDateId=" + studentLevelDateId);

		StudentLevelDate studentLevelDate = studentLevelDateService.findOne(studentLevelDateId);

		Student student = studentService.findOne(id);

		Iterable<StudentLevel> studentLevels = studentLevelService.findAllByStudentIdAndDateId(id, studentLevelDateId);
		logger.info("studentLevels=" + studentLevels);

		model.addAttribute("studentLevels", studentLevels);
		model.addAttribute("studentLevelDate", studentLevelDate);
		model.addAttribute("student", student);
		return "adminStudentStudentLevel";
	}

	// Teachers

	@GetMapping(path = "/teachers")
	public String getTeachers(Model model) {

		Iterable<Teacher> teachers = teacherService.findAll();
		logger.info("teachers=" + teachers);
		model.addAttribute("teachers", teachers);
		return "adminTeachers";
	}

	@GetMapping(path = "/teachers/add")
	public String getAddingTeacher(Model model) {
		logger.info("getAddingTeacher->fired");
		model.addAttribute("teacher", new Teacher());
		return "admin/addTeacher";
	}

	@PostMapping(path = "/teachers/add")
	public String addTeacher(@RequestBody @Valid Teacher teacher, BindingResult result) {
		logger.info("addTeacher->fired");
		logger.info("student=" + teacher);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			return "admin/addTeacher";
		} else {
			teacherService.save(teacher);
			return "success";
		}

	}

	@PostMapping(path = "/teachers/{id}")
	@ResponseBody
	public String deleteTeacher(@PathVariable int id) {
		logger.info("fired");
		logger.info("id=" + id);
		teacherService.delete(id);
		return "success";
	}

	@GetMapping(path = "/teachers/edit/{id}")
	public String getEditingTeacher(@PathVariable int id, Model model) {
		logger.info("getEditingTeacher->fired");
		model.addAttribute("teacher", teacherService.findOne(id));
		return "admin/editTeacher";
	}

	@PostMapping(path = "/teachers/update")
	public String updateTeacher(@RequestBody @Valid Teacher teacher, BindingResult result, Model model) {
		logger.info("updateTeacher->fired");
		logger.info("teacher=" + teacher);
		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("teacher", teacher);
			return "admin/editTeacher";
		} else {
			teacherService.update(teacher);
			return "success";
		}

	}

	@GetMapping(path = "/teacherLecturePresents")
	public String getAllTeacherLecturePresents(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to, Model model) {
		logger.info("getAllTeacherLecturePresents->fired");
		logger.info("from=" + from);
		logger.info("to=" + to);

		List<TeacherLecturePresentD> teacherLecturePresentDs = teacherService.findAllTeacherLecturePresent(from, to);

		model.addAttribute("teacherLecturePresentDs", teacherLecturePresentDs);
		model.addAttribute("from", from);
		model.addAttribute("to", to);

		return "adminTeacherLecturePresents";
	}

	@GetMapping(path = "/teacherPresents")
	public String getTeacherPresents(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to, Model model) {
		logger.info("getAllTeacherLecturePresents->fired");
		logger.info("from=" + from);
		logger.info("to=" + to);

		List<TeacherPresent> teacherPresents = teacherPresentService.findAllByDateBetweenOrderByDateDesc(from, to);

		model.addAttribute("teacherPresents", teacherPresents);
		model.addAttribute("from", from);
		model.addAttribute("to", to);

		return "adminTeacherPresents";
	}

	@GetMapping(path = "/teacherPresents/add")
	public String getAddingTeacherPresent(Model model) {
		logger.info("getAddingTeacherPresent->fired");

		Iterable<Teacher> teachers = teacherService.findAll();

		model.addAttribute("teacherPresent", new TeacherPresent());

		model.addAttribute("teachers", teachers);

		return "admin/addTeacherPresent";
	}

	@PostMapping(path = "/teacherPresents/add")
	public String addTeacherPresent(
			@RequestBody @Validated(TeacherPresentValidator.insert.class) TeacherPresent teacherPresent,
			BindingResult result, Model model) {
		logger.info("addTeacherPresent->fired");

		logger.info("errors=" + result.getAllErrors());

		if (result.hasErrors()) {
			Iterable<Teacher> teachers = teacherService.findAll();

			model.addAttribute("teacherPresent", teacherPresent);

			model.addAttribute("teachers", teachers);

			return "admin/addTeacherPresent";
		} else {
			teacherPresentService.save(teacherPresent);
			return "success";
		}

	}

	@GetMapping(path = "/teacherPresents/edit/{id}")
	public String getEditingTeacherPresent(@PathVariable int id, Model model) {
		logger.info("getEditingTeacherPresent->fired");

		TeacherPresent teacherPresent = teacherPresentService.findOne(id);

		model.addAttribute("teacherPresent", teacherPresent);

		return "admin/editTeacherPresent";
	}

	@PostMapping(path = "/teacherPresents/update")
	public String updateTeacherPresent(
			@RequestBody @Validated(TeacherPresentValidator.insert.class) TeacherPresent teacherPresent,
			BindingResult result, Model model) {
		logger.info("updateTeacherPresent->fired");

		logger.info("errors=" + result.getAllErrors());

		if (result.hasErrors()) {
			model.addAttribute("teacherPresent", teacherPresent);

			return "admin/editTeacherPresent";
		} else {
			teacherPresentService.update(teacherPresent);
			return "success";
		}

	}

	@PostMapping(path = "/teacherPresents/delete/{id}")
	public String deleteTeacherPresent(@PathVariable int id) {
		logger.info("deleteTeacherPresent->fired");
		logger.info("teacherPresentId=" + id);
		teacherPresentService.delete(id);
		return "success";
	}

	// User

	@GetMapping(path = "/users/add/{role}")
	public String getAddUser(@PathVariable String role, @RequestParam(required = false) Integer reference,
			Model model) {
		logger.info("getAddUser->fired");
		logger.info("role=" + role);
		AppUser appUser = new AppUser();
		appUser.setRole(role);
		appUser.setReference(reference);
		try {
			AppUser appUserOld = appUserService.findByRoleAndReference(role, reference);
			logger.info("user already exists");
			appUser.setId(appUserOld.getId());
			appUser.setUserName(appUserOld.getUserName());
		} catch (NullPointerException e) {
			logger.info("user does not exists");
		}

		model.addAttribute("appUser", appUser);
		return "admin/addUser";
	}

	@PostMapping(path = "/users/add")
	public String addUser(@RequestBody @Valid AppUser appUser, BindingResult result, Model model) {
		logger.info("addUser->fired");
		logger.info("appUser=" + appUser);
		logger.info("errors=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("appUser", appUser);
			return "admin/addUser";
		} else {
			String plainPassword = appUser.getPassword();
			appUserService.save(appUser);

			// S-Send SMS to user
			try {
				String smsTo = "";

				if (appUser.getRole().toLowerCase().contains("student")) {
					Student student = studentService.findOne(appUser.getReference());
					if (student.getMobile() != null)
						smsTo = student.getMobile();
				} else if (appUser.getRole().toLowerCase().contains("parent")) {
					Student student = studentService.findOne(appUser.getReference());
					if (student.getParentMobile() != null)
						smsTo = student.getParentMobile();
				}

				else if (appUser.getRole().toLowerCase().contains("teacher")) {
					Teacher teacher = teacherService.findOne(appUser.getReference());
					if (teacher.getMobile() != null)
						smsTo = teacher.getMobile();
				}

				logger.info("smsTo=" + smsTo);

				final String mobileNumber = smsTo;
				if (!smsTo.isEmpty()) {
					new Thread(() -> {
						logger.info("sending sms to user");

						String signature = "قوتابخانەی کۆرەک";
						SMSMessage forUser = new SMSMessage();
						forUser.setTo(mobileNumber);
						String message = String.format("%s \n %s \n %s", signature, "بەکاربەر:" + appUser.getUserName(),
								"وشەی تێپەر:" + plainPassword);
						forUser.setMessage(message);
						List<SMSMessage> smsMessages = new ArrayList<>();
						smsMessages.add(forUser);
						try {
							messageService.saveSMS(smsMessages);// Put Message in queue
							messageService.sendSMS();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}).start();
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.info("sending sms to user failed");
			}
			// E-Sending sms to user

			return "success";
		}
	}

}
