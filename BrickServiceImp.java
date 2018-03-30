package com.bricks.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bricks.dao.BrickDao;
import com.bricks.model.BrickDO;

@Service
@Transactional(readOnly = true)
public class BrickServiceImp implements BrickService {
	
	final static Logger logger = Logger.getLogger(BrickServiceImp.class);

	@Autowired
	private BrickDao brickDao;

	@Transactional
	@Override
	public long order(BrickDO BrickDO) {
		return brickDao.order(BrickDO);
	}

	@Override
	public BrickDO getOrderDetails(long orderNo) {
		return brickDao.getOrderDetails(orderNo);
	}

	@Override
	public List<BrickDO> getAllOrderDetails() {
		return brickDao.getAllOrderDetails();
	}

	
	@Override
	public BrickDO updateOrder(BrickDO brickDO) {
		return brickDao.updateOrder(brickDO);
	}
}
