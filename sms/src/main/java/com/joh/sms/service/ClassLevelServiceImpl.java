package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassLevelDAO;
import com.joh.sms.model.ClassLevel;

@Service()
public class ClassLevelServiceImpl implements ClassLevelService {

	@Autowired
	private ClassLevelDAO classLevelDAO;

	@Override
	public ClassLevel findOne(int id) {
		return classLevelDAO.findOne(id);
	}

	@Override
	public Iterable<ClassLevel> findAll() {
		return classLevelDAO.findAll();
	}

	@Override
	@Transactional
	public ClassLevel save(ClassLevel classLevel) {
		return classLevelDAO.save(classLevel);
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		classLevelDAO.delete(id);
	}

	@Override
	@Transactional
	public ClassLevel update(ClassLevel classLevel) {
		// This line will check this student is exit
		// then it will update it
		classLevelDAO.findOne(classLevel.getId());
		return classLevelDAO.save(classLevel);
	}

	@Override
	public ClassLevel findClassLevelByStudentId(int id) {
		return classLevelDAO.findClassLevelByStudentId(id);
	}
}
