package com.omshirodkar.Nimap_Task.Services;

import com.omshirodkar.Nimap_Task.Dto.CategoryDto;

import java.util.List;



public interface CategoryServices {
	
	//create
			public CategoryDto createCategory(CategoryDto categoryDto);
			
			//update
			CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
			
			//delete
			void deleteCategory( Integer categoryId);
			
			//get
			CategoryDto getCategory(Integer categoryId);
			
			//getAll
		   List<CategoryDto> getCategories(Integer pageNumber,Integer pageSize);

		

}
