package com.joh.sms.service;

import com.joh.sms.model.SchoolWeekDay;

public interface SchoolWeekDayService {

	SchoolWeekDay findOne(int id);

	Iterable<SchoolWeekDay> findAll();

	SchoolWeekDay save(SchoolWeekDay schoolWeekDay);

	void delete(int id);

	SchoolWeekDay update(SchoolWeekDay schoolWeekDay);

}
