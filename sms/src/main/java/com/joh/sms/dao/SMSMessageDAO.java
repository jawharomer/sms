package com.joh.sms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.SMSMessage;

public interface SMSMessageDAO extends JpaRepository<SMSMessage, Integer> {
	List<SMSMessage> findAllByOrderByIdDesc();

	@Query(value = "SELECT * FROM SMS_MESSAGES S WHERE S.SENT!=1", nativeQuery = true)
	List<SMSMessage> findAllNotSentMessages();

	@Transactional
	@Modifying
	@Query("UPDATE SMSMessage S SET isSent=1 WHERE id=? ")
	void messageSent(int id);
}
