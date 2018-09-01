package com.joh.sms.service;

import java.util.List;

import com.joh.sms.model.SubjectNotification;

public interface SubjectNotificationSerivce {

	List<SubjectNotification> findAllByClassSubjectIdAndClassGroupId(int classSubjectId, int classGroupId);

	SubjectNotification save(SubjectNotification subjectNotificaion);

	void delete(int id);

}
