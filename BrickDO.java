package com.bricks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Bricks")
public class BrickDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long OrderId;
	private Long bricksOrdered;
	private boolean status;
	

	public Long getBricksOrdered() {
		return bricksOrdered;
	}

	public void setBricksOrdered(Long bricksOrdered) {
		this.bricksOrdered = bricksOrdered;
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
