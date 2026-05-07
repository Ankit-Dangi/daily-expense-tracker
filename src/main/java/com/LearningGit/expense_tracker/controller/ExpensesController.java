package com.LearningGit.expense_tracker.controller;

import com.LearningGit.expense_tracker.model.Expenses;
import com.LearningGit.expense_tracker.service.ExpensesService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
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
    
 // Feature 2 - View All Expenses
    @GetMapping
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        return ResponseEntity.ok(service.getAllExpenses());
    }
    
 // Feature 3 - Filter by Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expenses>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.getByCategory(category));
    }
    
 // Feature 4 - Monthly Summary
    @GetMapping("/summary")
    public ResponseEntity<Double> getMonthlySummary(
            @RequestParam int month,
            @RequestParam int year) {
        return ResponseEntity.ok(service.getMonthlySummary(month, year));
    }
}