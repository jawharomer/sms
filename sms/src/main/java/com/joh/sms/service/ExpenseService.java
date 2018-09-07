package com.joh.sms.service;

import java.util.Date;
import java.util.List;

import com.joh.sms.model.Expense;

public interface ExpenseService {


	void delete(int id);

	Expense save(Expense expense);

	List<Expense> findAllByTimeBetween(Date from, Date to);

}
