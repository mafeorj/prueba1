package com.test.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	//bi-directional many-to-many association to Customer
	@ManyToMany(mappedBy="products")
	private List<Customer> customers;

	//bi-directional many-to-one association to CustomerProduct
	@OneToMany(mappedBy="product")
	private List<CustomerProduct> customerProducts;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<CustomerProduct> getCustomerProducts() {
		return this.customerProducts;
	}

	public void setCustomerProducts(List<CustomerProduct> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public CustomerProduct addCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().add(customerProduct);
		customerProduct.setProduct(this);

		return customerProduct;
	}

	public CustomerProduct removeCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().remove(customerProduct);
		customerProduct.setProduct(null);

		return customerProduct;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProduct(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProduct(null);

		return orderDetail;
	}

}