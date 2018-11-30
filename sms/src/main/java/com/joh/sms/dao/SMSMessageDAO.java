package com.joh.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.SMSMessage;

public interface SMSMessageDAO extends CrudRepository<SMSMessage, Integer> {
	List<SMSMessage> findAllByOrderByIdDesc();

	@Query("SELECT M.* FROM SMSMessage WHERE S.isSet!=1")
	List<SMSMessage> findAllNotSentMessages();

	@Modifying
	@Query("UPDATE SMSMessage S SET isSent=1")
	void messageSent(int id);
}
