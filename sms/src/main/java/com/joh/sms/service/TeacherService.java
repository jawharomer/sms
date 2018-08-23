package com.joh.sms.service;

import com.joh.sms.model.Teacher;

public interface TeacherService {

	Iterable<Teacher> findAll();

	Teacher save(Teacher teacher);

	void delete(int id);

	Teacher findOne(int id);

	Teacher update(Teacher teacher);

}
