package com.joh.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.SubjectNotificationDAO;
import com.joh.sms.model.SubjectNotification;

@Service
public class SubjectNotificationServiceImpl implements SubjectNotificationSerivce {

	@Autowired
	private SubjectNotificationDAO subjectNotificationDAO;

	@Override
	public List<SubjectNotification> findAllByClassSubjectIdAndClassGroupId(int classSubjectId, int classGroupId) {
		return subjectNotificationDAO.findAllByClassSubjectIdAndClassGroupId(classSubjectId, classGroupId);
	}

	@Override
	public SubjectNotification save(SubjectNotification subjectNotificaion) {
		return subjectNotificationDAO.save(subjectNotificaion);
	}

}