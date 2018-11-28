package com.joh.sms.domain.model;

public class ModemStatus {
	private String balance;
	private int signal;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	@Override
	public String toString() {
		return "ModemStatus [balance=" + balance + ", signal=" + signal + "]";
	}

}
