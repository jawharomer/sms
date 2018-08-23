package com.joh.sms.domain.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class EnrollmentD {

	private Integer enrollmentId;
	private String studentName;
	private String groupName;

	private double fee;
	private String note;
	@NotNull(message = "{enrollmentD.studentId.null}")
	private Integer studentId;
	@NotNull(message = "{enrollmentD.classGroupId.null}")
	private Integer classGroupId;

	public Integer getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassGroupId() {
		return classGroupId;
	}

	public void setClassGroupId(Integer classGroupId) {
		this.classGroupId = classGroupId;
	}

	@Override
	public String toString() {
		return "EnrollmentD [enrollmentId=" + enrollmentId + ", studentName=" + studentName + ", groupName=" + groupName
				+ ", fee=" + fee + ", note=" + note + ", studentId=" + studentId + ", classGroupId=" + classGroupId
				+ "]";
	}

}
