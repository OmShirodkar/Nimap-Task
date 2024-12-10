package com.omshirodkar.Nimap_Task.Controller;

import com.omshirodkar.Nimap_Task.Dto.ProductDto;
import com.omshirodkar.Nimap_Task.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	

	@Autowired
	private ProductServices productServices;
	
	
	//Post - create user
		@PostMapping("/")
		public ResponseEntity<ProductDto> createproduct(@RequestBody ProductDto productDto)
		{
			ProductDto createUserDto = this.productServices.createProduct(productDto);
			return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
					
		}
		
		// put - update user
		@PutMapping("/{productId}")
		public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable("productId")  Integer productId)
		{
			ProductDto updatedProduct = this.productServices.updateProduct(productDto, productId);
		    return ResponseEntity.ok(updatedProduct);
		}

		//Delete - delete user
		@DeleteMapping("/{productId}")
		public String deleteProduct(@PathVariable("productId")Integer productId )
		{
			this.productServices.deleteProduct(productId);
			return "deleted";
		}
		

		//Get - user get	
		@GetMapping("/")
		public ResponseEntity<List<ProductDto>> getAllProduct(
				@RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,
				@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize
				)
		
		{
			 pageNumber = pageNumber - 1;
			List<ProductDto> allProduct = this.productServices.getAllProduct(pageNumber, pageSize);
			return new ResponseEntity<List<ProductDto>>(allProduct,HttpStatus.OK);
		
		}
		
		@GetMapping("/{productId}")
		
		public ResponseEntity<ProductDto> getSingleUser(@PathVariable Integer productId)
		{
			return ResponseEntity.ok(this.productServices.getProductById(productId));
		}
				
}
