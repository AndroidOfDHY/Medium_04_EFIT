package com.efit.znxy.utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.efit.znxy.entity.Image;
import com.efit.znxy.entity.User;
import com.ideatech.common.MyLog;

public class UserActionUtil {
	 public static boolean saveBodyImage(User user){//根据头像生成男女模特
		  MyLog.print("根据头像生成男女模特");
		  Image images[]=new Image[2];
			String userPath=GlobalSources.Base_Path+GlobalSources.User_Path+"\\"+user.getUsername()+"\\";
			MyLog.print(user.getHeadAdreess());
			String headAdreessPath=ServletActionContext.getServletContext().getRealPath(user.getHeadAdreess());
			MyLog.print("头像地址："+headAdreessPath);
			FileUtil.createDirectory(userPath);
			MyLog.print("性别:"+user.getSex());
			if (user.getSex().equals("M")) {
				String bodyPath=ServletActionContext.getServletContext().getRealPath(GlobalSources.Syimages_Path)+"\\n_"+user.getSex()+user.getT_size()+".jpg";
				Image image1=new Image();
				image1.setAddress(bodyPath);
				image1.setX(0);
				image1.setY(0);
				images[0]=image1;
				Image image2=new Image();
				image2.setAddress(headAdreessPath);
				image2.setX(56);
				image2.setY(42);
				images[1]=image2;
			}
			else {
				String bodyPath=ServletActionContext.getServletContext().getRealPath(GlobalSources.Syimages_Path)+"\\n_W"+user.getT_size()+".jpg";
				Image image1=new Image();
				image1.setAddress(bodyPath);
				image1.setX(0);
				image1.setY(0);
				images[0]=image1;
				Image image2=new Image();
				image2.setAddress(headAdreessPath);
				if(user.getT_size().equals("m")){
				image2.setX(53);
				image2.setY(10);
				}
				else if(user.getT_size().equals("s")){
					image2.setX(55);
					image2.setY(23);
				}
				else {
					image2.setX(55);
					image2.setY(21);
				}
				images[1]=image2;
			}
			File outFile = new File(userPath+user.getSex()+user.getT_size()+".png");
			MyLog.print("生成："+outFile.getParent());
			try {
				return ImageIO.write(ImageUtil.ImageCompose(images),"png",outFile);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
	    }
	   public static void main(String[] args) {
		   User user=new User();
		   user.setSex("W");
		   user.setD_size("m");
		   user.setT_size("l");
		   user.setUsername("who247");
		   user.setHeadAdreess("20130516164702921.png");
		   saveImage(user);
	   }
		 public static boolean saveImage(User user){//根据头像生成男女模特
			  MyLog.print("根据头像生成男女模特");
			  Image images[]=new Image[2];
				String userPath="E:\\Tomcat 7.0\\webapps\\efit_select_clothes\\user\\who247\\";
				MyLog.print(user.getHeadAdreess());
				String headAdreessPath=userPath +user.getHeadAdreess();
				MyLog.print("头像地址："+headAdreessPath);
				FileUtil.createDirectory(userPath);
				MyLog.print("性别:"+user.getSex());
				if (user.getSex().equals("M")) {
					String bodyPath="E:\\Tomcat 7.0\\webapps\\efit_select_clothes\\syimages"+"\\n_"+user.getSex()+user.getT_size()+".jpg";
					Image image1=new Image();
					image1.setAddress(bodyPath);
					image1.setX(0);
					image1.setY(0);
					images[0]=image1;
					Image image2=new Image();
					image2.setAddress(headAdreessPath);
					image2.setX(56);
					image2.setY(36);
					images[1]=image2;
				}
				else {
					String bodyPath="E:\\Tomcat 7.0\\webapps\\efit_select_clothes\\syimages"+"\\n_W"+user.getT_size()+".jpg";
					Image image1=new Image();
					image1.setAddress(bodyPath);
					image1.setX(0);
					image1.setY(0);
					images[0]=image1;
					Image image2=new Image();
					image2.setAddress(headAdreessPath);
					image2.setX(55);
					image2.setY(21);
					//image2.setX(55);
					//image2.setY(23);
					images[1]=image2;
				}
				File outFile = new File(userPath+user.getSex()+user.getT_size()+".png");
				MyLog.print("生成："+outFile.getParent());
				try {
					return ImageIO.write(ImageUtil.ImageCompose(images),"png",outFile);
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
		    }
}
