package com.ls.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ls.dao.OrderDao;
import com.ls.domain.Address;
import com.ls.domain.Goods;
import com.ls.domain.Order;
import com.ls.domain.User;
import com.ls.utils.HibernateUtil;

public class OrderDaoImpl extends CRUDDataDaoImpl implements OrderDao {
	private int PAGE = 10;
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.OrderDao#getPayOrder(com.ls.domain.User, int)
	 * 获取等待支付的订单
	 */
	@Override
	public List getPayOrder(User user,int page){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from Order t1 where t1.user=? and t1.status=?");
			query.setInteger(0, user.getId());
			query.setInteger(1, 0);
			query.setFirstResult((page-1)*PAGE);
			query.setMaxResults(page*PAGE);
			return query.list();
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.OrderDao#getSuccessOrder(com.ls.domain.User, int)
	 * 获取支付完成的订单
	 */
	@Override
	public List getSuccessOrder(User user,int page){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from Order t1 where t1.user=? and t1.status=?");
			query.setInteger(0, user.getId());
			query.setInteger(1, 1);
			query.setFirstResult((page-1)*PAGE);
			query.setMaxResults(page*PAGE);
			return query.list();
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.OrderDao#getOffOrder(com.ls.domain.User, int)
	 * 获取取消支付的订单
	 */
	@Override
	public List getOffOrder(User user,int page){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from Order t1 where t1.user=? and t1.status=?");
			query.setInteger(0, user.getId());
			query.setInteger(1, 2);
			query.setFirstResult((page-1)*PAGE);
			query.setMaxResults(page*PAGE);
			return query.list();
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.UserDao#getUserCount()
	 */
	@Override
	public int getPayOrderCount(User user){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("select count(*) from Order t1 where t1.user=? and t1.status=?");
			query.setInteger(0, user.getId());
			query.setInteger(1, 0);
			return ((Long) query.uniqueResult()).intValue(); 
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.UserDao#getUserCount()
	 */
	@Override
	public int getSuccessOrderCount(User user){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("select count(*) from Order t1 where t1.user=? and t1.status=?");
			query.setInteger(0, user.getId());
			query.setInteger(1, 1);
			return ((Long) query.uniqueResult()).intValue(); 
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.UserDao#getUserCount()
	 */
	@Override
	public int getOffOrderCount(User user){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("select count(*) from Order t1 where t1.user=? and t1.status=?");
			query.setInteger(0, user.getId());
			query.setInteger(1, 2);
			return ((Long) query.uniqueResult()).intValue(); 
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
		Transaction tran = null;
		try{
			session = HibernateUtil.getSession();
			return session.get(Order.class,id);
		}catch(HibernateException e){
			if(tran!=null)
				tran.commit();
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
}
