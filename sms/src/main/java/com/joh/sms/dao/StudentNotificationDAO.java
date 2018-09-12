package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.StudentNotification;

public interface StudentNotificationDAO extends CrudRepository<StudentNotification, Integer> {

	@Query("SELECT SN FROM StudentNotification SN JOIN FETCH SN.students S WHERE S.id=?1 ")
	List<StudentNotification> findAllByStudentId(int id);
	
	

}
