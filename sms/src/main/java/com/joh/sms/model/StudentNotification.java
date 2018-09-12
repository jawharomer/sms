package com.joh.sms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "STUDENT_NOTIFICATIONS")
public class StudentNotification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_STUDENT_NOTIFICATION")
	private int id;

	@ManyToMany(targetEntity=Student.class)
	@JoinTable(name = "STUDENTNOTIFICAION_STUDENT", joinColumns = { @JoinColumn(name = "I_STUDENT_NOTIFICATION") }, inverseJoinColumns = {
			@JoinColumn(name = "I_STUDENT"), })
	private List<Student> students;

	@Column(name = "TITLE")
	private String title;

	@Length(min=1,max=512,message="{studentNotification.note.length}")
	@Column(name = "NOTE",length=512)
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StudentNotification [id=" + id + ", students=" + students + ", title=" + title + ", note=" + note
				+ ", time=" + time + "]";
	}

}
