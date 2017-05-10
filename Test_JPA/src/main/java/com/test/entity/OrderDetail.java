package com.test.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ORDER_DETAIL database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAIL")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailPK id;

	private Long price;

	
	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDER_ID", insertable = false, updatable = false)
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", insertable = false, updatable = false)
	private Product product;

	public OrderDetail() {
	}

	public OrderDetailPK getId() {
		return this.id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}