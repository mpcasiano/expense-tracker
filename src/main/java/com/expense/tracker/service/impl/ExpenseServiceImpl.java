package com.expense.tracker.service.impl;

import com.expense.tracker.entity.Expense;
import com.expense.tracker.exception.ResourceNotFoundException;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl (ExpenseRepository expenseRepository) { this.expenseRepository = expenseRepository; }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense addExpense(Expense expense) {
        Expense newExpense = new Expense();
        newExpense.setExpense(expense.getExpense());
        newExpense.setCost(expense.getCost());
        return expenseRepository.save(newExpense);
    }

    @Override
    public Expense getExpenseById(long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public Expense updateExpense(long id, Expense expense) {
        Expense dbExpense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        dbExpense.setExpense(expense.getExpense());
        dbExpense.setCost(expense.getCost());
        return expenseRepository.save(dbExpense);
    }

    @Override
    public void deleteExpense(long id) {
        Expense dbExpense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        expenseRepository.delete(dbExpense);
    }

}
