package com.bricks;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BrickServiceImp implements BrickService {

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
	public List<BrickDO> getAllOrderDetails() {
		return brickDao.getAllOrderDetails();
	}

	@Override
	public BrickDO updateOrder(BrickDO brickDO) {
		return brickDao.updateOrder(brickDO);
		return null;
	}
}
