package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassSubjectDAO;
import com.joh.sms.model.ClassSubject;

@Service
public class ClassSubjectServiceImpl implements ClassSubjectService {

	@Autowired
	private ClassSubjectDAO classSubjectDAO;

	@Override
	public Iterable<ClassSubject> findAllByClassLevelId(int id) {
		return classSubjectDAO.findAllByClassLevelId(id);
	}

	@Override
	@Transactional
	public ClassSubject save(ClassSubject classSubject) {
		return classSubjectDAO.save(classSubject);
	}

	@Override
	@Transactional
	public void delete(int id) {
		classSubjectDAO.delete(id);
	}

	@Override
	public ClassSubject findOne(int id) {
		return classSubjectDAO.findOne(id);
	}

	@Override
	@Transactional
	public ClassSubject update(ClassSubject classSubject) {
		// This line will check this student is exit
		// then it will update it
		classSubjectDAO.findOne(classSubject.getId());
		return classSubjectDAO.save(classSubject);
	}

}