package com.efit.znxy.dao;

import java.sql.SQLException;

import com.efit.znxy.entity.Clothes;
import com.ideatech.common.base.BaseDAO;

public class UpperClothesDao extends BaseDAO {
    public static void save(Clothes bean) throws SQLException{
    	sqlMap().insert("UpperClothes.insert", bean);
    }
}
