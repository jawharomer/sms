package com.joh.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.joh.sms.validator.TeacherPresentValidator;

@Entity
@Table(name = "TEACHER_PRESENT")
public class TeacherPresent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_TEACHER_PRESENT")
	private int id;

	@Valid()
	@NotNull(message = "{teacherPresent.teacher.null}", groups = { TeacherPresentValidator.insert.class })
	@ManyToOne()
	@JoinColumn(name = "I_TEACHER", nullable = false)
	private Teacher teacher;

	@NotNull(message = "{teacherPresent.date.null}", groups = { TeacherPresentValidator.insert.class })
	@Column(name = "PRESENT_DATE", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;

	@NotNull(message = "{teacherPresent.numberOfLectures.null}", groups = { TeacherPresentValidator.insert.class })
	@Column(name = "NUMBER_OF_LECTURES", nullable = false)
	private Integer numberOfLectures;

	@Column(name = "NOTE")
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumberOfLectures() {
		return numberOfLectures;
	}

	public void setNumberOfLectures(Integer numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "TeacherPresent [id=" + id + ", teacher=" + teacher + ", date=" + date + ", numberOfLectures="
				+ numberOfLectures + ", note=" + note + "]";
	}

}
