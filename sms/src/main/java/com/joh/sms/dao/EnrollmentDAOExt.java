package com.joh.sms.dao;

import java.util.List;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.EnrollmentD;

public interface EnrollmentDAOExt {

	List<EnrollmentD> findAllEnrollment();
}
