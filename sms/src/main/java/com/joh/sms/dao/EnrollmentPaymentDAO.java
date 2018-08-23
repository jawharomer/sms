package com.joh.sms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.EnrollmentPayment;

public interface EnrollmentPaymentDAO extends CrudRepository<EnrollmentPayment, Integer> {
	Iterable<EnrollmentPayment> findByEnrollmentId(int id);
}
