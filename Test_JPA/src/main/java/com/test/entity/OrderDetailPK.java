package com.test.entity;

import java.io.Serializable;
import javax.persistence.*;
/**
 * The primary key class for the ORDER_DETAIL database table.
 * 
 */
@Embeddable
public class OrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORDER_ID", insertable=false, updatable=false)
	private long orderId;

	@Column(name="PRODUCT_ID", insertable=false, updatable=false)
	private long productId;

	public OrderDetailPK() {
	}
	public long getOrderId() {
		return this.orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return this.productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderDetailPK)) {
			return false;
		}
		OrderDetailPK castOther = (OrderDetailPK)other;
		return 
			(this.orderId == castOther.orderId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.orderId ^ (this.orderId >>> 32)));
		hash = hash * prime + ((int) (this.productId ^ (this.productId >>> 32)));
		
		return hash;
	}
}