package com.ls.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ls.dao.OrderGoodsDao;
import com.ls.domain.Order;
import com.ls.domain.OrderGoods;
import com.ls.utils.HibernateUtil;

public class OrderGoodsDaoImpl extends CRUDDataDaoImpl implements OrderGoodsDao {
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.OrderGoodsDao#getOrderGoodses(com.ls.domain.Order)
	 */
	@Override
	public List getOrderGoods(Order order){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from OrderGoods t1 where t1.order=?");
			query.setInteger(0,order.getId());
			return query.list();
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.CRUDDataDaod#getFieldById(java.io.Serializable)
	 */
	public Object getFieldById(Serializable id){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			return session.get(OrderGoods.class,id);
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
}
