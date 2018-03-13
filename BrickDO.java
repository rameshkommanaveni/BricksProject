package com.bricks;

public class BrickDO {

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
