package com.bricks;

import java.util.List;

public interface BrickDao {

	long order(BrickDO brickDO);

	BrickDO getOrderDetails(long orderNo);

	List<BrickDO> getAllOrderDetails();

	BrickDO updateOrder(BrickDO brickDO);

}
