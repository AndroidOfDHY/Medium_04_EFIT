package com.org.efit.account;


import org.json.JSONObject;

import com.dream.myqiyi.R;
import com.org.efit.BaseApp;
import com.org.efit.entity.User;
import com.org.efit.util.AnalysisJson;
import com.org.efit.util.HttpUtil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_personal);
		prepareView();
		//mTitleView.setText(R.string.category_account);
	}

	private void prepareView() {
		String url =this.  getResources().getString(R.string.url);
		
	//	String msg=HttpUtil.sendPostRequest(url+"user/user.do?act=userDetails", null);
//		JSONObject object=AnalysisJson.AnalysisJSONObject(msg);
//		TextView 	title_text = (TextView) findViewById(R.id.title_text);
//		title_text.setText(AnalysisJson.getString(object, "username"));
		User user=(User)((BaseApp)(getApplication())).get(BaseApp.USER_KEY);
		if(user==null){return;}
		TextView 	username_text = (TextView) findViewById(R.id.username_text);
		//username_text.setText(AnalysisJson.getString(object, "username"));
		username_text.setText(user.getUsername());
		TextView 	sex_text = (TextView) findViewById(R.id.sex_text);
	//	sex_text.setText(AnalysisJson.getString(object, "sex"));
		sex_text.setText(user.getSex());
		TextView 	topSize_text = (TextView) findViewById(R.id.topSize_text);
	//	topSize_text.setText(AnalysisJson.getString(object, "topSize"));
		topSize_text.setText(user.getT_size());
		TextView 	dowSize_text = (TextView) findViewById(R.id.dowSize_text);
		//dowSize_text.setText(AnalysisJson.getString(object, "downSize"));
		dowSize_text.setText(user.getD_size());
		Log.i("urlll", url+user.getHeadAdreess().replace("\\", "/"));
	  Bitmap hBitmap=	HttpUtil.getHttpBitmap(url+user.getHeadAdreess().replace("\\", "/"));
	  
	  if (hBitmap!=null) {
		  Log.i("ccccf", hBitmap.getWidth()+"");
		  ImageView add_head=(ImageView)findViewById(R.id.add_head);
		  add_head.setImageBitmap(hBitmap);
	   }
	  
		
		
	}
	
}
