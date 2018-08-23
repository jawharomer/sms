package com.joh.sms.dao;

import java.util.List;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.StudentSubjectMarkD;

public interface StudentSubjectMarkDAOExt {

	List<StudentSubjectMarkD> findAllStudentStudentSubjectMark(int studentId);

	List<StudentSubjectMarkD> findAllStudentSubjectMarkBySubjectIdAndGroupId(int subjectId, int classGroupId);
}
