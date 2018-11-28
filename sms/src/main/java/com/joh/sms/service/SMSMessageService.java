package com.joh.sms.service;

import com.joh.sms.model.SMSMessage;

public interface SMSMessageService {

	Iterable<SMSMessage> findAll();

	SMSMessage save(SMSMessage smsMessage);


}
