package com.joh.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.StudentDAO;
import com.joh.sms.model.Student;

@Service()
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private AttachedFileService attachedFileService;

	@Override
	public Iterable<Student> findAllStudent() {
		return studentDAO.findAll();

	}

	@Override
	@Transactional
	public Student save(Student student) {

		return studentDAO.save(student);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Student student = studentDAO.findOne(id);
		if (student.getAttachedFile() != null) {
			attachedFileService.delete(student.getAttachedFile());
		}
		studentDAO.delete(id);
	}

	@Override
	public Student findOne(int id) {
		return studentDAO.findOne(id);
	}

	@Override
	@Transactional
	public void update(Student student) {
		// This line will check this student is exit
		// then it will update it
		studentDAO.findOne(student.getId());
		studentDAO.save(student);
	}

	@Override
	public List<Student> findAllByNotificationId(int id) {
		return studentDAO.findAllByNotificationId(id);
	}

	@Override
	public List<Student> findAllByClassGroupId(int id) {
		return studentDAO.findAllByClassGroupId(id);
	}

}
