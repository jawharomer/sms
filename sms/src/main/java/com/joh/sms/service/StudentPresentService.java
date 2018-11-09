package com.joh.sms.service;

import java.util.Date;
import java.util.List;

import com.joh.sms.domain.model.StudentPresentD;
import com.joh.sms.model.StudentPresent;

public interface StudentPresentService {

	List<StudentPresentD> findAllStudentPresentByClassGroupId(int id);

	Iterable<StudentPresent> save(Iterable<StudentPresent> entities);

	List<StudentPresent> findAllStudentPresentByStudentIdOrderByIdDesc(int id);

	List<Date> findAllClassGroupPresents(int id);

	List<StudentPresentD> findAllStudentPresentByClassGroupIdAndPresentDate(int id, Date date);

	void update(List<StudentPresent> studentPresents);

	void deleteClassGroupPresent(int id, Date date);

}
