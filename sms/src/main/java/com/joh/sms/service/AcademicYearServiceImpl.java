package com.joh.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.AcademicYearDAO;
import com.joh.sms.model.AcademicYear;

@Service
public class AcademicYearServiceImpl implements AcademicYearService {

	@Autowired
	private AcademicYearDAO academicYearDAO;

	@Override
	@Transactional
	public AcademicYear save(AcademicYear academicYear) {
		return academicYearDAO.save(academicYear);
	}

}
