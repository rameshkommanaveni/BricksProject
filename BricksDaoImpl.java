package com.bricks.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bricks.model.BrickDO;


@Repository
@Transactional
public class BricksDaoImpl implements BrickDao {
	
	final static Logger logger = Logger.getLogger(BricksDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long order(BrickDO brickDO) {
		sessionFactory.getCurrentSession().save(brickDO);
		logger.debug("Getting order id " + brickDO.getOrderId());
	    return brickDO.getOrderId();
	}

	@Override
	public BrickDO getOrderDetails(long orderNo) {
		return sessionFactory.getCurrentSession().get(BrickDO.class, orderNo);
		
	}

	@Override
	public List<BrickDO> getAllOrderDetails() {
		  Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<BrickDO> cq = cb.createQuery(BrickDO.class);
	      Root<BrickDO> root = cq.from(BrickDO.class);
	      cq.select(root);
	      Query<BrickDO> query = session.createQuery(cq);
	      logger.debug("Getting getAllOrderDetails " + query.getResultList());
	      return query.getResultList();
	}

	@Override
	public BrickDO updateOrder(BrickDO brickDO) {
		BrickDO temp = sessionFactory.getCurrentSession().get(BrickDO.class,brickDO.getOrderId());
		if(null!= temp){
			return (BrickDO) sessionFactory.getCurrentSession().merge(brickDO.getOrderId());
		}
		return null;
	}

}
