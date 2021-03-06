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
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CLASS_SUBJECTS", uniqueConstraints = { @UniqueConstraint(columnNames = { "SUBJECT_NAME", "I_CLASS_LEVEL" }) })
public class ClassSubject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_CLASS_SUBJECT")
	private int id;

	@NotBlank(message = "{classSubject.name.blank}")
	@Column(name = "SUBJECT_NAME")
	private String name;

	@JsonIgnore
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

	public ClassLevel getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(ClassLevel classLevel) {
		this.classLevel = classLevel;
	}

	@Override
	public String toString() {
		return "ClassSubject [id=" + id + ", name=" + name + "]";
	}

}
