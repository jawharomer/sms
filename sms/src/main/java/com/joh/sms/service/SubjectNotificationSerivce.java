package com.joh.sms.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.joh.sms.model.SubjectNotification;

public interface SubjectNotificationSerivce {

	List<SubjectNotification> findAllByClassSubjectIdAndClassGroupId(int classSubjectId, int classGroupId);


	void delete(int id);

	SubjectNotification save(SubjectNotification subjectNotificaion, MultipartFile file) throws IOException;

}
