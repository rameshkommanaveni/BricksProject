package bricks.order.project;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bricks.config.AppConfig;
import com.bricks.model.BrickDO;
import com.bricks.resource.BricksOrderResource;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@ComponentScan(basePackages = { "com.bricks" })
public class BricksTest {

	@Autowired
	BricksOrderResource bricksOrderResource;

	@Test
	public void testGetAllOrderBricks() {
		// System.out.println("hello");
		ResponseEntity<List<BrickDO>> re = bricksOrderResource.orderBricks();
		List<BrickDO> list = re.getBody();
		for (BrickDO brickDo : list) {
			System.out.println(brickDo.getBricksOrdered());
			System.out.println(brickDo.getOrderId());
		}
	}

	@Test
	public void testOrderBricsBasedOnId() {
		ResponseEntity<BrickDO> re = bricksOrderResource.getOrderDetails(1);
		BrickDO bdo = re.getBody();
		if (null != bdo) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testInsertOrderBricks() {
		  BrickDO bdo = new BrickDO();
		  bdo.setBricksOrdered(3L);
		  bdo.setOrderId(3L);
		  bdo.setStatus(true);
		 long l = bricksOrderResource.orderBricks(bdo);
		 if(l> 0) {
			 Assert.assertTrue(true);
		 }
	  }
	
	
	@Test
	public void testUpdateOrderBricks() {
		  BrickDO bdo = new BrickDO();
		  bdo.setBricksOrdered(100L);
		  bdo.setOrderId(100L);
		  bdo.setStatus(false);
		  ResponseEntity<BrickDO> bdoResponse = bricksOrderResource.updateOrder(bdo);
		  BrickDO bdo1 = bdoResponse.getBody();
		 if(null == bdo1) {
			 Assert.assertTrue(true);
		 }
	  }
	
}