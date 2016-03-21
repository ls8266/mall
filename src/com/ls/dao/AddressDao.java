package com.ls.dao;

import java.io.Serializable;
import java.util.List;

import com.ls.domain.User;

public interface AddressDao extends CRUDDataDao{

	List getFieldByUser(User user);

	void add(Object entity);
	
	Object getFieldById(Serializable id);
}