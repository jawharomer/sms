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

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "SUBJECT_NOTIFICATIONS")
public class SubjectNotification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_SUBJECT_NOTIFICATION")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_CLASS_SUBJECT", updatable = false, nullable = false)
	private ClassSubject classSubject;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_CLASS_GROUP", updatable = false, nullable = false)
	private ClassGroup classGroup;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "NOTE")
	private String note;

	@Column(name = "NOTIFICATION_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClassSubject getClassSubject() {
		return classSubject;
	}

	public void setClassSubject(ClassSubject classSubject) {
		this.classSubject = classSubject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ClassGroup getClassGroup() {
		return classGroup;
	}

	public void setClassGroup(ClassGroup classGroup) {
		this.classGroup = classGroup;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "SubjectNotification [id=" + id + ", classSubject=" + classSubject + ", classGroup=" + classGroup
				+ ", title=" + title + ", note=" + note + ", time=" + time + "]";
	}

}
