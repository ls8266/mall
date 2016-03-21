package com.ls.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ls.dao.UserDao;
import com.ls.domain.Order;
import com.ls.domain.User;
import com.ls.utils.HibernateUtil;

public class UserDaoImpl extends CRUDDataDaoImpl implements UserDao {
	
	private int PAGE = 10;
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.UserDao#getUsers(int)
	 */
	@Override
	public List getUsers(int page){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from User");
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
	public int getUserCount(){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			return ((Long) session.createQuery("select count(*) from User").uniqueResult()).intValue(); 
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
			return session.get(User.class,id);
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
