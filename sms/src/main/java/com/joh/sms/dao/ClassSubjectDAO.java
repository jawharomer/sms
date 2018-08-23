package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassSubject;

public interface ClassSubjectDAO extends CrudRepository<ClassSubject, Integer> {
	Iterable<ClassSubject> findAllByClassLevelId(int id);
}
