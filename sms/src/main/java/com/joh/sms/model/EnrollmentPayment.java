package com.joh.sms.model;

import java.math.BigDecimal;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ENROLLMENT_PAYMENT")
public class EnrollmentPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_ENROLLMENT_PAYMENT")
	private int id;

	@NotNull(message = "{enrollmentPayment.amount.null}")
	@Min(value = 1, message = "{enrollmentPayment.amount.min}")
	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "PAYMENT_TIME", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp()
	@ColumnDefault("CURRENT_TIMESTAMP")
	private Date time;

	@Column(name = "NOTE")
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_ENROLLMENT", updatable = false)
	private Enrollment enrollment;

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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "EnrollmentPayment [id=" + id + ", amount=" + amount + ", time=" + time + ", note=" + note
				+ ", enrollment=" + enrollment + "]";
	}

}
