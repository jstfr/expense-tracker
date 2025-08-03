package com.nemo.expense_tracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseResponseDTO {
	private long id;
	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private List<CategoryResponseDTO> categories;

}
