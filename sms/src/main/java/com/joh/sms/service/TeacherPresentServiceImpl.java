package com.joh.sms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.TeacherPresentDAO;
import com.joh.sms.model.TeacherPresent;

@Service
public class TeacherPresentServiceImpl implements TeacherPresentService {
	@Autowired
	private TeacherPresentDAO teacherPresentDAO;

	@Override
	public TeacherPresent save(TeacherPresent teacherPresent) {
		return teacherPresentDAO.save(teacherPresent);
	}

	@Override
	public List<TeacherPresent> findAllByDateBetweenOrderByDateDesc(Date from, Date to) {
		return teacherPresentDAO.findAllByDateBetweenOrderByDateDesc(from, to);
	}

	@Override
	public void delete(int id) {
		teacherPresentDAO.delete(id);
	}

}
