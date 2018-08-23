package com.joh.sms.service;

import java.util.List;

import com.joh.sms.model.StudentNotification;
import com.joh.sms.model.SubjectNotification;

public interface StudentNotificationSerivce {

	List<StudentNotification> findAllByStudentId(int id);

}
