package com.joh.sms.dao;

import java.util.List;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.EnrollmentD;
import com.joh.sms.domain.model.StudentPresentD;

public interface StudentPresentDAOExt {

	List<StudentPresentD> findAllStudentPresentByClassGroupId(int id);
}
