package com.joh.sms.service;

import com.joh.sms.model.LessonTime;

public interface LessonTimeService {

	LessonTime save(LessonTime lessonTime);

	void delete(int id);

	LessonTime findOne(int id);

	LessonTime update(LessonTime lessonTime);

	Iterable<LessonTime> findByClassLevelId(int id);

}
