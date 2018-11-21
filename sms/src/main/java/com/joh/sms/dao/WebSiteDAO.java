package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.WebSite;

public interface WebSiteDAO extends CrudRepository<WebSite, Integer> {

	WebSite findFirstByOrderById();
}
