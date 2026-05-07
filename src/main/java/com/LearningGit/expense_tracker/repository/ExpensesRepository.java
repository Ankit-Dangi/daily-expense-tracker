package com.LearningGit.expense_tracker.repository;


import com.LearningGit.expense_tracker.model.Expenses;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
	
	// Feature 3 - Filter by category
    List<Expenses> findByCategory(String category);
    
    

    @Query("SELECT SUM(e.amount) FROM Expenses e WHERE MONTH(e.date) = :month AND YEAR(e.date) = :year")
    Double getTotalByMonth(@Param("month") int month, @Param("year") int year);

}