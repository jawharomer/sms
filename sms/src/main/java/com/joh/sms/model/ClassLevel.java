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

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CLASS_LEVELS")
public class ClassLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_CLASS_LEVEL")
	private int id;

	@NotBlank(message = "{classLevel.name.blank}")
	@Column(name = "LEVEL_NAME")
	private String name;


	public ClassLevel() {

	}

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



	@Override
	public String toString() {
		return "ClassLevel [id=" + id + ", name=" + name + "]";
	}

}
