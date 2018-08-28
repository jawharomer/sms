package com.joh.sms.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

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

	
	@NotNull(message = "{teacher.hireAmount.null}")
	@Column(name = "HIRE_AMOUNT")
	private BigDecimal hireAmount;

	@NotBlank(message = "{teacher.userName.blank}")
	@Column(name = "USER_NAME")
	private String userName;

	@NotBlank(message = "{teacher.password.blank}")
	@Column(name = "PASSWORD")
	private String password;

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

	public BigDecimal getHireAmount() {
		return hireAmount;
	}

	public void setHireAmount(BigDecimal hireAmount) {
		this.hireAmount = hireAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
				+ lastName + ", hireAmount=" + hireAmount + ", userName=" + userName + ", password=" + password
				+ ", note=" + note + "]";
	}

}
