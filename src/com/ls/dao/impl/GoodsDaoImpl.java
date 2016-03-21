package com.ls.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ls.dao.GoodsDao;
import com.ls.domain.Address;
import com.ls.domain.Goods;
import com.ls.utils.HibernateUtil;

public class GoodsDaoImpl extends CRUDDataDaoImpl implements GoodsDao{
	private int PAGE = 10;
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.GoodsDao#getGoodses(int)
	 */
	@Override
	public List getGoods(int page){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from Goods");
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
	
	@Override
	public int getGoodsCount(){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			return ((Long) session.createQuery("select count(*) from Goods").uniqueResult()).intValue(); 
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
			return session.get(Goods.class,id);
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
