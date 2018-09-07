package com.joh.sms.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joh.sms.model.Expense;

public interface ExpenseDAO extends CrudRepository<Expense, Integer> {
	List<Expense> findAllByTimeBetween(Date from, Date to);
}
