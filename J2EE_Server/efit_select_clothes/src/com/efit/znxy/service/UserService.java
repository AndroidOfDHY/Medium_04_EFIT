package com.efit.znxy.service;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.efit.znxy.dao.ClothesDao;
import com.efit.znxy.dao.UserDao;
import com.efit.znxy.entity.Image;
import com.efit.znxy.entity.User;
import com.efit.znxy.utils.ImageUtil;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

public class UserService {
    public static String save(User user){
    	try {
			UserDao.save(user);
			return "200";
		} catch (SQLException e) {
			e.printStackTrace();
			return "300";
		}
    }
    public static User findByUsername(String username){
    	try {
    		return UserDao.findByUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
    public static Page queryPageList(Map<String, Object> filter, int pageNo,
			int pageSize){
    	int count;
		try {
			count = UserDao.queryPageCount(filter);
		   	Page page=new Page(pageNo,pageSize,count);
			filter.put("offset",page.getIndexOf());
			filter.put("lastRows",pageSize);
			page.setRestult(UserDao.queryPageList(filter));
			return page;
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
    	return null;
    }
	public static String update(User user) {
	  try {
		UserDao.update(user);
		return"200";
	} catch (SQLException e) {
		e.printStackTrace();
		return"300";
	}
	}
	public static String deleteById(Integer valueOf) {
		try {
			UserDao.deleteById(User.class, valueOf);
			return "200";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "300";
	}
  
}
