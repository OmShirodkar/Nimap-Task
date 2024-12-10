package com.omshirodkar.Nimap_Task.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "catogeries")
@Getter
@Setter
@NoArgsConstructor
public class Category {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	
	private String categoryType;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Product> product = new ArrayList<>();
	

}
