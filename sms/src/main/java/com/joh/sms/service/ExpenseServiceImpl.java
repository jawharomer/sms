package com.joh.sms.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ExpenseDAO;
import com.joh.sms.model.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseDAO expenseDAO;

	@Override
	public List<Expense> findAllByTimeBetween(Date from, Date to) {
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

	@Override
	public Expense findOne(int id) {
		return expenseDAO.findOne(id);
	}

	@Override
	public Expense update(Expense expense) {
		if (expenseDAO.findOne(expense.getId()) == null)
			throw new EntityNotFoundException();
		return expenseDAO.save(expense);
	}

}