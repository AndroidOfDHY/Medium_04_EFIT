package com.example.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.ideatech.common.MyLog;


import sun.util.logging.resources.logging;

public class HttpUtil {
	public static String sendPostRequest(String url, HashMap hashMap) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String out="失败";
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
        if(hashMap!=null){
		for (Iterator iter=hashMap.entrySet().iterator();iter.hasNext();) {
		Map.Entry entry = (Entry) iter.next();
		
			pairList.add(new BasicNameValuePair(entry.getKey() + "", entry
					.getValue() + ""));
		}
        }
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(pairList, HTTP.UTF_8));
            MyLog.print("讯运行");
			HttpResponse response = httpClient.execute(httpPost);
			MyLog.print("讯运行2");
			MyLog.print(""+response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode()==200) {
				HttpEntity entity=response.getEntity();
				if (entity!=null) {
					out=EntityUtils.toString(entity);

				}

			}
			httpClient.getConnectionManager().shutdown();
			return out;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static void main(String[] args) {
		HashMap<String  , String> hashMap=new HashMap<String, String>();
		hashMap.put("a", "a");
		System.out.println(sendPostRequest("http://192.168.2.100:8080/efit_select_clothes/user/comment.do?act=content",null));
	}
}
