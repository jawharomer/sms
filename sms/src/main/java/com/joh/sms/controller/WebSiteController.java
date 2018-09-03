package com.joh.sms.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(path = "/site")
public class WebSiteController {
	private static final Logger logger = Logger.getLogger(WebSiteController.class);

	@GetMapping
	public String getWebSite() {
		return "webSiteRoot";
	}
}
