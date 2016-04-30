package com.efit.znxy.service;

import java.sql.SQLException;

import com.efit.znxy.dao.DownClothesDao;
import com.efit.znxy.dao.UpperClothesDao;
import com.efit.znxy.entity.Clothes;

public class DownClothesService {
   public static String save(Clothes bean) {
	  try {
		DownClothesDao.save(bean);
		return "1";
	} catch (SQLException e) {
		e.printStackTrace();
		return "0";
	}
  }
}
