package com.ls.dao;

import java.io.Serializable;
import java.util.List;

public interface GoodsDao extends CRUDDataDao{

	List getGoods(int page);
	int getGoodsCount();
	Object getFieldById(Serializable id);
}