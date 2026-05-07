package com.LearningGit.expense_tracker.service;

import com.LearningGit.expense_tracker.model.Expenses;
import com.LearningGit.expense_tracker.repository.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesService {

	private final ExpensesRepository repo;
	 public ExpensesService(ExpensesRepository repo) {
	        this.repo = repo;
	    }

    // Feature 1 - Add Expense
    public Expenses addExpense(Expenses expense) {
        if (expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        return repo.save(expense);
    }
 // Feature 2 - View All Expenses
    public List<Expenses> getAllExpenses() {
        return repo.findAll();
    }
    
 // Feature 3 - Filter by Category
    public List<Expenses> getByCategory(String category) {
        return repo.findByCategory(category);
    }
    
 // Feature 4 - Monthly Summary
    public Double getMonthlySummary(int month, int year) {
        return repo.getTotalByMonth(month, year);
    }
}