package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.LessonTime;

public interface LessonTimeDAO extends CrudRepository<LessonTime, Integer> {
	Iterable<LessonTime> findByClassLevelId(int id);
}
