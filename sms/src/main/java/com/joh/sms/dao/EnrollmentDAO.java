package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.Enrollment;

public interface EnrollmentDAO extends CrudRepository<Enrollment, Integer>, EnrollmentDAOExt {
	Enrollment findEnrollmentByStudentId(int id);
}
