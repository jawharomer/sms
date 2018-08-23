package com.joh.sms.service;

import com.joh.sms.model.ClassLevel;

public interface ClassLevelService {
	Iterable<ClassLevel> findAll();

	ClassLevel save(ClassLevel classLevel);

	void delete(int id);

	ClassLevel findOne(int id);

	ClassLevel update(ClassLevel classLevel);

	ClassLevel findClassLevelByStudentId(int id);

}
