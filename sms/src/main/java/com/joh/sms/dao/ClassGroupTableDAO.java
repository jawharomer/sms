package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.ClassGroupTable;

public interface ClassGroupTableDAO extends CrudRepository<ClassGroupTable, Integer>, ClassGroupTableDAOExt {

}
