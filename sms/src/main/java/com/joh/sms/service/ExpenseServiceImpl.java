package com.joh.sms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ExpenseDAO;
import com.joh.sms.model.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseDAO expenseDAO;

	@Override
	public List<Expense> findAllByTimeBetween(Date from,Date to) {
		return expenseDAO.findAllByTimeBetween(from, to);
	}

	@Override
	public void delete(int id) {
		expenseDAO.delete(id);
	}

	@Override
	public Expense save(Expense expense) {
		return expenseDAO.save(expense);
	}

}