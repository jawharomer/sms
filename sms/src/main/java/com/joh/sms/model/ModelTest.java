package com.joh.sms.model;

public class ModelTest {
	private String firstName;
	private String lastName;

	public ModelTest() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Test [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
