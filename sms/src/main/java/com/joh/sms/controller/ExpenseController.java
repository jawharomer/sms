package com.joh.sms.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joh.sms.model.Expense;
import com.joh.sms.service.ExpenseService;

@Controller()
@RequestMapping(path = "/expenses")
public class ExpenseController {

	private static final Logger logger = Logger.getLogger(ExpenseController.class);

	@Autowired
	private ExpenseService expenseService;

	@GetMapping
	private String getAllExpenses(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to, Model model) {
		logger.info("getAllExpenses->fired");

		logger.info("from=" + from);
		logger.info("to=" + to);

		List<Expense> expenses = expenseService.findAllByTimeBetween(from, to);
		logger.info("expenses=" + expenses);

		model.addAttribute("expenses", expenses);
		model.addAttribute("from", from);
		model.addAttribute("to", to);

		return "adminExpenses";
	}

	@GetMapping(path = "/add")
	private String getAddingExpose(Model model) {
		logger.info("getAddingExpose->fired");
		model.addAttribute("expense", new Expense());
		return "admin/addExpense";
	}

	@PostMapping(path = "/add")
	private String addExpense(@RequestBody @Valid Expense expense, BindingResult result, Model model) {
		logger.info("addExpense->fired");
		logger.info("expense=" + expense);

		logger.info("errors=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "admin/addExpense";
		} else {
			expenseService.save(expense);
			return "success";
		}

	}

	@GetMapping(path = "/edit/{id}")
	private String getEditingExpense(@PathVariable int id, Model model) {
		logger.info("getEditingExpense->fired");
		Expense expense = expenseService.findOne(id);
		logger.info("expense=" + expense);
		model.addAttribute("expense", expense);
		return "admin/editExpense";
	}

	@PostMapping(path = "/update")
	private String updateExpense(@RequestBody @Valid Expense expense, BindingResult result, Model model) {
		logger.info("addExpense->fired");
		logger.info("expense=" + expense);

		logger.info("errors=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "admin/addExpense";
		} else {
			expenseService.update(expense);
			return "success";
		}

	}

	@PostMapping(path = "/delete/{id}")
	private String deleteExpense(@PathVariable int id) {
		logger.info("deleteExpense->fired");
		logger.info("expenseId=" + id);
		expenseService.delete(id);
		return "success";
	}

}
