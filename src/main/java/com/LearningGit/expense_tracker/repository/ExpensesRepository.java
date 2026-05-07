package com.LearningGit.expense_tracker.repository;


import com.LearningGit.expense_tracker.model.Expenses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

	List<Expenses> findByCategory(String category);
}