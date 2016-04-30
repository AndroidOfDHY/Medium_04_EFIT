package com.efit.znxy.dao;

import java.sql.SQLException;
import java.util.Map;

import com.efit.znxy.entity.Clothes;
import com.efit.znxy.entity.Share;
import com.ideatech.common.base.BaseDAO;

public class ShareDao extends BaseDAO {
    public static Integer queryPageCount(Map<String, Object> filter) throws SQLException {
		
		return  (Integer) sqlMap().queryForObject(Share.class.getSimpleName()+".pageCount", filter);
	}

	public static Object queryPageList(Map<String, Object> filter) throws SQLException {
		return  sqlMap().queryForList(Share.class.getSimpleName()+".pageProperty", filter);
	}

	public static Share findById(String shareId) throws SQLException {
		return (Share)sqlMap().queryForObject(Share.class.getSimpleName()+".findById", shareId);
	}
	public static void  deleteById(String shareId) throws SQLException {
		sqlMap().delete(Share.class.getSimpleName()+".delete", shareId);
	}
}
