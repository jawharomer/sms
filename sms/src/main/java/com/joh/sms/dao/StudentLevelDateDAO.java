package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.StudentLevelDate;

public interface StudentLevelDateDAO extends CrudRepository<StudentLevelDate, Integer> {
	Iterable<StudentLevelDate> findAllByOrderByIdDesc();
}
