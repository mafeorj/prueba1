package com.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.entity.Order;



public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{
	
}
