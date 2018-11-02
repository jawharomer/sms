package com.joh.sms.service;

import com.joh.sms.model.StudentLevelDate;

public interface StudentLevelDateService {

	StudentLevelDate save(StudentLevelDate studentLevelDate);

	Iterable<StudentLevelDate> findAll();

	void delete(int id);

	StudentLevelDate findOne(int id);

}
