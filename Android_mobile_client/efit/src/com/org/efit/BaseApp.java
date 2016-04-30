package com.org.efit;

import java.util.HashMap;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
public class BaseApp extends Application {
	private HashMap<String , Object> map= new HashMap<String, Object>();
	public static Context context;
	private static Handler handler;
	public final static String USER_KEY="USER_KEY";
	   public void put(String key,Object object){   
		       map.put(key, object);   
		  }            
	   public Object get(String key){   
		       return map.get(key);   
		}   

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context = getBaseContext();
		handler = new Handler();
	}

	public static void showToast(final int resId) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
			}
		});
	}

	public static void showToast(final String text) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
