package com.joh.sms.service;

import java.util.List;

import com.joh.sms.domain.model.EnrollmentD;
import com.joh.sms.model.Enrollment;

public interface EnrollmentService {

	List<EnrollmentD> findAllEnrollment();

	Enrollment save(Enrollment enrollment);

	void delete(int id);

	Enrollment findOne(int id);

	Enrollment update(Enrollment enrollment);

	Enrollment findEnrollmentByStudentId(int studentId);

}
