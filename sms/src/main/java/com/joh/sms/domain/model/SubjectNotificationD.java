package com.joh.sms.domain.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class SubjectNotificationD {

	@NotNull()
	private Integer classGroupId;
	@NotNull()
	private Integer classSubjectId;
	@NotBlank(message="{subjectNotificationD.note.blank}")
	private String note;

	@NotBlank(message="{subjectNotificationD.note.blank}")
	private String title;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "SubjectNotificationD [classGroupId=" + classGroupId + ", classSubjectId=" + classSubjectId + ", note="
				+ note + ", title=" + title + "]";
	}

}
