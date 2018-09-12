package com.joh.sms.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassLevel;

public interface ClassLevelDAO extends CrudRepository<ClassLevel, Integer> {

	@Query(value = "SELECT CL.*\n" + "FROM STUDENTS S \n" + "INNER JOIN ENROLLMENTS E USING(I_STUDENT)\n"
			+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_GROUP)\n" + "INNER JOIN CLASS_LEVELS CL USING(I_CLASS_LEVEL)\n"
			+ "WHERE S.I_STUDENT= ?1 ;", nativeQuery = true)
	ClassLevel findClassLevelByStudentId(int id);
}
