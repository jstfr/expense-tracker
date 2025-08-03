package com.nemo.expense_tracker.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nemo.expense_tracker.dto.CategoryRequestDTO;
import com.nemo.expense_tracker.dto.CategoryResponseDTO;
import com.nemo.expense_tracker.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static com.nemo.expense_tracker.constant.AppConstant.CATEGORY_BASE_PATH;
import static com.nemo.expense_tracker.constant.AppConstant.CATEGORY_ID_NOT_VALID;

import java.util.List;

@RestController
@RequestMapping(CATEGORY_BASE_PATH)
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@GetMapping("/")
	public List<CategoryResponseDTO> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	
	@PostMapping("/")
	public CategoryResponseDTO addCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
		return categoryService.addCategory(categoryRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		if (id <= 0) {
			throw new IllegalArgumentException(CATEGORY_ID_NOT_VALID);
		}
		categoryService.deleteCategory(id);
	}
	
}
