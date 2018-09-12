package com.joh.sms.service;

import java.util.List;

import com.joh.sms.domain.model.StudentSubjectMarkD;
import com.joh.sms.model.StudentSubjectMark;

public interface StudentSubjectMarkService {

	List<StudentSubjectMarkD> findAllStudentStudentSubjectMark(int studentId);

	StudentSubjectMark save(StudentSubjectMark studentSubjectMark);

	StudentSubjectMark fineOne(int id);

	StudentSubjectMark update(StudentSubjectMark studentSubjectMark);

	List<StudentSubjectMarkD> findAllStudentSubjectMarkBySubjectIdAndGroupId(int classSubjectId, int classGroupId);

}
