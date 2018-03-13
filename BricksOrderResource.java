package com.bricks;

import java.util.List;

import javax.xml.ws.Response;

@RestController
public class BricksOrderResource {

	@Autowired
	private BrickService brickService;

	@PostMapping("/brick")
	public Long orderBricks(@RequestBody BrickDO brickDO) {
		return brickService.order(brickDO.bricksOrdered());
	}

	@GetMapping("/bricks/{orderNo}")
	public BrickDO getOrderDetails(@PathVariable("orderNo") long orderNo) {
		BrickDO brickDO = brickService.getOrderDetails(orderNo);
		if (null != brickDO) {
			return Response.ok(brickDO).build();
		} else {
			return ResponseEntity.ok().body("No order found with orderno :" + orderNo);
		}
	}

	@GetMapping("/bricks")
	public BrickDO orderBricks() {
		List<BrickDO> brickDOs = brickService.getAllOrderDetails();
		if (null != brickDOs) {
			return Response.ok(brickDOs).build();
		} else {
			return Response.ok(null).build();
		}
	}

	@PutMapping("/bricknos")
	public Long updateOrder(@RequestBody BrickDO brickDO) {
		BrickDO brickDO = brickService.updateOrder(brickDO);
		if (brickDO.isStatus()) {
			return ResponseEntity.ok().body("order alreday deliverd so no update on :" + brickDO.getOrderId());
		} else {
			return Response.ok(brickDOs).build();
		}
	}

}