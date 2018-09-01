package com.joh.sms.service;

import java.util.Date;
import java.util.List;

import com.joh.sms.model.TeacherPresent;

public interface TeacherPresentService {

	TeacherPresent save(TeacherPresent teacherPresent);

	List<TeacherPresent> findAllByDateBetweenOrderByDateDesc(Date from, Date to);

	void delete(int id);
}
