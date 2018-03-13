package com.bricks;

import java.util.List;

import javax.sql.DataSource;

public class BricksDaoImpl implements BrickDao {

	private JdbcTemplate template = null;

	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public long order(BrickDO brickDO) {
		// TODO Auto-generated method stub
		int id = select max(order_id) fron bricks;
		//table with name bricks
		//columns  order_id, bricks_ordered, delivery_status
		"insert into bricks (id+1, brickDO.getBricksOrdered(),'false' )"
		return 0;
	}

	@Override
	public BrickDO getOrderDetails(long orderNo) {
		//select * from bricks where order_id = orderNo;
		return null;
	}

	@Override
	public List<BrickDO> getAllOrderDetails() {
		// select * from bricks where delivery_status = 'false'
		return null;
	}

	@Override
	public BrickDO updateOrder(BrickDO brickDO) {
		// update bricks set bricks_ordered = brickDO.getBricksOrdered() and order_id = brickDO.getOrderId();
		return null;
	}

}
