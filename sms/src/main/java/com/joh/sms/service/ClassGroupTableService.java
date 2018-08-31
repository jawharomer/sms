package com.joh.sms.service;

import java.util.List;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.model.ClassGroupTable;

public interface ClassGroupTableService {

	List<ClassGroupTableD> findAllClassGroupTable(int id);

	ClassGroupTable save(ClassGroupTable classGroupTable);

	List<ClassGroupTableD> findAllTeacherClassGroupSubject(int teacherId);

	void delete(int id);

	List<ClassGroupTableD> findTeacherClassGroupTable(int teacherId);

}
