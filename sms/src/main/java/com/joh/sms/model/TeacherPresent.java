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

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TEACHER_PRESENT")
public class TeacherPresent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_TEACHER_PRESENT")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "I_TEACHER", nullable = false)
	private Teacher teacher;

	@Column(name = "PRESENT_DATE",nullable=false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date date;

	@Column(name = "NUMBER_OF_LECTURES", nullable = false)
	private int numberOfLectures;

}
