package com.joh.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_A")
public class TestA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ai;
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public int getAi() {
		return ai;
	}

	public void setAi(int ai) {
		this.ai = ai;
	}

	@Override
	public String toString() {
		return "TestA [ai=" + ai + ", a=" + a + "]";
	}
	
	public static void main(String[] args) {
		System.out.println(2<<4);
	}

}
