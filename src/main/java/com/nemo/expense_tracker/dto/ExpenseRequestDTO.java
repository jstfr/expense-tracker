package com.nemo.expense_tracker.dto;

import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_DESC_REQUIRED;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_DESC_MAX_LENGTH;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_AMT_REQUIRED;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_AMT_MIN;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_AMT_MIN_MSG;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_DATE_REQUIRED;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_DATE_FUTURE;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_CAT_ID_REQUIRED;
import static com.nemo.expense_tracker.constant.AppConstant.EXPENSE_CAT_ID_EMPTY;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ExpenseRequestDTO {

	@NotBlank(message = EXPENSE_DESC_REQUIRED)
	@Size(max = 255, message = EXPENSE_DESC_MAX_LENGTH)
	private String description;
	
	
	@NotNull(message = EXPENSE_AMT_REQUIRED)
    @DecimalMin(value = EXPENSE_AMT_MIN, message = EXPENSE_AMT_MIN_MSG)
	private BigDecimal amount;
	
	
	@NotNull(message = EXPENSE_DATE_REQUIRED)
    @PastOrPresent(message = EXPENSE_DATE_FUTURE)
	private LocalDate date;
	
	
	@NotEmpty(message = EXPENSE_CAT_ID_EMPTY)
	@JsonProperty("category_ids")
	private List<@NotNull(message = EXPENSE_CAT_ID_REQUIRED) Long> categoryIds;
	
}
