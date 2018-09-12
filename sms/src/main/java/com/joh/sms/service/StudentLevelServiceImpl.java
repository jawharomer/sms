package com.joh.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.StudentLevelDAO;
import com.joh.sms.model.StudentLevel;

@Service
public class StudentLevelServiceImpl implements StudentLevelService {

	@Autowired
	private StudentLevelDAO studentLevelDAO;

	@Override
	public List<StudentLevel> findAllSubjectStudentLevel(int classSubjectId,int classGroupId) {
		return studentLevelDAO.findAllSubjectStudentLevel(classSubjectId,classGroupId);
	}

	@Override
	public StudentLevel findOne(int id) {
		return studentLevelDAO.findOne(id);
	}
	
	@Override
	public StudentLevel save(StudentLevel studentLevel) {
		return studentLevelDAO.save(studentLevel);
	}
	
	
	@Override
	public Iterable<StudentLevel> findAllByStudentId(int id) {
		return studentLevelDAO.findAllByStudentIdOrderByClassSubjectId(id);
	}

}
