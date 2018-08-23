package com.joh.sms.domain.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class StudentSubjectMarkD {
	private Integer studentSubjectMarkId;

	private String studentName;
	private String subjectName;
	private String markName;
	private Double markLimit;

	@NotNull(message = "{studentSubjectMark.mark.null}")
	private Double mark;

	@NotNull(message = "{studentSubjectMark.studentId.null}")
	private Integer studentId;

	@NotNull(message = "{studentSubjectMark.classMarkId.null}")
	private Integer classMarkId;

	@NotNull(message = "{studentSubjectMark.classSubjectId.null}")
	private Integer classSubjectId;

	public Integer getStudentSubjectMarkId() {
		return studentSubjectMarkId;
	}

	public void setStudentSubjectMarkId(Integer studentSubjectMarkId) {
		this.studentSubjectMarkId = studentSubjectMarkId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public Double getMarkLimit() {
		return markLimit;
	}

	public void setMarkLimit(Double markLimit) {
		this.markLimit = markLimit;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassMarkId() {
		return classMarkId;
	}

	public void setClassMarkId(Integer classMarkId) {
		this.classMarkId = classMarkId;
	}

	public Integer getClassSubjectId() {
		return classSubjectId;
	}

	public void setClassSubjectId(Integer classSubjectId) {
		this.classSubjectId = classSubjectId;
	}

	@Override
	public String toString() {
		return "StudentSubjectMarkD [studentSubjectMarkId=" + studentSubjectMarkId + ", studentName=" + studentName
				+ ", subjectName=" + subjectName + ", markName=" + markName + ", markLimit=" + markLimit + ", mark="
				+ mark + ", studentId=" + studentId + ", classMarkId=" + classMarkId + ", classSubjectId="
				+ classSubjectId + "]";
	}

}
