package service;

import model.Expense;
import repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

	private final ExpenseRepository repo;
	 public ExpenseService(ExpenseRepository repo) {
	        this.repo = repo;
	    }

    // Feature 1 - Add Expense
    public Expense addExpense(Expense expense) {
        if (expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        return repo.save(expense);
    }
}