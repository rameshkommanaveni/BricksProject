package com.bricks;

import java.util.List;

public interface BrickService  {
	long order(BrickDO brickDO);

	BrickDO getAllOrderDetails(long orderNo);
	
	List<BrickDO> getAllOrderDetails();
	
	BrickDO updateOrder(BrickDO brickDO);

}
