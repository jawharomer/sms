package com.joh.sms.dao;

import java.util.List;

import com.joh.sms.model.StudentLevel;

public interface StudentLevelDAOExt {


	List<StudentLevel> findAllSubjectStudentLevel(int studentLeveDateId, int classSubjectId, int classGroupId);
}
