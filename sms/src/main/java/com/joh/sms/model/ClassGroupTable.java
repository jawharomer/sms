package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLASS_GROUP_TABLES", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "I_CLASS_GROUP", "I_TEACHER", "I_SCHOOL_WEEK_DAY", "I_LESSON_TIME" }) })
public class ClassGroupTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_CLASS_GROUP_TABLE")
	private int id;

	@ManyToOne
	@JoinColumn(name = "I_CLASS_GROUP", updatable = false)
	private ClassGroup classGroup;

	@ManyToOne
	@JoinColumn(name = "I_TEACHER")
	private Teacher teacher;

	@ManyToOne
	@JoinColumn(name = "I_SCHOOL_WEEK_DAY")
	private SchoolWeekDay schoolWeekDay;

	@ManyToOne
	@JoinColumn(name = "I_LESSON_TIME")
	private LessonTime lessonTime;

	@ManyToOne
	@JoinColumn(name = "I_CLASS_SUBJECT")
	private ClassSubject classSubject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClassGroup getClassGroup() {
		return classGroup;
	}

	public void setClassGroup(ClassGroup classGroup) {
		this.classGroup = classGroup;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public SchoolWeekDay getSchoolWeekDay() {
		return schoolWeekDay;
	}

	public void setSchoolWeekDay(SchoolWeekDay schoolWeekDay) {
		this.schoolWeekDay = schoolWeekDay;
	}

	public LessonTime getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(LessonTime lessonTime) {
		this.lessonTime = lessonTime;
	}

	public ClassSubject getClassSubject() {
		return classSubject;
	}

	public void setClassSubject(ClassSubject classSubject) {
		this.classSubject = classSubject;
	}

	@Override
	public String toString() {
		return "ClassGroupTable [id=" + id + ", classGroup=" + classGroup + ", teacher=" + teacher + ", schoolWeekDay="
				+ schoolWeekDay + ", lessonTime=" + lessonTime + ", classSubject=" + classSubject + "]";
	}

}
