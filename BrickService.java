package com.bricks.service;

import java.util.List;

import com.bricks.model.BrickDO;


public interface BrickService  {
	
	long order(BrickDO brickDO);

	BrickDO getOrderDetails(long orderNo);
	
	List<BrickDO> getAllOrderDetails();
	
	BrickDO updateOrder(BrickDO brickDO);

}
