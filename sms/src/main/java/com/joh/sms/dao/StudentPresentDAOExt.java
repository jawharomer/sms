package com.joh.sms.dao;

import java.util.Date;
import java.util.List;

import com.joh.sms.domain.model.StudentPresentD;

public interface StudentPresentDAOExt {

	List<StudentPresentD> findAllStudentPresentByClassGroupId(int id);

	List<Date> findAllClassGroupPresents(int id);

	List<StudentPresentD> findAllStudentPresentByClassGroupIdAndPresentDate(int id, Date date);

	void deleteClassGroupPresent(int id, Date date);
}
