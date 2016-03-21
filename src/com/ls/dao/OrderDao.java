package com.ls.dao;

import java.io.Serializable;
import java.util.List;

import com.ls.domain.User;

public interface OrderDao extends CRUDDataDao{

	List getPayOrder(User user, int page);

	List getSuccessOrder(User user, int page);

	List getOffOrder(User user, int page);
	Object getFieldById(Serializable id);

	int getOffOrderCount(User user);

	int getSuccessOrderCount(User user);

	int getPayOrderCount(User user);
}