package com.ls.dao.impl;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ls.dao.CRUDDataDao;
import com.ls.utils.HibernateUtil;
/*
 * 新增、更新、删除dao操作
 */
public class CRUDDataDaoImpl implements CRUDDataDao {

	/* (non-Javadoc)
	 * @see com.ls.dao.impl.CRUDDataDaod#add(java.lang.Object)
	 */
	@Override
	public void add(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			session.save(entity);
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null)
				tran.commit();
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.CRUDDataDaod#update(java.lang.Object)
	 */
	@Override
	public void update(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			session.update(entity);
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null)
				tran.commit();
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.CRUDDataDaod#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			session.delete(entity);
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null)
				tran.commit();
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.CRUDDataDaod#getFieldById(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public Object getFieldById(Class clazz,Serializable id){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSession();
			return session.get(clazz,id);
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
