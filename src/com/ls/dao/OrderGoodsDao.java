package com.ls.dao;

import java.io.Serializable;
import java.util.List;

import com.ls.domain.Order;

public interface OrderGoodsDao extends CRUDDataDao{

	List getOrderGoods(Order order);
	Object getFieldById(Serializable id);
}