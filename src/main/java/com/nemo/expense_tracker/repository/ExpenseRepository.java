package com.nemo.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nemo.expense_tracker.model.Expense;
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
