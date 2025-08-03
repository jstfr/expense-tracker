package com.nemo.expense_tracker.dto;

import static com.nemo.expense_tracker.constant.AppConstant.CAT_NAME_REQUIRED;
import static com.nemo.expense_tracker.constant.AppConstant.CAT_NAME_MAX_LENGTH;
import static com.nemo.expense_tracker.constant.AppConstant.CAT_NAME_MAX_LENGTH_MSG;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequestDTO {

	@NotBlank(message = CAT_NAME_REQUIRED)
    @Size(max = CAT_NAME_MAX_LENGTH, message = CAT_NAME_MAX_LENGTH_MSG)
	private String name;
}
