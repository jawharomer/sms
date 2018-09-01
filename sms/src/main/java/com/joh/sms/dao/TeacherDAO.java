package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.Teacher;

public interface TeacherDAO extends CrudRepository<Teacher, Integer>, TeacherDAOExt {

}
