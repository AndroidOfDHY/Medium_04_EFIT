package com.efit.znxy.dao;

import java.sql.SQLException;
import java.util.Map;

import com.efit.znxy.entity.Comment;
import com.ideatech.common.base.BaseDAO;

public class CommentDao extends BaseDAO {
	   public static Integer queryPageCount(Map<String, Object> filter) throws SQLException {
			
			return  (Integer) sqlMap().queryForObject(Comment.class.getSimpleName()+".pageCount", filter);
		}

		public static Object queryPageList(Map<String, Object> filter) throws SQLException {
			return  sqlMap().queryForList(Comment.class.getSimpleName()+".pageProperty", filter);
		}
		public static Integer queryForScoreAvg (String shareId) throws SQLException {
			return (Integer) sqlMap().queryForObject(Comment.class.getSimpleName()+".socreAvg",shareId );
		}
}
