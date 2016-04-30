package com.efit.znxy.utils;

import org.apache.struts2.ServletActionContext;

public class GlobalSources {
	public static final String Base_Path=ServletActionContext.getServletContext().getRealPath("/");	
public static final String Android_Wear_Path="androidWear/";
public static final String Clothes_Path="clothes/";
public static final String Pz_Path="pz/";
public static final String Pzimage_Path=Pz_Path+"pzimage/";
public static final String Syimages_Path="syimages/";
public static final String User_Path="user/";
public static final String Share_Path="share/";
}
