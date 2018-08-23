package com.joh.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_GROUPS")
public class ClassGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_CLASS_GROUP")
	private int id;

	@Column(name = "GROUP_NAME")
	private String name;

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
		return "ClassGroup [id=" + id + ", name=" + name + ", classLevel=" + classLevel + "]";
	}

}
