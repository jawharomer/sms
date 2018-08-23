package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.Student;

public interface StudentDAO extends CrudRepository<Student, Integer> {

	@Query(value = "select S.* from STUDENTS S INNER JOIN  ENROLLMENTS E USING(I_STUDENT) WHERE E.I_CLASS_GROUP= ?1 ", nativeQuery = true)
	List<Student> findAllStudentByClassGroupId(int id);
}
