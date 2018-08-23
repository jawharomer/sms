package com.joh.sms.dao;

import java.util.List;

import com.joh.sms.domain.model.ClassGroupTableD;

public interface ClassGroupTableDAOExt {

	List<ClassGroupTableD> findAllClassGroupTable(int classGroupId);

	List<ClassGroupTableD> findAllTeacherClassGroupSubject(int teacherId);
}
