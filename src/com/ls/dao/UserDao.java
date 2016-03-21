package com.ls.dao;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends CRUDDataDao{

	List getUsers(int page);

	int getUserCount();
	Object getFieldById(Serializable id);
}