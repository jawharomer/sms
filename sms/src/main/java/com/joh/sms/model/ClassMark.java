package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_MARKS")
public class ClassMark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_CLASS_MARK")
	private int id;

	@Column(name = "MARK_NAME")
	private String name;

	@Column(name = "MARK_LIMIT")
	private double limit;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "I_CLASS_LEVEL", updatable = false)
	private ClassLevel classLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public ClassLevel getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(ClassLevel classLevel) {
		this.classLevel = classLevel;
	}

	@Override
	public String toString() {
		return "ClassMark [id=" + id + ", name=" + name + ", limit=" + limit + ", classLevel=" + classLevel + "]";
	}

}
