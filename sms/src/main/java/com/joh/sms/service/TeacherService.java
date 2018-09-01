package com.joh.sms.service;

import java.util.Date;
import java.util.List;

import com.joh.sms.domain.model.TeacherLecturePresentD;
import com.joh.sms.model.Teacher;

public interface TeacherService {

	Iterable<Teacher> findAll();

	Teacher save(Teacher teacher);

	void delete(int id);

	Teacher findOne(int id);

	Teacher update(Teacher teacher);

	List<TeacherLecturePresentD> findAllTeacherLecturePresent(Date from, Date to);

}
