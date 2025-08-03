package com.nemo.expense_tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nemo.expense_tracker.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	//Find category by name
	Optional<Category> findByNameIgnoreCase(String name);

}
