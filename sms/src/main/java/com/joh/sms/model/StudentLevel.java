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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "STUDENT_LEVELS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "I_CLASS_SUBJECT", "I_STUDENT" }) })
public class StudentLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_STUDENT_LEVEL")
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "I_CLASS_SUBJECT", nullable = false)
	private ClassSubject classSubject;

	@ManyToOne()
	@JoinColumn(name = "I_STUDENT", nullable = false)
	private Student student;

	
	@NotNull(message="{studentLevel.level.null}")
	@Min(value = 0,message="{studentLevel.level.min}")
	@Max(value = 10,message="{studentLevel.level.max}")
	@Column(name = "LEVEL")
	private Integer level;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClassSubject getClassSubject() {
		return classSubject;
	}

	public void setClassSubject(ClassSubject classSubject) {
		this.classSubject = classSubject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "StudentLevel [id=" + id + ", classSubject=" + classSubject + ", student=" + student + ", level=" + level
				+ "]";
	}

}
