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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

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

	@OneToOne()
	@JoinColumn(name = "I_ATTACHED_FILE")
	private AttachedFile attachedFile;

	@Column(name = "TITLE")
	private String title;

	@Length(max = 65535, message = "{subjectNotification.note.length}")
	@Column(name = "NOTE", columnDefinition = "TEXT")
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

	public AttachedFile getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(AttachedFile attachedFile) {
		this.attachedFile = attachedFile;
	}

	@Override
	public String toString() {
		return "SubjectNotification [id=" + id + ", classSubject=" + classSubject + ", classGroup=" + classGroup
				+ ", attachedFile=" + attachedFile + ", title=" + title + ", note=" + note + ", time=" + time + "]";
	}

}
