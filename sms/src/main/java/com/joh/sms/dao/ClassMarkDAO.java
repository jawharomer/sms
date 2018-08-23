package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassMark;

public interface ClassMarkDAO extends CrudRepository<ClassMark, Integer> {
	Iterable<ClassMark> findByClassLevelId(int id);
}
