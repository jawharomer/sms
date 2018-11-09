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
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "STUDENT_PRESENTS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "I_STUDENT", "PRESENT_DATE" }) })
public class StudentPresent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_STUDENT_PRESENT")
	private Integer id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "PRESENT_DATE", nullable = false, updatable = false)
	private Date date;

	@Column(name = "ATTEND", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean attend;

	public boolean isAttend() {
		return attend;
	}

	public void setAttend(boolean attend) {
		this.attend = attend;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_STUDENT", updatable = false)
	private Student student;

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentPresent [id=" + id + ", date=" + date + ", attend=" + attend + "]";
	}

}
