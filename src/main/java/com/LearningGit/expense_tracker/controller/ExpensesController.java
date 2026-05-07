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

    @PostMapping
    public ResponseEntity<Expenses> addExpense(@RequestBody Expenses expense) {
        return ResponseEntity.ok(service.addExpense(expense));
    }

    @GetMapping
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        return ResponseEntity.ok(service.getAllExpenses());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expenses>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.getByCategory(category));
    }

    @GetMapping("/summary")
    public ResponseEntity<Double> getMonthlySummary(
            @RequestParam int month,
            @RequestParam int year) {
        return ResponseEntity.ok(service.getMonthlySummary(month, year));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteExpense(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expenses> updateExpense(
            @PathVariable Long id,
            @RequestBody Expenses updatedExpense) {
        return ResponseEntity.ok(service.updateExpense(id, updatedExpense));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Expenses>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}