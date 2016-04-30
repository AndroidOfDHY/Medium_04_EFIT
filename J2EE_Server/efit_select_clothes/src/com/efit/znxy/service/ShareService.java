package com.efit.znxy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.views.xslt.ArrayAdapter;

import com.efit.znxy.dao.ClothesDao;
import com.efit.znxy.dao.CommentDao;
import com.efit.znxy.dao.ShareDao;
import com.efit.znxy.entity.Share;
import com.ideatech.common.Page;

public class ShareService {

	public static String save(Share share) {
		try {
			ShareDao.save(share);
			return "200";
		} catch (SQLException e) {
			e.printStackTrace();
			return "300";
		}
		
	}

	public static Page queryPageList(Map<String, Object> filter, int pageNo,
			int pageSize) {
		try {
			int count = ShareDao.queryPageCount(filter);
			Page page=new Page(pageNo,pageSize,count);
			filter.put("offset",page.getIndexOf());
			filter.put("lastRows",pageSize);

			page.setRestult(ShareDao.queryPageList(filter));
			return page;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static Share findById(String shareId) {
		try {
			
			return ShareDao.findById(shareId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public static String deleteById(String shareId) {
		try {
	    ShareDao.deleteById(shareId);
		return "200";
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return "300";
		
	}

}
