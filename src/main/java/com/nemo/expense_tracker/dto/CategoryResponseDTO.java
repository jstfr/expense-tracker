package com.nemo.expense_tracker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDTO {
	private long id;
	private String name;

}
