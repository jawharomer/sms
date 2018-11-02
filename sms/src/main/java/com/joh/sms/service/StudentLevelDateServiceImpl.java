package com.joh.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.StudentLevelDateDAO;
import com.joh.sms.model.StudentLevelDate;

@Service
public class StudentLevelDateServiceImpl implements StudentLevelDateService {

	@Autowired
	private StudentLevelDateDAO studentLevelDateDAO;

	@Override
	public StudentLevelDate save(StudentLevelDate studentLevelDate) {
		return studentLevelDateDAO.save(studentLevelDate);
	}

	@Override
	public Iterable<StudentLevelDate> findAll() {
		return studentLevelDateDAO.findAll();
	}

	@Override
	public void delete(int id) {
		studentLevelDateDAO.delete(id);
	}

	@Override
	public StudentLevelDate findOne(int id) {
		return studentLevelDateDAO.findOne(id);
	}

}
