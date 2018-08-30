package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.Student;

public interface StudentDAO extends CrudRepository<Student, Integer> {

	@Query(value = "select S.* from STUDENTS S INNER JOIN  ENROLLMENTS E USING(I_STUDENT) WHERE E.I_CLASS_GROUP= ?1 ", nativeQuery = true)
	List<Student> findAllStudentByClassGroupId(int id);

	@Query(value = "SELECT S.* FROM STUDENTS S INNER JOIN\n" + "STUDENTNOTIFICAION_STUDENT SNS USING(I_STUDENT)\n"
			+ "INNER JOIN   STUDENT_NOTIFICATIONS SN USING(I_STUDENT_NOTIFICATION)\n"
			+ "WHERE I_STUDENT_NOTIFICATION=?1 ", nativeQuery = true)
	List<Student> findAllByNotificationId(int id);
	
	
	@Query(value = "SELECT  S.* FROM STUDENTS S\n" + 
			"INNER JOIN ENROLLMENTS E\n" + 
			"USING (I_STUDENT)\n" + 
			"WHERE I_CLASS_GROUP=?1 ", nativeQuery = true)
	List<Student> findAllByClassGroupId(int id);
}
