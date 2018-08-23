package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassLevelDAO;
import com.joh.sms.dao.SchoolWeekDayDAO;
import com.joh.sms.model.ClassLevel;
import com.joh.sms.model.SchoolWeekDay;
import com.joh.sms.model.Teacher;

@Service()
public class SchoolWeekDayServiceImpl implements SchoolWeekDayService {

	@Autowired
	private SchoolWeekDayDAO schoolWeekDayDAO;

	@Override
	public SchoolWeekDay findOne(int id) {
		return schoolWeekDayDAO.findOne(id);
	}

	@Override
	public Iterable<SchoolWeekDay> findAll() {
		return schoolWeekDayDAO.findAll();
	}

	@Override
	@Transactional
	public SchoolWeekDay save(SchoolWeekDay schoolWeekDay) {
		return schoolWeekDayDAO.save(schoolWeekDay);
	}

	@Override
	@Transactional
	public void delete(int id) {
		schoolWeekDayDAO.delete(id);
	}

	@Override
	@Transactional
	public SchoolWeekDay update(SchoolWeekDay schoolWeekDay) {
		// This line will check this student is exit
		// then it will update it
		schoolWeekDayDAO.findOne(schoolWeekDay.getId());
		return schoolWeekDayDAO.save(schoolWeekDay);
	}
}
