package com.efit.znxy.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.ideatech.common.MyLog;
/**
 * 
 * @author 池超凡
 * @time 2013-1-12
 *@功能 文件处理工具
 */
public  class FileUtil {
	/**
	 * 保存文件
	 * @param fileName 要保存的文件名
	 * @param fileAdress 文件路径
	 * @param file 文件
	 * @throws IOException 
	 */
	  public static void savaFile(String fileName,String fileAdress,File file) throws IOException{
		  if (file != null) {
			File saveFile=  new File(fileAdress+File.separator+fileName);
				FileUtils.copyFile(file, saveFile);

		  }
	  }
	  /**
	   * 获取文件名后缀
	   * @param fileName 文件名
	   * @return 后缀
	   */
	  public static String getFileNameSuffix (String fileName){
		  return fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
	  }
	  public static String randomFileName(String a){
		  java.util.Date   dt   =   new   java.util.Date(System.currentTimeMillis());  
          SimpleDateFormat   fmt   =   new   SimpleDateFormat("yyyyMMddHHmmssSSS");  
          String   fileName=   fmt.format(dt);  
          return fileName   + "."+  a  ;

	  }
	  public static String randomFileName(){
		  java.util.Date   dt   =   new   java.util.Date(System.currentTimeMillis());  
          SimpleDateFormat   fmt   =   new   SimpleDateFormat("yyyyMMddHHmmssSSS");  
          String   fileName=   fmt.format(dt);  
          return fileName;

	  }
		public static boolean isExists(String path){//判断目录是否存在
			MyLog.print("判断目录是否存在");
			File files =new File(path);
			if(!files.exists()){
				return false;
			}
			else return true;
		}
		  public static void createDirectory(String path){//生成目录
				File files =new File(path);
				if(!files.exists()){
					files.mkdirs();
				}
			}
		  public static void delete(String path){
			  File targetFile = new File(path);  
			     if (targetFile.isDirectory()) { //如果是 文件夹
			         try {
			               FileUtils.deleteDirectory(targetFile);
			            } catch (IOException e) {
			               e.printStackTrace();
			            }  
			      } else if (targetFile.isFile()) {//如果是文件  
			          targetFile.delete();  
			      }  
		  }
		  public static String getRealPath(String path){
				  String realPath=ServletActionContext.getServletContext().getRealPath(path);
				 return realPath;
			 }
		  /**
		   * 
		   * @param newPath 新路径
		   * @param oldFilePath 要移动的文件
		   * @return
		   */
		  public static String  remove(String newPath,String oldFilePath){
			  if (oldFilePath==null||!isExists(oldFilePath)) {return null;}
			  if (isExists(newPath)) {FileUtil.createDirectory(newPath);}
			  if (!newPath.endsWith(File.separator)) {
				  newPath+=File.separator;
			   }
			  File oldFile=  new File(oldFilePath);
			  File newFile =new File(newPath+oldFile.getName());
			  try {
				FileUtils.moveFile(oldFile, newFile);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			  return newFile.getAbsolutePath().replace(getRealPath(""), "");
		  }
		  
}
