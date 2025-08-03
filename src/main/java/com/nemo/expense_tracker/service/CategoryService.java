package com.nemo.expense_tracker.service;

import static com.nemo.expense_tracker.constant.AppConstant.CATEGORY_NAME_EXIST;
import static com.nemo.expense_tracker.constant.AppConstant.CATEGORY_NOT_FOUND;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nemo.expense_tracker.dto.CategoryRequestDTO;
import com.nemo.expense_tracker.dto.CategoryResponseDTO;
import com.nemo.expense_tracker.exception.CategoryExceptionHandler;
import com.nemo.expense_tracker.model.Category;
import com.nemo.expense_tracker.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public List<CategoryResponseDTO> getAllCategories(){
		return categoryRepository.findAll()
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}
	
	public CategoryResponseDTO addCategory(CategoryRequestDTO categoryRequestDTO) {
		categoryRepository.findByNameIgnoreCase(categoryRequestDTO.getName())
		.ifPresent(exist -> {
			throw new CategoryExceptionHandler.AlreadyExists(CATEGORY_NAME_EXIST + exist.getName());
		});
		
		return mapToDto(categoryRepository.save(Category.builder()
				.name(categoryRequestDTO.getName())
				.build()));
	}
	
	public void deleteCategory(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryExceptionHandler.NotFound(CATEGORY_NOT_FOUND));
		categoryRepository.delete(category);
	}
	
	
	private CategoryResponseDTO mapToDto(Category category) {
		return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
	}
	

}
