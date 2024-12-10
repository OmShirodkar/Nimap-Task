package com.omshirodkar.Nimap_Task.Controller;

import com.omshirodkar.Nimap_Task.Dto.CategoryDto;
import com.omshirodkar.Nimap_Task.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
    private CategoryServices categoryServices;
	
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categoryDto)
	{
		   CategoryDto create =this.categoryServices.createCategory(categoryDto);
		   return new ResponseEntity<CategoryDto>(create,HttpStatus.CREATED);

		}
	
	   //Update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId)
	{
		
	 CategoryDto updated =this.categoryServices.updateCategory(categoryDto,categoryId);
	 
	 return new ResponseEntity<CategoryDto>(updated,HttpStatus.OK);
	}
	

	// delete
	@DeleteMapping("/{categoryId}")
	public String deleteCategory(@PathVariable Integer categoryId)
	{
	    this.categoryServices.deleteCategory(categoryId); 
	    return "deleted";
	}

	
	
	
	  // get 
	@GetMapping("/{categoryId}")
	public  ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId)
	{
		  CategoryDto get = this.categoryServices.getCategory(categoryId);
	      return new ResponseEntity<CategoryDto>(get,HttpStatus.OK);
		            
	}

	  // get all
	@GetMapping("")
	public ResponseEntity<List<CategoryDto>> getCategories(
			@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize
			)
	{
		 pageNumber = pageNumber - 1;
		List<CategoryDto> getAll = this.categoryServices.getCategories(pageNumber,pageSize);
           return ResponseEntity.ok(getAll);
	}

	

}
