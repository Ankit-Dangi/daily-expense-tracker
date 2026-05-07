package com.LearningGit.expense_tracker.service;

import com.LearningGit.expense_tracker.model.Expenses;
import com.LearningGit.expense_tracker.repository.ExpensesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpensesService {

    private ExpensesRepository repo;

    public ExpensesService(ExpensesRepository repo) {
        this.repo = repo;
    }

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

    // Feature 5 - Delete Expense

    public String deleteExpense(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Expense with id " + id + " does not exist!");
        }
        repo.deleteById(id);
        return "Expense with id " + id + " deleted successfully!";
    }


    public Expenses updateExpense(Long id, Expenses updatedExpense) {
        Expenses existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));


    // Feature 6 - Update Expense
    public Expenses updateExpense(Long id, Expenses updatedExpense) {
        Expenses existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        existing.setTitle(updatedExpense.getTitle());
        existing.setAmount(updatedExpense.getAmount());
        existing.setCategory(updatedExpense.getCategory());
        existing.setDate(updatedExpense.getDate());
        existing.setNote(updatedExpense.getNote());
        return repo.save(existing);
    }

    public List<Expenses> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

        return repo.save(existing);
    }

    // Feature 7 - Search by Title
    public List<Expenses> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}