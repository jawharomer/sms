package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STUDENT_LEVELS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "I_CLASS_SUBJECT", "I_STUDENT", "I_STUDENT_LEVEL_DATE" }) })
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

	@NotNull(message = "{studentLevel.level.null}")
	@Min(value = 0, message = "{studentLevel.level.min}")
	@Max(value = 6, message = "{studentLevel.level.max}")
	@Column(name = "LEVEL")
	private Integer level;

	@ManyToOne()
	@JoinColumn(name = "I_STUDENT_LEVEL_DATE", nullable = false)
	private StudentLevelDate studentLevelDate;

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

	public StudentLevelDate getStudentLevelDate() {
		return studentLevelDate;
	}

	public void setStudentLevelDate(StudentLevelDate studentLevelDate) {
		this.studentLevelDate = studentLevelDate;
	}

	@Override
	public String toString() {
		return "StudentLevel [id=" + id + ", classSubject=" + classSubject + ", student=" + student + ", level=" + level
				+ ", studentLevelDate=" + studentLevelDate + "]";
	}

}
