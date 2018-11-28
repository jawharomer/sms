package com.joh.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "SMS_MESSAGES")
public class SMSMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_SMS_MESSAGE")
	private int id;

	@Column(name = "SMS_TO")
	private String to;
	@Column(name = "MESSAGE", columnDefinition = "TEXT")
	private String message;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SMSMessage [id=" + id + ", to=" + to + ", message=" + message + ", time=" + time + "]";
	}

}
