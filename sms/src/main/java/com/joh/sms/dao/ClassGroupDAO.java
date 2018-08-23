package com.joh.sms.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassGroup;

public interface ClassGroupDAO extends CrudRepository<ClassGroup, Integer> {
	Iterable<ClassGroup> findByClassLevelId(int id);

	@Query(value = "SELECT CG.*\n" + "FROM STUDENTS S \n" + "INNER JOIN ENROLLMENTS E USING(I_STUDENT)\n"
			+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_GROUP)\n" + "WHERE S.I_STUDENT= ?1 ;", nativeQuery = true)
	ClassGroup findByStudentId(int id);
}
