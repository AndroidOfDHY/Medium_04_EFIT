package com.efit.znxy.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.efit.znxy.entity.MatchClothes;
import com.ideatech.common.MyLog;
import com.ideatech.common.base.BaseDAO;

public class MatchDao extends BaseDAO{


	public static List<?> queryPageList(Map<String, Object> filter) throws SQLException {
		return sqlMap().queryForList("MatchClothes.queryPageBySearch", filter);
	}
	
	public static Integer queryPageCount(Map<String, Object> filter) throws SQLException {
		return (Integer) sqlMap().queryForObject("MatchClothes.pageCount", filter);
	}
	public static void main(String[] args) {
      try {
		String keyword=findKeyword("1");
		MyLog.print(keyword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	public static String findKeyword(String username) throws SQLException {
		return (String) sqlMap().queryForObject("Search.findKeyword", username);
		
	}

	public static List<String> findKeywords(Map<String, Object> filter) throws SQLException {
		return (List<String>) sqlMap().queryForList("Search.findKeywords",filter);
	} 
		

	
}
