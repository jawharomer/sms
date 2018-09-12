package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassGroupDAO;
import com.joh.sms.model.ClassGroup;

@Service
public class ClassGroupServiceImpl implements ClassGroupService {

	@Autowired
	private ClassGroupDAO classGroupDAO;

	@Override
	public Iterable<ClassGroup> findAll() {
		return classGroupDAO.findAll();
	}

	@Override
	public Iterable<ClassGroup> findByClassLevelId(int id) {
		return classGroupDAO.findByClassLevelId(id);
	}

	@Override
	@Transactional
	public ClassGroup save(ClassGroup classGroup) {
		return classGroupDAO.save(classGroup);
	}

	@Override
	@Transactional
	public void delete(int id) {
		classGroupDAO.delete(id);
	}

	@Override
	public ClassGroup findOne(int id) {
		return classGroupDAO.findOne(id);
	}

	@Override
	@Transactional
	public ClassGroup update(ClassGroup classGroup) {
		// This line will check this student is exit
		// then it will update it
		classGroupDAO.findOne(classGroup.getId());
		return classGroupDAO.save(classGroup);
	}

	@Override
	public ClassGroup findByStudentId(int id) {
		return classGroupDAO.findByStudentId(id);
	}

	

}