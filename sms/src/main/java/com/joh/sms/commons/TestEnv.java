package com.joh.sms.commons;

import com.joh.sms.model.AcademicYear;

public class TestEnv {
	public static AcademicYear acadimicYear() {
		AcademicYear academicYear = new AcademicYear();
		academicYear.setName("2017-2018");
		academicYear.setId(1);
		return academicYear;
	}
}
