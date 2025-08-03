package com.nemo.expense_tracker.service;

import static com.nemo.expense_tracker.constant.AppConstant.CATEGORY_NOT_FOUND;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nemo.expense_tracker.dto.CategoryResponseDTO;
import com.nemo.expense_tracker.dto.ExpenseRequestDTO;
import com.nemo.expense_tracker.dto.ExpenseResponseDTO;
import com.nemo.expense_tracker.exception.CategoryExceptionHandler;
import com.nemo.expense_tracker.model.Category;
import com.nemo.expense_tracker.model.Expense;
import com.nemo.expense_tracker.repository.CategoryRepository;
import com.nemo.expense_tracker.repository.ExpenseRepository;
import com.nemo.expense_tracker.exception.ExpenseExceptionHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	private final CategoryRepository categoryRepository;
	
	public List<ExpenseResponseDTO> getAllExpenses(){
		return expenseRepository.findAll()
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
		
	}
	
	public ExpenseResponseDTO addExpense(ExpenseRequestDTO expenseRequestDTO) {
	    List<Category> categories = categoryRepository.findAllById(expenseRequestDTO.getCategoryIds());
	    if (categories.isEmpty()) {
	        throw new CategoryExceptionHandler.NotFound(CATEGORY_NOT_FOUND);
	    }
	    return mapToDto(expenseRepository.save(Expense.builder()
	            .description(expenseRequestDTO.getDescription())
	            .amount(expenseRequestDTO.getAmount())
	            .date(expenseRequestDTO.getDate())
	            .categories(categories)
	            .build()));
	}
	
	public ExpenseResponseDTO updateExpense(Long id, ExpenseRequestDTO expenseRequestDTO) {
	    Expense expense = expenseRepository.findById(id)
	        .orElseThrow(() -> new ExpenseExceptionHandler.NotFound(EXPENSE_NOT_FOUND));

	    expense.setDescription(expenseRequestDTO.getDescription());
	    expense.setAmount(expenseRequestDTO.getAmount());
	    expense.setDate(expenseRequestDTO.getDate());

	    if (!expenseRequestDTO.getCategoryIds().isEmpty()) {
	        List<Category> categories = categoryRepository.findAllById(expenseRequestDTO.getCategoryIds());
	        if (categories.isEmpty()) {
	            throw new CategoryExceptionHandler.NotFound(CATEGORY_NOT_FOUND);
	        }
	        expense.setCategories(categories);
	    }

	    return mapToDto(expenseRepository.save(expense));
		
	}
	
	public void deleteExpense(Long id) {
		if (!expenseRepository.existsById(id)) {
			throw new ExpenseExceptionHandler.NotFound(EXPENSE_NOT_FOUND);
		}
		expenseRepository.deleteById(id);
	}
			

	private ExpenseResponseDTO mapToDto(Expense expense) {
		return ExpenseResponseDTO.builder()
				.id(expense.getId())
				.description(expense.getDescription())
				.amount(expense.getAmount())
				.date(expense.getDate())
				.categories(expense.getCategories()
						.stream()
						.map(category -> CategoryResponseDTO.builder()
								.id(category.getId())
								.name(category.getName())
								.build())
						.collect(Collectors.toList()))
				.build();
	}
}