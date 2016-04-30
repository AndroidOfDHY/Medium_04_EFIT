package com.efit.znxy.dao;

import java.sql.SQLException;
import java.util.Map;

import com.efit.znxy.entity.User;
import com.efit.znxy.service.UserService;
import com.ideatech.common.base.BaseDAO;

public class UserDao extends BaseDAO {

	public static User findByUsername(String username) throws SQLException {
		return (User) sqlMap().queryForObject("User.findByUsername",username);
		
	}
	public static Object queryPageList(Map<String, Object> filter) throws SQLException {
		return sqlMap().queryForList("User.pageProperty",filter);
	}
	public static Integer queryPageCount(Map<String, Object> filter) throws SQLException {
		return (Integer) sqlMap().queryForObject("User.pageCount",filter);
	}
}
