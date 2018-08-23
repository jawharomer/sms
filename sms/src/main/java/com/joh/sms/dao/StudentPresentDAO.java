package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.StudentPresent;

public interface StudentPresentDAO extends CrudRepository<StudentPresent, Integer>, StudentPresentDAOExt {
	List<StudentPresent> findAllStudentPresentByStudentIdOrderByIdDesc(int id);
}
