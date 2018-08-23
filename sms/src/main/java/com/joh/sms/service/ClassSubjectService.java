package com.joh.sms.service;

import com.joh.sms.model.ClassSubject;

public interface ClassSubjectService {

	Iterable<ClassSubject> findAllByClassLevelId(int id);

	ClassSubject save(ClassSubject classSubject);

	void delete(int id);

	ClassSubject findOne(int id);

	ClassSubject update(ClassSubject classSubject);

}
