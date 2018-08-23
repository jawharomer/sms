package com.joh.sms.service;

import com.joh.sms.model.ClassMark;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.Student;

public interface ClassMarkService {
	
	ClassMark update(ClassMark classMark);

	Iterable<ClassMark> findByClassLevelId(int id);

	ClassMark save(ClassMark classMark);

	void delete(int id);

	ClassMark findOne(int id);

}
