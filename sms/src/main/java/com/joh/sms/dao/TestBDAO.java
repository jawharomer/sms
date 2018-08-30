package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.TestA;
import com.joh.sms.model.TestB;

public interface TestBDAO  extends CrudRepository<TestB, Integer>{

}
