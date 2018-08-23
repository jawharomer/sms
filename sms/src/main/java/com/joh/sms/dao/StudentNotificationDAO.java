package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentNotification;
import com.joh.sms.model.SubjectNotification;

public interface StudentNotificationDAO extends CrudRepository<StudentNotification, Integer> {
	List<StudentNotification> findAllByStudentId(int id);
}
