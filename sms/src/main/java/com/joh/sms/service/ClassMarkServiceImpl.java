package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassMarkDAO;
import com.joh.sms.dao.ClassSubjectDAO;
import com.joh.sms.model.AcademicYear;
import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.ClassMark;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.Student;

@Service
public class ClassMarkServiceImpl implements ClassMarkService {

	@Autowired
	private ClassMarkDAO classMarkDAO;

	@Override
	public Iterable<ClassMark> findByClassLevelId(int id) {
		return classMarkDAO.findByClassLevelId(id);
	}

	@Override
	@Transactional
	public ClassMark save(ClassMark classMark) {
		return classMarkDAO.save(classMark);
	}

	@Override
	@Transactional
	public void delete(int id) {
		classMarkDAO.delete(id);
	}

	@Override
	public ClassMark findOne(int id) {
		return classMarkDAO.findOne(id);
	}

	@Override
	@Transactional
	public ClassMark update(ClassMark classMark) {
		// This line will check this student is exit
		// then it will update it
		classMarkDAO.findOne(classMark.getId());
		return classMarkDAO.save(classMark);
	}

}