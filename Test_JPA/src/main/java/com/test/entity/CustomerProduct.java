package com.test.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_product database table.
 * 
 */
@Entity
@Table(name="customer_product")
@NamedQuery(name="CustomerProduct.findAll", query="SELECT c FROM CustomerProduct c")
public class CustomerProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerProductPK id;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id", insertable = false, updatable = false)
	private Customer customer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="customer_id", insertable = false, updatable = false)
	private Product product;

	public CustomerProduct() {
	}

	public CustomerProductPK getId() {
		return this.id;
	}

	public void setId(CustomerProductPK id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}