package com.joh.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ACADEMIC_YEARS")
public class AcademicYear {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_ACADEMIC_YEAR")
	private int id;

	@Column(name = "YEAR_NAME")
	private String name;

	@Column(name = "INSERT_DATE", insertable = true, updatable = false)
	@CreationTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	private Date insertDate;

	public AcademicYear() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public String toString() {
		return "AcademicYear [id=" + id + ", name=" + name + ", insertDate=" + insertDate + "]";
	}

}
