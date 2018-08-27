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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STUDENTS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_STUDENT")
	private int id;

	@NotBlank(message = "{student.firstname.blank}")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = "{student.middleName.blank}")
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@NotBlank(message = "{student.lastName.blank}")
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotNull(message = "{student.birthDate.blank}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@NotBlank(message = "{student.userName.blank}")
	@Column(name = "USER_NAME")
	private String userName;

	@NotBlank(message = "{student.password.blank}")
	@Column(name = "PASSWORD")
	private String password;

	@NotBlank(message = "{student.parentUserName.blank}")
	@Column(name = "PARENT_USER_NAME")
	private String parentUserName;

	@NotBlank(message = "{student.parentPassword.blank}")
	@Column(name = "PARENT_PASSWORD")
	private String parentPassword;

	public Student() {
	}

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getParentUserName() {
		return parentUserName;
	}

	public void setParentUserName(String parentUserName) {
		this.parentUserName = parentUserName;
	}

	public String getParentPassword() {
		return parentPassword;
	}

	public void setParentPassword(String parentPassword) {
		this.parentPassword = parentPassword;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", birthDate=" + birthDate + ", userName=" + userName + ", password=" + password
				+ ", parentUserName=" + parentUserName + ", parentPassword=" + parentPassword + "]";
	}

}
