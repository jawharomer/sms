package com.joh.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.StudentPresentDAO;
import com.joh.sms.domain.model.StudentPresentD;
import com.joh.sms.model.StudentPresent;

@Service()
public class StudentPresentServiceImpl implements StudentPresentService {

	@Autowired
	private StudentPresentDAO studentPresentDAO;

	@Override
	public List<StudentPresentD> findAllStudentPresentByClassGroupId(int id) {
		return studentPresentDAO.findAllStudentPresentByClassGroupId(id);
	}

	@Override
	@Transactional
	public Iterable<StudentPresent> save(Iterable<StudentPresent> entities) {
		return studentPresentDAO.save(entities);
	}

	@Override
	public List<StudentPresent> findAllStudentPresentByStudentIdOrderByIdDesc(int id) {
		return studentPresentDAO.findAllStudentPresentByStudentIdOrderByIdDesc(id);
	}

}
