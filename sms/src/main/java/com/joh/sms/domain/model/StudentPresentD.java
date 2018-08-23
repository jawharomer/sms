package com.joh.sms.domain.model;

public class StudentPresentD {

	private Integer studentId;
	private String studentName;
	private Integer attendDays;
	private Integer absentDays;
	private boolean attent;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getAttendDays() {
		return attendDays;
	}

	public void setAttendDays(Integer attendDays) {
		this.attendDays = attendDays;
	}

	public Integer getAbsentDays() {
		return absentDays;
	}

	public void setAbsentDays(Integer absentDays) {
		this.absentDays = absentDays;
	}

	public boolean isAttent() {
		return attent;
	}

	public void setAttent(boolean attent) {
		this.attent = attent;
	}

	@Override
	public String toString() {
		return "StudentPresentD [studentId=" + studentId + ", studentName=" + studentName + ", attendDays=" + attendDays
				+ ", absentDays=" + absentDays + ", attent=" + attent + "]";
	}

}
