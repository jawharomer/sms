package com.joh.sms.service;

import java.util.List;

import com.joh.sms.domain.model.StudentPresentD;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentPresent;

public interface StudentPresentService {

	List<StudentPresentD> findAllStudentPresentByClassGroupId(int id);

	Iterable<StudentPresent> save(Iterable<StudentPresent> entities);

	List<StudentPresent> findAllStudentPresentByStudentIdOrderByIdDesc(int id);

}
