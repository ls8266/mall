package com.ls.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ls.dao.GoodsPhotoDao;
import com.ls.domain.Address;
import com.ls.domain.Goods;
import com.ls.domain.GoodsPhoto;
import com.ls.domain.User;
import com.ls.utils.HibernateUtil;

public class GoodsPhotoDaoImpl extends CRUDDataDaoImpl implements GoodsPhotoDao {
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.GoodsPhotoDao#getGoodsPhotos(com.ls.domain.Goods)
	 */
	@Override
	public List getGoodsPhotos(Goods goods){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from GoodsPhoto t1 where t1.goods=?");
			query.setInteger(0,goods.getId());
			return query.list();
		}catch(HibernateException e){
			throw e;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ls.dao.impl.GoodsPhotoDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object entity){
		if(this.getGoodsPhotos(((GoodsPhoto)entity).getGoods()).size()>9){
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
			return session.get(GoodsPhoto.class,id);
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
