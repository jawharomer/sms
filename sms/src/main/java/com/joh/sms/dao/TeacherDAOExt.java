package com.joh.sms.dao;

import java.util.Date;
import java.util.List;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.TeacherLecturePresentD;

public interface TeacherDAOExt {


	List<TeacherLecturePresentD> findAllTeacherLecturePresent(Date from, Date to);
}
