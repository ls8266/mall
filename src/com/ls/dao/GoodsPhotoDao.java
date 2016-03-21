package com.ls.dao;

import java.io.Serializable;
import java.util.List;

import com.ls.domain.Goods;

public interface GoodsPhotoDao extends CRUDDataDao{

	List getGoodsPhotos(Goods goods);

	void add(Object entity);
	
	Object getFieldById(Serializable id);
}