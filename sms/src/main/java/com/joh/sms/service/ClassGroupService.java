package com.joh.sms.service;

import com.joh.sms.model.ClassGroup;

public interface ClassGroupService {

	ClassGroup update(ClassGroup classGroup);

	ClassGroup findOne(int id);

	void delete(int id);

	ClassGroup save(ClassGroup classGroup);

	Iterable<ClassGroup> findByClassLevelId(int id);

	Iterable<ClassGroup> findAll();

	ClassGroup findByStudentId(int id);

}
