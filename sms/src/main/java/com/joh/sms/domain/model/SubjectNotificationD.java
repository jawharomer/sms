package com.joh.sms.domain.model;

import javax.validation.constraints.NotNull;

public class SubjectNotificationD {

	@NotNull
	private Integer classGroupId;
	@NotNull
	private Integer classSubjectId;
	@NotNull()
	private String note;

	public Integer getClassGroupId() {
		return classGroupId;
	}

	public void setClassGroupId(Integer classGroupId) {
		this.classGroupId = classGroupId;
	}

	public Integer getClassSubjectId() {
		return classSubjectId;
	}

	public void setClassSubjectId(Integer classSubjectId) {
		this.classSubjectId = classSubjectId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "SubjectNotificationD [classGroupId=" + classGroupId + ", classSubjectId=" + classSubjectId + ", note="
				+ note + "]";
	}

}
