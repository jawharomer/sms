package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.SMSMessage;

public interface SMSMessageDAO extends CrudRepository<SMSMessage, Integer> {
	List<SMSMessage> findAllByOrderByIdDesc();
}
