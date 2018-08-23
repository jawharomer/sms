package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.TeacherDAO;
import com.joh.sms.model.Student;
import com.joh.sms.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	@Transactional
	public Teacher save(Teacher teacher) {

		return teacherDAO.save(teacher);
	}

	@Override
	public Iterable<Teacher> findAll() {
		return teacherDAO.findAll();

	}

	@Override
	@Transactional
	public void delete(int id) {
		teacherDAO.delete(id);
	}

	@Override
	public Teacher findOne(int id) {
		return teacherDAO.findOne(id);
	}

	@Override
	public Teacher update(Teacher teacher) {
		// This line will check this student is exit
		// then it will update it
		teacherDAO.findOne(teacher.getId());
		return teacherDAO.save(teacher);
	}

}
