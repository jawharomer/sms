package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.StudentLevel;

public interface StudentLevelDAO extends CrudRepository<StudentLevel, Integer>, StudentLevelDAOExt {

	Iterable<StudentLevel> findAllByStudentIdAndStudentLevelDateIdOrderByClassSubjectId(int id, int studentLevelDateId);
    List<StudentLevel> findAllByStudentLevelDateId(int id);
}
