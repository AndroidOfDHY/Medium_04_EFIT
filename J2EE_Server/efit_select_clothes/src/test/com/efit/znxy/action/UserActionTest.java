package com.efit.znxy.action;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

public class UserActionTest {

	@Test
	public void test() {
		File myCaptureFile = new File("E:/bar_back.bmp"); 
		try {
			Assert.assertEquals("1", update("http://10.21.35.41:8080/efit_select_clothes/user/user.do?act=upLaod",myCaptureFile));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static String  update(String url ,File file) throws ClientProtocolException, IOException{
    	HttpPost post=new HttpPost(url);
    	 HttpClient httpClient = new DefaultHttpClient();
    	MultipartEntity mEntity=new MultipartEntity();
    	System.out.println(file.exists());
    	if(file!=null&&file.exists()) {
    		System.out.println("添加");
    		mEntity.addPart("image", new FileBody(file));
    	}
    	post.setEntity(mEntity);
    	HttpResponse res=httpClient.execute(post);
    	if (res.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
    //	System.out.println(EntityUtils.toString(res.getEntity()));
		}
       // httpClient.getConnectionManager( ).shutdown( );
        return EntityUtils.toString(res.getEntity());
    }
   
}
