package com.joh.sms.service;

import java.util.List;

import com.joh.sms.domain.model.StudentPresentD;
import com.joh.sms.model.Student;

public interface StudentService {

	Iterable<Student> findAllStudent();

	Student save(Student student);

	void delete(int id);

	Student findOne(int id);

	void update(Student student);

}
