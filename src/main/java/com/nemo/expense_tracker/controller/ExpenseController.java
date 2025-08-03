package com.nemo.expense_tracker.controller;

import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_BASE_PATH;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_ID_NOT_VALID;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nemo.expense_tracker.dto.ExpenseRequestDTO;
import com.nemo.expense_tracker.dto.ExpenseResponseDTO;
import com.nemo.expense_tracker.service.ExpenseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(EXPENSE_BASE_PATH)
@RequiredArgsConstructor
public class ExpenseController {
	
	private final ExpenseService expenseService;
	
	@GetMapping("/")
	public List<ExpenseResponseDTO> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ExpenseResponseDTO addExpense(@Valid @RequestBody ExpenseRequestDTO expenseRequestDTO) {
		return expenseService.addExpense(expenseRequestDTO);
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ExpenseResponseDTO updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseRequestDTO expenseRequestDTO) {
		if (id <= 0) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, EXPENSE_ID_NOT_VALID);
	    }		
		return expenseService.updateExpense(id, expenseRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteExpense(@PathVariable Long id) {
		if (id <= 0) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, EXPENSE_ID_NOT_VALID);
	    }
		expenseService.deleteExpense(id);
	}
}
