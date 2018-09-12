package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.StudentLevel;
import com.joh.sms.model.StudentPresent;

public interface StudentLevelDAO extends CrudRepository<StudentLevel, Integer>, StudentLevelDAOExt {

	Iterable<StudentLevel> findAllByStudentIdOrderByClassSubjectId(int id);
}
