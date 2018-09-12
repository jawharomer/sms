package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "SCHOOL_WEEK_DAYS")
public class SchoolWeekDay {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_SCHOOL_WEEK_DAY")
	private int id;

	@NotBlank(message = "{schoolWeekDay.weekDay.blank}")
	@Column(name = "WEEK_DAY", nullable = false, unique = true)
	private String weekDay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	@Override
	public String toString() {
		return "SchoolWeekDay [id=" + id + ", weekDay=" + weekDay + "]";
	}

}
