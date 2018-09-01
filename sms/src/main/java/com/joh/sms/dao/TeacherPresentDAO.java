package com.joh.sms.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.TeacherPresent;

public interface TeacherPresentDAO extends CrudRepository<TeacherPresent, Integer> {
	List<TeacherPresent> findAllByDateBetweenOrderByDateDesc(Date from, Date to);
}
