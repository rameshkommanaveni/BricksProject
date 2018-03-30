package com.bricks.dao;

import java.util.List;

import com.bricks.model.BrickDO;

public interface BrickDao {

	long order(BrickDO brickDO);

	BrickDO getOrderDetails(long orderNo);

	List<BrickDO> getAllOrderDetails();

	BrickDO updateOrder(BrickDO brickDO);

}
