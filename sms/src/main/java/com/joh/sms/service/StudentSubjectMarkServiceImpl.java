package com.joh.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassGroupTableDAO;
import com.joh.sms.dao.StudentSubjectMarkDAO;
import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.StudentSubjectMarkD;
import com.joh.sms.model.ClassGroupTable;
import com.joh.sms.model.LessonTime;
import com.joh.sms.model.StudentSubjectMark;

@Service
public class StudentSubjectMarkServiceImpl implements StudentSubjectMarkService {

	@Autowired
	private StudentSubjectMarkDAO studentSubjectMarkDAO;

	@Override
	public List<StudentSubjectMarkD> findAllStudentStudentSubjectMark(int studentId) {
		return studentSubjectMarkDAO.findAllStudentStudentSubjectMark(studentId);
	}

	@Override
	public StudentSubjectMark fineOne(int id) {
		return studentSubjectMarkDAO.findOne(id);
	}

	@Override
	@Transactional
	public StudentSubjectMark save(StudentSubjectMark studentSubjectMark) {
		return studentSubjectMarkDAO.save(studentSubjectMark);
	}

	@Override
	@Transactional
	public StudentSubjectMark update(StudentSubjectMark studentSubjectMark) {
		// This line will check this student is exit
		// then it will update it
		studentSubjectMarkDAO.findOne(studentSubjectMark.getId());
		return studentSubjectMarkDAO.save(studentSubjectMark);
	}

	@Override
	public List<StudentSubjectMarkD> findAllStudentSubjectMarkBySubjectIdAndGroupId(int subjectId,int classGroupId) {
		return studentSubjectMarkDAO.findAllStudentSubjectMarkBySubjectIdAndGroupId(subjectId, classGroupId);
	}

}
