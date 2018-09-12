package com.joh.sms.domain.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ClassGroupTableD {

	private Integer classGroupTableId;

	@NotNull(message = "{classGroupTableD.schoolWeekDayId.null}")
	private Integer schoolWeekDayId;

	@NotNull(message = "{classGroupTableD.lessonTimeId.null}")
	private Integer lessonTimeId;

	private Integer classGroupId;

	@NotNull(message = "{classGroupTableD.classSubjectId.null}")
	private Integer classSubjectId;

	@NotNull(message = "{classGroupTableD.teacherId.null}")
	private Integer teacherId;

	private String weekDay;

	private String groupName;

	private Date lessonTime;

	private String subjectName;

	private String teacherName;

	public Integer getSchoolWeekDayId() {
		return schoolWeekDayId;
	}

	public void setSchoolWeekDayId(Integer schoolWeekDayId) {
		this.schoolWeekDayId = schoolWeekDayId;
	}

	public Integer getLessonTimeId() {
		return lessonTimeId;
	}

	public void setLessonTimeId(Integer lessonTimeId) {
		this.lessonTimeId = lessonTimeId;
	}

	public Integer getClassGroupId() {
		return classGroupId;
	}

	public void setClassGroupId(Integer classGroupId) {
		this.classGroupId = classGroupId;
	}

	public Integer getClassSubjectId() {
		return classSubjectId;
	}

	public void setClassSubjectId(Integer classSubjectId) {
		this.classSubjectId = classSubjectId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(Date lessonTime) {
		this.lessonTime = lessonTime;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getClassGroupTableId() {
		return classGroupTableId;
	}

	public void setClassGroupTableId(Integer classGroupTableId) {
		this.classGroupTableId = classGroupTableId;
	}

	@Override
	public String toString() {
		return "ClassGroupTableD [classGroupTableId=" + classGroupTableId + ", schoolWeekDayId=" + schoolWeekDayId
				+ ", lessonTimeId=" + lessonTimeId + ", classGroupId=" + classGroupId + ", classSubjectId="
				+ classSubjectId + ", teacherId=" + teacherId + ", weekDay=" + weekDay + ", groupName=" + groupName
				+ ", lessonTime=" + lessonTime + ", subjectName=" + subjectName + ", teacherName=" + teacherName + "]";
	}

}
