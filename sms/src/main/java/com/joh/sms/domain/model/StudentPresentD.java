package com.joh.sms.domain.model;

public class StudentPresentD {
	private Integer studentPresentId;
	private Integer studentId;
	private String studentName;
	private Integer attendDays;
	private Integer absentDays;
	private boolean attend;

	public Integer getStudentPresentId() {
		return studentPresentId;
	}

	public void setStudentPresentId(Integer studentPresentId) {
		this.studentPresentId = studentPresentId;
	}

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

	public boolean isAttend() {
		return attend;
	}

	public void setAttend(boolean attend) {
		this.attend = attend;
	}

	@Override
	public String toString() {
		return "StudentPresentD [studentPresentId=" + studentPresentId + ", studentId=" + studentId + ", studentName="
				+ studentName + ", attendDays=" + attendDays + ", absentDays=" + absentDays + ", attend=" + attend
				+ "]";
	}

}
