package com.joh.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.StudentNotificationDAO;
import com.joh.sms.model.StudentNotification;

@Service
public class StudentNotificationServiceImpl implements StudentNotificationSerivce {

	@Autowired
	private StudentNotificationDAO studentNotificationDAO;

	@Override
	public List<StudentNotification> findAllByStudentId(int id) {
		return studentNotificationDAO.findAllByStudentId(id);
	}

	@Override
	public Iterable<StudentNotification> findAll() {
		return studentNotificationDAO.findAll();
	}

	@Override
	public StudentNotification save(StudentNotification studentNotification) {
		return studentNotificationDAO.save(studentNotification);
	}

	@Override
	public void delete(int id) {
		studentNotificationDAO.delete(id);
	}

}