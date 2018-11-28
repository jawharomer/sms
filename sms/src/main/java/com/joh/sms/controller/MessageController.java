package com.joh.sms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joh.sms.domain.model.ModemStatus;
import com.joh.sms.model.SMSMessage;
import com.joh.sms.service.MessageService;
import com.joh.sms.service.SMSMessageService;

@Controller()
@RequestMapping(path = "/messages")
public class MessageController {

	private static final Logger logger = Logger.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private SMSMessageService smsMessageService;

	@GetMapping()
	public String getModemStatus(Model model) {
		logger.info("getModemStatus->fired");
		ModemStatus modemStatus = messageService.getModemStatus();
		logger.info("modemStatus=" + modemStatus);
		model.addAttribute("modemStatus", modemStatus);

		Iterable<SMSMessage> smsMessages = smsMessageService.findAll();
		logger.info("smsMessages=" + smsMessages);
		model.addAttribute("smsMessages", smsMessages);

		return "modemStatus";
	}

	@GetMapping(path = "/balance/add")
	public String getAddingBalance(Model model) {
		logger.info("getAddingBalance->fired");

		return "/message/addBalance";
	}

	@PostMapping(path = "/balance/add")
	@ResponseBody()
	public String addBalance(@RequestParam String cardNumber) {
		logger.info("getAddingBalance->fired");
		logger.info("cardNumber=" + cardNumber);
		String result = messageService.addBalance(cardNumber);
		return result;
	}
}
