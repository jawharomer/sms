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

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ENROLLMENTS", uniqueConstraints = { @UniqueConstraint(columnNames = { "I_STUDENT" }) })
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_ENROLLMENT")
	private int id;

	@ManyToOne
	@JoinColumn(name = "I_STUDENT", nullable = false)
	private Student student;

	@Column(name = "ENROLLMENT_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	private Date time;

	@Column(name = "FEE")
	private double fee;

	@ManyToOne()
	@JoinColumn(name = "I_CLASS_GROUP")
	private ClassGroup classGroup;

	@Column(name = "NOTE")
	private String note;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public ClassGroup getClassGroup() {
		return classGroup;
	}

	public void setClassGroup(ClassGroup classGroup) {
		this.classGroup = classGroup;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "StudentEnrollment [id=" + id + ", student=" + student + ", time=" + time + ", fee=" + fee + ", note="
				+ note + "]";
	}

}
