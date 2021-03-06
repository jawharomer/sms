package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.SchoolWeekDay;

public interface SchoolWeekDayDAO extends CrudRepository<SchoolWeekDay, Integer> {
	Iterable<SchoolWeekDay> findAllByOrderById();
}
