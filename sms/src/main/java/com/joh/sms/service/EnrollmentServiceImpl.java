package com.joh.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.EnrollmentDAO;
import com.joh.sms.domain.model.EnrollmentD;
import com.joh.sms.model.Enrollment;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	private EnrollmentDAO enrollmentDAO;

	@Override
	public List<EnrollmentD> findAllEnrollment() {
		return enrollmentDAO.findAllEnrollment();
	}

	@Override
	public Enrollment save(Enrollment enrollment) {
		return enrollmentDAO.save(enrollment);
	}

	@Override
	public void delete(int id) {
		enrollmentDAO.delete(id);
	}

	@Override
	public Enrollment findOne(int id) {
		return enrollmentDAO.findOne(id);
	}

	@Override
	@Transactional
	public Enrollment update(Enrollment enrollment) {
		// This line will check this entity is exit
		// then it will update it
		enrollmentDAO.findOne(enrollment.getId());
		return enrollmentDAO.save(enrollment);
	}
	
	@Override
	public Enrollment findEnrollmentByStudentId(int studentId) {
		return enrollmentDAO.findEnrollmentByStudentId(studentId);
	}

}
