package com.joh.sms.domain.model;

import java.math.BigDecimal;

public class TeacherLecturePresentD {
	private int teacherId;
	private String teacherName;
	private int lecturePerWeek;
	private BigDecimal hireAmount;
	private int totalLectures;
	private BigDecimal totalPayment;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getLecturePerWeek() {
		return lecturePerWeek;
	}

	public void setLecturePerWeek(int lecturePerWeek) {
		this.lecturePerWeek = lecturePerWeek;
	}

	public BigDecimal getHireAmount() {
		return hireAmount;
	}

	public void setHireAmount(BigDecimal hireAmount) {
		this.hireAmount = hireAmount;
	}

	public int getTotalLectures() {
		return totalLectures;
	}

	public void setTotalLectures(int totalLectures) {
		this.totalLectures = totalLectures;
	}

	public BigDecimal getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(BigDecimal totalPayment) {
		this.totalPayment = totalPayment;
	}

	@Override
	public String toString() {
		return "TeacherLecturePresentD [teacherId=" + teacherId + ", teacherName=" + teacherName + ", lecturePerWeek="
				+ lecturePerWeek + ", hireAmount=" + hireAmount + ", totalLectures=" + totalLectures + ", totalPayment="
				+ totalPayment + "]";
	}

}