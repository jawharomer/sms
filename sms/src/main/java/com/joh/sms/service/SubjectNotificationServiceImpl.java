package com.joh.sms.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joh.sms.dao.SubjectNotificationDAO;
import com.joh.sms.model.AttachedFile;
import com.joh.sms.model.SubjectNotification;

@Service
public class SubjectNotificationServiceImpl implements SubjectNotificationSerivce {

	@Autowired
	private SubjectNotificationDAO subjectNotificationDAO;

	@Autowired
	private AttachedFileService attachedFileService;

	@Override
	public List<SubjectNotification> findAllByClassSubjectIdAndClassGroupId(int classSubjectId, int classGroupId) {
		return subjectNotificationDAO.findAllByClassSubjectIdAndClassGroupIdOrderByIdDesc(classSubjectId, classGroupId);
	}

	@Transactional
	@Override
	public SubjectNotification save(SubjectNotification subjectNotificaion, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			AttachedFile attachedFile = attachedFileService.save(file);
			subjectNotificaion.setAttachedFile(attachedFile);
		}
		return subjectNotificationDAO.save(subjectNotificaion);
	}

	@Transactional
	@Override
	public void delete(int id) {

		SubjectNotification subjectNotification = subjectNotificationDAO.findOne(id);
		attachedFileService.delete(subjectNotification.getAttachedFile());
		subjectNotificationDAO.delete(id);
	}

}