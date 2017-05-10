package com.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.entity.Product;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{
	
}
