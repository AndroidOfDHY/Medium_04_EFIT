package com.efit.znxy.service;

import java.sql.SQLException;
import java.util.Map;

import com.efit.znxy.dao.ClothesDao;
import com.efit.znxy.entity.Clothes;
import com.efit.znxy.utils.PageUtil;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

public class ClothesService {
	   public static String save(Clothes bean) {
			  try {
				ClothesDao.save(bean);
				return "200";
			} catch (SQLException e) {
				e.printStackTrace();
				return "300";
			}
		  }
	   public static String modify(Clothes bean) {
                try {
					ClothesDao.update(bean);
					return "200";
				} catch (SQLException e) {
					e.printStackTrace();
					return "300";
				}
				
		  }
	   
	public static Page queryPageList(Map<String, Object> filter, int pageNo,
			int pageSize) {
		try {
			int count = ClothesDao.queryPageCount(filter);
        MyLog.print("数量："+count);
		//Page page = new Page(pageNo,pageSize,count);
        Page page=new Page(pageNo,pageSize,count);
		filter.put("offset",page.getIndexOf());
		filter.put("lastRows",pageSize);
			page.setRestult(ClothesDao.queryPageList(filter));
			return page;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static Clothes findById(String clothesId) {
		try {
			return ClothesDao.findById(clothesId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String deleteById(String clothesId) {
		try {
			ClothesDao.deleteById(clothesId);
			return "200";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "300";
		}
	}
}
