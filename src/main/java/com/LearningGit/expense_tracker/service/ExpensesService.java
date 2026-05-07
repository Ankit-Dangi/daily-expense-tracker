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

    public List<Expenses> getAllExpenses() {
        return repo.findAll();
    }

    public List<Expenses> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public Double getMonthlySummary(int month, int year) {
        return repo.getTotalByMonth(month, year);
    }

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
}