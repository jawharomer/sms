package com.joh.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.StudentLevelDAO;
import com.joh.sms.dao.StudentLevelDateDAO;
import com.joh.sms.model.StudentLevel;
import com.joh.sms.model.StudentLevelDate;

@Service
public class StudentLevelDateServiceImpl implements StudentLevelDateService {

	@Autowired
	private StudentLevelDateDAO studentLevelDateDAO;

	@Autowired
	private StudentLevelDAO studentLevelDAO;

	@Override
	public StudentLevelDate save(StudentLevelDate studentLevelDate) {
		return studentLevelDateDAO.save(studentLevelDate);
	}

	@Override
	public Iterable<StudentLevelDate> findAll() {
		return studentLevelDateDAO.findAllByOrderByIdDesc();
	}

	@Override
	public void delete(int id) {
		List<StudentLevel> studentLevels = studentLevelDAO.findAllByStudentLevelDateId(id);
		studentLevels.stream().forEach(e -> {
			studentLevelDAO.delete(e.getId());
		});
		studentLevelDateDAO.delete(id);
	}

	@Override
	public StudentLevelDate findOne(int id) {
		return studentLevelDateDAO.findOne(id);
	}

}
