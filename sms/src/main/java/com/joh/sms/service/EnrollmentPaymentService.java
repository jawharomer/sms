package com.joh.sms.service;

import com.joh.sms.model.EnrollmentPayment;

public interface EnrollmentPaymentService {
	Iterable<EnrollmentPayment> findByEnrollmentId(int id);

	EnrollmentPayment save(EnrollmentPayment enrollmentPayment);

	void delete(int id);

	EnrollmentPayment findOne(int id);

	EnrollmentPayment update(EnrollmentPayment enrollmentPayment);

}
