package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassGroupTable;
import com.joh.sms.model.StudentSubjectMark;

public interface StudentSubjectMarkDAO extends CrudRepository<StudentSubjectMark, Integer>,StudentSubjectMarkDAOExt {
}
