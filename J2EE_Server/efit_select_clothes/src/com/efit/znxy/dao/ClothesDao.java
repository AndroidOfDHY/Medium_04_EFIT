package com.efit.znxy.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.efit.znxy.entity.Clothes;
import com.ideatech.common.MyLog;
import com.ideatech.common.base.BaseDAO;

public class ClothesDao extends BaseDAO {

	public static Object queryPageList(Map<String, Object> filter) throws SQLException {
		
		return  sqlMap().queryForList(Clothes.class.getSimpleName()+".pageProperty", filter);
	}
     public static Integer queryPageCount(Map<String, Object> filter) throws SQLException {
		
		return  (Integer) sqlMap().queryForObject(Clothes.class.getSimpleName()+".pageCount", filter);
	}
	public static Clothes findById(String clothesId) throws SQLException {
		return  (Clothes) sqlMap().queryForObject(Clothes.class.getSimpleName()+".findById", clothesId);
	}
	public static void deleteById(String clothesId) throws SQLException {
		 sqlMap().delete(Clothes.class.getSimpleName()+".delete", clothesId);
	}
}
