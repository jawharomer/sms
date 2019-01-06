package com.joh.sms.domain.model;

import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class StudentNotificaionD {

	@NotNull(message = "{studentNotificaionD.studentIds.null}")
	@Size(min = 0, message = "{StudentNotificaionD.studentIds.size}")
	private Integer[] studentIds;
	@NotBlank(message = "{studentNotificaionD.title.blank}")
	private String title;
	@NotBlank(message = "{studentNotificaionD.note.blank}")
	@Length(min=1,max=65535,message="{studentNotificaionD.note.length}")
	private String note;

	public Integer[] getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(Integer[] studentIds) {
		this.studentIds = studentIds;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "StudentNotificaionD [studentIds=" + Arrays.toString(studentIds) + ", title=" + title + ", note=" + note
				+ "]";
	}

}
