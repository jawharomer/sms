package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.Student;
import com.joh.sms.model.SubjectNotification;

public interface SubjectNotificationDAO extends CrudRepository<SubjectNotification, Integer> {
	List<SubjectNotification> findAllByClassSubjectIdAndClassGroupIdOrderByIdDesc(int classSubjectId, int classGroupId);
}
