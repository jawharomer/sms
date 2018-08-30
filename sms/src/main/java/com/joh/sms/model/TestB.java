package com.joh.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_B")
public class TestB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bi;
	private String b;

	@ManyToMany(cascade= {CascadeType.MERGE})
	@JoinTable(name = "TABLE_A_TABLE_B", joinColumns = { @JoinColumn(name = "bi") }, inverseJoinColumns = {
			@JoinColumn(name = "ai") })
	private List<TestA> testAs;

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public List<TestA> getTestAs() {
		return testAs;
	}

	public void setTestAs(List<TestA> testAs) {
		this.testAs = testAs;
	}
	
	

	public int getBi() {
		return bi;
	}

	public void setBi(int bi) {
		this.bi = bi;
	}

	@Override
	public String toString() {
		return "TestB [bi=" + bi + ", b=" + b + ", testAs=" + testAs + "]";
	}

}
