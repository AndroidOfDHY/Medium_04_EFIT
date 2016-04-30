package com.efit.znxy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.efit.znxy.dao.MatchDao;
import com.efit.znxy.entity.MatchClothes;
import com.efit.znxy.entity.Search;
import com.ideatech.common.Page;

public class MatchService {

	public static Page queryPageList(Map<String, Object> filter, int pageNo, int pageSize) {
		try {
			Integer count= MatchDao.queryPageCount(filter);
			Page page = new Page(pageNo,pageSize,count);
			filter.put("offset",page.getIndexOf());
			filter.put("lastRows",pageSize);
			page.setRestult(MatchDao.queryPageList(filter));
			return page;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static String findKeyword(String username) {
		try {
			return MatchDao.findKeyword(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void save(Search search) {
		try {
			MatchDao.save(search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> findKeywords(Map<String, Object> filter) {
		try {
			
			return  MatchDao.findKeywords(filter);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}


}
