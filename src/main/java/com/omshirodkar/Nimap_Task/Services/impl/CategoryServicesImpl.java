package com.omshirodkar.Nimap_Task.Services.impl;

import com.omshirodkar.Nimap_Task.Dto.CategoryDto;
import com.omshirodkar.Nimap_Task.Entity.Category;
import com.omshirodkar.Nimap_Task.Repository.CategoryRepo;
import com.omshirodkar.Nimap_Task.Services.CategoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto,Category.class);
		Category added = this.categoryRepo.save(category);
		
		return this.modelMapper.map(added, CategoryDto.class);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

       Category cate = this.categoryRepo.findById(categoryId).orElseThrow();
		
		cate.setCategoryType(categoryDto.getCategoryType());
		//cate.setCategoryDiscription(categoryDto.getCategoryDiscription());
		
		Category updateCate = this.categoryRepo.save(cate);
		return this.modelMapper.map(updateCate,CategoryDto.class);
	
	}


	@Override
	public void deleteCategory(Integer categoryId) {
	    Category cate = this.categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
	    this.categoryRepo.delete(cate);
	}

	
	
	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		 Category cat = this.categoryRepo.findById(categoryId).orElseThrow();
			
			return this.modelMapper.map(cat,CategoryDto.class);
		
	}

	@Override
	public List<CategoryDto> getCategories(Integer pageNumber,Integer pageSize) {
		
	   Pageable p = PageRequest.of(pageNumber, pageSize);

		 Page<Category> pagecategory  = this.categoryRepo.findAll(p);
		 List<Category> findall = pagecategory.getContent();
	       List<CategoryDto> categoriesDto = findall.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
			
			return categoriesDto;
	}

	
}
