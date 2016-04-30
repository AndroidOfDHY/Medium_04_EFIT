package com.efit.znxy.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.FileUploadInterceptor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.efit.znxy.utils.FileUtil;
import com.ideatech.common.MyLog;

public class FileUploadAction extends BaseAction {
	private File image; //上传的文件   
	private String imageFileName; //文件名称   
	private String imageContentType; //文件类型
	
     public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

    public void upLaod() {
		MyLog.print("上传成功");
		String realpath = ServletActionContext.getServletContext().getRealPath("/clothes");
		try {
			System.out.println(imageFileName);
			String fileName=UUID.randomUUID().toString()+FileUtil.getFileNameSuffix(imageFileName);
			FileUtil.savaFile(fileName, realpath, image);
			JSONObject data = new JSONObject();
				data.put("msg", "200");
				data.put("value",fileName);
			sendHtml(data.toString());
			return ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		 catch (JSONException e) {
			// TODO Auto-generated catch block
		
			 e.printStackTrace();
		}
		 sendHtml(getJson("300"));

    }
}
