package com.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.entity.OrderDetail;
import com.test.entity.OrderDetailPK;

public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, OrderDetailPK>{
	
}
