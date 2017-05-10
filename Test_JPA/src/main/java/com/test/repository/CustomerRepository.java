package com.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{
	
}
