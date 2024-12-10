package com.omshirodkar.Nimap_Task.Repository;

import com.omshirodkar.Nimap_Task.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
	
	

}
