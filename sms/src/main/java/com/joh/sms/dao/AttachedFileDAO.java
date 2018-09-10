package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.AttachedFile;

public interface AttachedFileDAO extends CrudRepository<AttachedFile, Integer> {

}
