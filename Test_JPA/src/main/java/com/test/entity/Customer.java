package com.test.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private int customerId;

	private String email;

	private String name;

	//bi-directional many-to-many association to Product
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name="customer_product"
		, joinColumns={
			@JoinColumn(name="customer_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="product_id")
			}
		)
	@JsonIgnore
	private List<Product> products;

	//bi-directional many-to-one association to CustomerProduct
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	//@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<CustomerProduct> customerProducts;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Order> orders;

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<CustomerProduct> getCustomerProducts() {
		return this.customerProducts;
	}

	public void setCustomerProducts(List<CustomerProduct> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public CustomerProduct addCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().add(customerProduct);
		customerProduct.setCustomer(this);

		return customerProduct;
	}

	public CustomerProduct removeCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().remove(customerProduct);
		customerProduct.setCustomer(null);

		return customerProduct;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}

}