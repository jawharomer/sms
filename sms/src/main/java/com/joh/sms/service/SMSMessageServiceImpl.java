package com.joh.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.SMSMessageDAO;
import com.joh.sms.model.SMSMessage;

@Service
public class SMSMessageServiceImpl implements SMSMessageService {

	@Autowired
	private SMSMessageDAO smsMessageDAO;

	@Override
	public Iterable<SMSMessage> findAll() {
		return smsMessageDAO.findAllByOrderByIdDesc();
	}

	@Override
	public SMSMessage save(SMSMessage smsMessage) {
		return smsMessageDAO.save(smsMessage);
	}

}
