package com.efit.znxy.service;

import java.sql.SQLException;
import java.util.Map;

import com.efit.znxy.dao.CommentDao;
import com.efit.znxy.dao.ShareDao;
import com.efit.znxy.entity.Comment;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

public class CommentService {
   public static String save(Comment comment){
	   try {
		CommentDao.save(comment);
		return "200";
	} catch (SQLException e) {
		e.printStackTrace();
		return "300";
	}
	   
   }

public static Page queryPageList(Map<String, Object> filter, int pageNo,
		int pageSize) {
	try {
		int count = CommentDao.queryPageCount(filter);
		MyLog.print("数L:"+count);
		Page page=new Page(pageNo,pageSize,count);
		filter.put("offset",page.getIndexOf());
		filter.put("lastRows",pageSize);
		page.setRestult(CommentDao.queryPageList(filter));
		return page;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return null;
}
  public static Integer queryForScoreAvg(String shareId) {
	 try {
		return CommentDao.queryForScoreAvg(shareId);
	} catch (SQLException e) {
		
		e.printStackTrace();
		return null;
	}
  }
}
