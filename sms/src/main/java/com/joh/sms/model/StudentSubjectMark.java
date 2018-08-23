package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_SUBJECT_MARKS")
public class StudentSubjectMark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_STUDENT_SUBJECT_MARK")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_STUDENT", updatable = false, nullable = false)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_CLASS_MARK", updatable = false, nullable = false)
	private ClassMark classMark;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_CLASS_SUBJECT", updatable = false, nullable = false)
	private ClassSubject classSubject;

	@Column(name = "MARK", nullable = false)
	private double mark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ClassMark getClassMark() {
		return classMark;
	}

	public void setClassMark(ClassMark classMark) {
		this.classMark = classMark;
	}

	public ClassSubject getClassSubject() {
		return classSubject;
	}

	public void setClassSubject(ClassSubject classSubject) {
		this.classSubject = classSubject;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "StudentSubjectMark [id=" + id + ", student=" + student + ", classMark=" + classMark + ", classSubject="
				+ classSubject + ", mark=" + mark + "]";
	}

}
