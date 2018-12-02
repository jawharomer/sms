package com.joh.sms.dao;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.EnrollmentPayment;

public interface EnrollmentPaymentDAO extends CrudRepository<EnrollmentPayment, Integer> {
	Iterable<EnrollmentPayment> findByEnrollmentId(int id);

	Iterable<EnrollmentPayment> findAllByTimeBetween(Date from, Date to);
}
