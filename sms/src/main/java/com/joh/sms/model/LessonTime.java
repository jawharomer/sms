package com.joh.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "LESSON_TIMES")
public class LessonTime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_LESSON_TIME")
	private int id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+3")
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	@Column(name = "LESSON_TIME", nullable = false)
	private Date time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_CLASS_LEVEL", updatable = false)
	private ClassLevel classLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public ClassLevel getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(ClassLevel classLevel) {
		this.classLevel = classLevel;
	}

	@Override
	public String toString() {
		return "LessonTime [id=" + id + ", time=" + time + "]";
	}

}
