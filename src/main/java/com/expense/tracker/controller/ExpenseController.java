package com.expense.tracker.controller;

import com.expense.tracker.entity.Expense;
import com.expense.tracker.exception.BadRequestException;
import com.expense.tracker.exception.ResourceNotFoundException;
import com.expense.tracker.exception.ServerException;
import com.expense.tracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        try {
            List<Expense> expenses = expenseService.getAllExpenses();
            return ResponseEntity.ok(expenses);
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        try {
            Expense newExpense = expenseService.addExpense(expense);
            return ResponseEntity.ok(newExpense);
        } catch(BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch(Exception e){
            throw new ServerException(e.getMessage());
        }
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable long id){
        try {
            Expense expense = expenseService.getExpenseById(id);
            return ResponseEntity.ok(expense);
        } catch(ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        } catch(Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    @PutMapping("/expenses/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable long id, @RequestBody Expense expense){
        try {
            Expense updatedExpense = expenseService.updateExpense(id, expense);
            return ResponseEntity.ok(updatedExpense);
        } catch(ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        } catch(BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch(Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable long id){
        try {
            expenseService.deleteExpense(id);
            return ResponseEntity.ok("Successfully deleted expense");
        } catch(ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        } catch(Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

}
