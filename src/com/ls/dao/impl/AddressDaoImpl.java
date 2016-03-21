package com.ls.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ls.dao.AddressDao;
import com.ls.domain.Address;
import com.ls.domain.User;
import com.ls.utils.HibernateUtil;

public class AddressDaoImpl extends CRUDDataDaoImpl implements AddressDao{
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.AddressDao#getFieldByUser(com.ls.domain.User)
	 */
	@Override
	public List getFieldByUser(User user){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from Address t1 where t1.user=?");
			query.setInteger(0, user.getId());
			return query.list();
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.AddressDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object entity)throws RuntimeException{
		if(this.getFieldByUser(((Address)entity).getUser()).size()>4){
			throw new RuntimeException();
		}else{
			super.add(entity);
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
			return session.get(Address.class,id);
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
