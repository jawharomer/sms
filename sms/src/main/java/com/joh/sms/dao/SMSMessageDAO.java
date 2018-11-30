package com.joh.sms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.SMSMessage;

public interface SMSMessageDAO extends CrudRepository<SMSMessage, Integer> {
	List<SMSMessage> findAllByOrderByIdDesc();

	@Query("SELECT S FROM SMSMessage S WHERE isSent!=1")
	List<SMSMessage> findAllNotSentMessages();

	@Transactional
	@Modifying
	@Query("UPDATE SMSMessage S SET isSent=1 WHERE id=? ")
	void messageSent(int id);
}
