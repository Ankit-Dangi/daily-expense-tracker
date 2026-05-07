package com.LearningGit.expense_tracker.controller;

import com.LearningGit.expense_tracker.model.Expenses;
import com.LearningGit.expense_tracker.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    private ExpensesService service;

    @Autowired
    public ExpensesController(ExpensesService service) {
        this.service = service;
    }

    // Feature 1 - Add Expense
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

    // Feature 5 - Delete Expense
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteExpense(id));
    }

    // Feature 6 - Update Expense
    @PutMapping("/{id}")
    public ResponseEntity<Expenses> updateExpense(
            @PathVariable Long id,
            @RequestBody Expenses updatedExpense) {
        return ResponseEntity.ok(service.updateExpense(id, updatedExpense));
    }

    // Feature 7 - Search by Title
    @GetMapping("/search")
    public ResponseEntity<List<Expenses>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}