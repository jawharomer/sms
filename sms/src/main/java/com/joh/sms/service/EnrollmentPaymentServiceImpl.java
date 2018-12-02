package com.joh.sms.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.EnrollmentPaymentDAO;
import com.joh.sms.model.EnrollmentPayment;

@Service
public class EnrollmentPaymentServiceImpl implements EnrollmentPaymentService {

	@Autowired
	private EnrollmentPaymentDAO enrollmentPaymentDAO;

	@Override
	public Iterable<EnrollmentPayment> findByEnrollmentId(int id) {
		return enrollmentPaymentDAO.findByEnrollmentId(id);
	}

	@Override
	@Transactional
	public EnrollmentPayment save(EnrollmentPayment enrollmentPayment) {
		return enrollmentPaymentDAO.save(enrollmentPayment);

	}

	@Override
	@Transactional
	public void delete(int id) {
		enrollmentPaymentDAO.delete(id);

	}

	@Override
	@Transactional
	public EnrollmentPayment update(EnrollmentPayment enrollmentPayment) {
		// This line will check this entity is exit
		// then it will update it
		enrollmentPaymentDAO.findOne(enrollmentPayment.getId());
		return enrollmentPaymentDAO.save(enrollmentPayment);
	}

	@Override
	public EnrollmentPayment findOne(int id) {
		return enrollmentPaymentDAO.findOne(id);
	}
	@Override
	public Iterable<EnrollmentPayment> findAllByTimeBetween(Date from,Date to) {
		return enrollmentPaymentDAO.findAllByTimeBetween(from, to);
	}
}
