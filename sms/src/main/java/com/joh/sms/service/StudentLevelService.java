package com.joh.sms.service;

import java.util.List;

import com.joh.sms.model.StudentLevel;

public interface StudentLevelService {

	StudentLevel findOne(int id);

	StudentLevel save(StudentLevel studentLevel);

	Iterable<StudentLevel> findAllByStudentId(int id);

	List<StudentLevel> findAllSubjectStudentLevel(int studentLevelDateId, int classSubjectId, int classGroupId);
}
