package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TEACHERS")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_TEACHER")
	private int id;

	@NotBlank(message = "{teacher.firstName.blank}")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = "{teacher.middleName.blank}")
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@NotBlank(message = "{teacher.lastName.blank}")
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "HIRE_AMOUNT")
	private double hireAmount;

	@Column(name = "NOTE")
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getHireAmount() {
		return hireAmount;
	}

	public void setHireAmount(double hireAmount) {
		this.hireAmount = hireAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", hireAmount=" + hireAmount + ", note=" + note + "]";
	}

}
