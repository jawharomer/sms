package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.LessonTimeDAO;
import com.joh.sms.model.LessonTime;

@Service
public class LessonTimeServiceImpl implements LessonTimeService {

	@Autowired
	private LessonTimeDAO lessonTimeDAO;

	@Override
	public Iterable<LessonTime> findByClassLevelId(int id) {
		return lessonTimeDAO.findByClassLevelId(id);
	}

	@Override
	@Transactional
	public LessonTime save(LessonTime lessonTime) {
		return lessonTimeDAO.save(lessonTime);
	}

	@Override
	@Transactional
	public void delete(int id) {
		lessonTimeDAO.delete(id);
	}

	@Override
	public LessonTime findOne(int id) {
		return lessonTimeDAO.findOne(id);
	}

	@Override
	@Transactional
	public LessonTime update(LessonTime lessonTime) {
		// This line will check this student is exit
		// then it will update it
		lessonTimeDAO.findOne(lessonTime.getId());
		return lessonTimeDAO.save(lessonTime);
	}

}