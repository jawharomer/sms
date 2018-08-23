package com.joh.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassSubjectDAO;
import com.joh.sms.dao.StudentNotificationDAO;
import com.joh.sms.dao.SubjectNotificationDAO;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.StudentNotification;
import com.joh.sms.model.SubjectNotification;

@Service
public class StudentNotificationServiceImpl implements StudentNotificationSerivce {

	@Autowired
	private StudentNotificationDAO studentNotificationDAO;

	@Override
	public List<StudentNotification> findAllByStudentId(int id) {
		return studentNotificationDAO.findAllByStudentId(id);
	}

}