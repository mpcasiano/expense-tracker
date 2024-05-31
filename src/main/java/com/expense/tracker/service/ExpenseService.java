package com.expense.tracker.service;

import com.expense.tracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense addExpense(Expense expense);
    Expense getExpenseById(long id);
    Expense updateExpense(long id, Expense expense);
    void deleteExpense(long id);
}
