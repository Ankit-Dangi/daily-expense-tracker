package com.LearningGit.expense_tracker.controller;

import com.LearningGit.expense_tracker.model.Expenses;
import com.LearningGit.expense_tracker.service.ExpensesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    private ExpensesService service;

    // ✅ This constructor is what injects the service
    @Autowired
    public ExpensesController(ExpensesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Expenses> addExpense(@RequestBody Expenses expense) {
        return ResponseEntity.ok(service.addExpense(expense));
    }
}