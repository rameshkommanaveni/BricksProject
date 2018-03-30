package com.bricks.resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bricks.model.BrickDO;
import com.bricks.service.BrickService;

@RestController
public class BricksOrderResource {
	
	final static Logger logger = Logger.getLogger(BricksOrderResource.class);

	@Autowired
	private BrickService brickService;

	@PostMapping("/brick")
	public Long orderBricks(@RequestBody BrickDO brickDO) {
		logger.info("Inserting into orderBricks " + brickDO.getOrderId());
		return brickService.order(brickDO);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/bricks/{orderNo}")
	public ResponseEntity getOrderDetails(@PathVariable("orderNo") long orderNo) {
		BrickDO brickDO = brickService.getOrderDetails(orderNo);
		if (null != brickDO) {
			logger.info("getOrderDetails " + brickDO.getBricksOrdered());
			return ResponseEntity.ok().body(brickDO);
		} else {
			return ResponseEntity.ok().body("No order found with orderno :" + orderNo);
		}
	}

	@SuppressWarnings({ "static-access", "rawtypes" })
	@GetMapping("/bricks")
	public ResponseEntity orderBricks() {
		List<BrickDO> brickDOs = brickService.getAllOrderDetails();
		if (null != brickDOs) {
			return ResponseEntity.ok().body(brickDOs);
		} else {
			return (ResponseEntity) ResponseEntity.ok().body(null).status(400);
		}
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/bricknos")
	public ResponseEntity updateOrder(@RequestBody BrickDO brickDO) {
		BrickDO brickDo = brickService.updateOrder(brickDO);
		if (brickDO.isStatus()) {
			return ResponseEntity.ok().body("order alreday deliverd so no update on :" + brickDO.getOrderId());
		} else {
			return ResponseEntity.ok().body(brickDo);
		}
	}

}