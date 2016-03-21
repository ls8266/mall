package com.ls.dao;

import java.io.Serializable;

public interface CRUDDataDao {

	void add(Object entity);

	void update(Object entity);

	void delete(Object entity);

	Object getFieldById(Class clazz, Serializable id);
	
}