package com.org.efit.util;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class HttpUtil
{
  public static String JSESSIONID = null;

  public static Bitmap getHttpBitmap(String paramString)
  {
    HttpURLConnection localHttpURLConnection;
    Bitmap localBitmap=null;
	try {
		localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
	    Log.i("nowtime", new Date().toString());
	    localHttpURLConnection.connect();
	    Log.i("aftertime", new Date().toString());
	    Log.i("InputStreamnowtime", new Date().toString());
	    InputStream localInputStream = localHttpURLConnection.getInputStream();
	    Log.i("InputStreamaftertime", new Date().toString());
	    localBitmap = BitmapFactory.decodeStream(localInputStream);
	    localInputStream.close();
	    localHttpURLConnection.disconnect();
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

    return localBitmap;
  }


//  public static void main(String[] paramArrayOfString)
//  {
//    new HashMap().put("a", "a");
//    System.out.println(sendPostRequest("http://127.0.0.1:8080/efit_select_clothes/user/clothes.do?act=getAndroidClothes", null));
//  }

public static String sendPostRequest(String url, HashMap hashMap)
  {
	  String str=null;
   HttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpPost localHttpPost = new HttpPost(url);
    if (JSESSIONID != null)
    localHttpPost.setHeader("Cookie", "JSESSIONID=" + JSESSIONID);
    List<NameValuePair> nvpsList=new ArrayList<NameValuePair>();
    if (hashMap!=null) {
    for (Iterator iter=hashMap.entrySet().iterator();iter.hasNext();) {
		Map.Entry e=(Map.Entry) iter.next();
		Object strKey=e.getKey();
		Object strValue=e.getValue();
		nvpsList.add(new BasicNameValuePair(""+strKey,""+ strValue));
	 }
    }
    try {
		localHttpPost.setEntity(new UrlEncodedFormEntity(nvpsList,HTTP.UTF_8));
        HttpResponse response=localDefaultHttpClient.execute(localHttpPost);
        if (response.getStatusLine().getStatusCode()==200) {
        	 HttpEntity localHttpEntity = response.getEntity();
            if (localHttpEntity != null)
                str = EntityUtils.toString(localHttpEntity);
            Log.i("ccf_str", str);
            List localList = ((AbstractHttpClient)localDefaultHttpClient).getCookieStore().getCookies();
             for (int i = 0; i < localList.size(); i++) {
            	 if ("JSESSIONID".equals(((Cookie)localList.get(i)).getName())){
            		 JSESSIONID = ((Cookie)localList.get(i)).getValue();
            	 }
			
		    }
            
		    }
	
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (ClientProtocolException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
    finally {localDefaultHttpClient.getConnectionManager().shutdown();}
    return str;
  }
  
  
  
  
  
  
  
  
  static String str=null;
  public static String sendPostRequest(Context context,final String url, final HashMap hashMap)
  {
	 ProgressDialog pd=ProgressDialog.show(context, "Load", "Loading…"); 
    
   Thread thread=new Thread(){ 
	   public void run(){ 
		   HttpClient localDefaultHttpClient = new DefaultHttpClient();
		    HttpPost localHttpPost = new HttpPost(url);
		    if (JSESSIONID != null)
		    localHttpPost.setHeader("Cookie", "JSESSIONID=" + JSESSIONID);
		    List<NameValuePair> nvpsList=new ArrayList<NameValuePair>();
		    if (hashMap!=null) {
		    for (Iterator iter=hashMap.entrySet().iterator();iter.hasNext();) {
				Map.Entry e=(Map.Entry) iter.next();
				Object strKey=e.getKey();
				Object strValue=e.getValue();
				nvpsList.add(new BasicNameValuePair(""+strKey,""+ strValue));
			 }
		    }
		    try {
				localHttpPost.setEntity(new UrlEncodedFormEntity(nvpsList,HTTP.UTF_8));
		        HttpResponse response=localDefaultHttpClient.execute(localHttpPost);
		        if (response.getStatusLine().getStatusCode()==200) {
		        	 HttpEntity localHttpEntity = response.getEntity();
		            if (localHttpEntity != null)
		                str = EntityUtils.toString(localHttpEntity);
		            Log.i("ccf_str", str);
		            List localList = ((AbstractHttpClient)localDefaultHttpClient).getCookieStore().getCookies();
		             for (int i = 0; i < localList.size(); i++) {
		            	 if ("JSESSIONID".equals(((Cookie)localList.get(i)).getName())){
		            		 JSESSIONID = ((Cookie)localList.get(i)).getValue();
		            	 }
					
				    }
		            
				    }
			
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    finally {localDefaultHttpClient.getConnectionManager().shutdown();}
		    
	   } 
	   };
	   thread.start();
	   try {
		thread.join();
		pd.dismiss();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	   Log.i("ccf_str", "发送");  
    return str;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public static String  upload(String url ,File file) throws ClientProtocolException, IOException{
  	String reslut="0";
  	HttpPost post=new HttpPost(url);
  	 HttpClient httpClient = new DefaultHttpClient();
  	MultipartEntity mEntity=new MultipartEntity();
  	System.out.println(file.exists());
  	if(file==null||!file.exists()) {
  		System.out.println("添加");
  		return reslut;
  	}
  	mEntity.addPart("image", new FileBody(file));
  	post.setEntity(mEntity);
  	HttpResponse res=httpClient.execute(post);
  	if (res.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
  		reslut=EntityUtils.toString(res.getEntity());
		}
      return reslut;
  }
  
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.util.HttpUtil
 * JD-Core Version:    0.6.0
 */