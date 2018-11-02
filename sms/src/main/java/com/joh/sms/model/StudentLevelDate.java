package com.joh.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STUDENT_LEVEL_DATES")
public class StudentLevelDate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_STUDENT_LEVEL_DATE")
	private Integer id;

	@NotNull(message = "{StudentLevelDate.date.null}")
	@Column(name = "STUDENT_LEVEL_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "StudentLevelDate [id=" + id + ", date=" + date + "]";
	}

}
