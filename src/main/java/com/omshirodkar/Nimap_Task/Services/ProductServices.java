package com.omshirodkar.Nimap_Task.Services;

import com.omshirodkar.Nimap_Task.Dto.ProductDto;

import java.util.List;


public interface ProductServices {
	

    ProductDto createProduct(ProductDto productDto);
  
  ProductDto updateProduct(ProductDto productDto,Integer productId);
  
  ProductDto getProductById(Integer productId);
  
 List<ProductDto> getAllProduct(Integer pageNumber,Integer pageSize);
 
 void deleteProduct(Integer productId);    
	

}
