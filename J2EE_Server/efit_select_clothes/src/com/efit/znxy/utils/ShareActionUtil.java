package com.efit.znxy.utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.efit.znxy.entity.Image;
import com.ideatech.common.MyLog;

public class ShareActionUtil {
	/**
	 *根据 上身 下身 模特 生成 穿衣服的模特图像
	 * @param upperClothes
	 * @param downClothes
	 * @param bodyPath
	 * @return
	 * @throws IOException
	 */
   public static  String makeBody(String upperClothes,String downClothes,String bodyPath,String savePath) throws IOException{
		  String upperClothesPath = GlobalSources.Base_Path+GlobalSources.Clothes_Path+File.separator+upperClothes;
		  String downClothesPath = GlobalSources.Base_Path+GlobalSources.Clothes_Path+File.separator+downClothes;
		  bodyPath = ServletActionContext.getServletContext().getRealPath(bodyPath);
		  MyLog.print(bodyPath);
		  Image images[]=new Image[3];
				Image image1=new Image();
				image1.setAddress(bodyPath);
				image1.setX(0);
				image1.setY(0);
				images[0]=image1;
				Image image2=new Image();
				image2.setAddress(downClothesPath);
				image2.setX(6);
				image2.setY(30);
				images[1]=image2;
				Image image3=new Image();
				image3.setAddress(upperClothesPath);
				image3.setX(6);
				image3.setY(30);
				images[2]=image3;
				String path=GlobalSources.Base_Path+savePath;
				FileUtil.createDirectory(path);
				String imageName=FileUtil.randomFileName("png");
				File outFile = new File(path+File.separator+imageName);
			    ImageIO.write(ImageUtil.ImageCompose(images),"png", outFile);
                return   imageName;

   }
}
