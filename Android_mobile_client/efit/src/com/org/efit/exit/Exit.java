package com.org.efit.exit;


import com.dream.myqiyi.R;
import com.org.efit.MainActivity;
import com.org.efit.util.HttpUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Exit extends Activity {
	//private MyDialog dialog;
	private LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.exit_dialog);
		//dialog=new MyDialog(this);
		layout=(LinearLayout)findViewById(R.id.exit_layout);
		layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Toast.makeText(getApplicationContext(), "提示：点击窗口外部关闭窗口！", 
						Toast.LENGTH_SHORT).show();	
			}
		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
	
	public void exitbutton1(View v) {  
    	this.finish();    	
      }  
	public void exitbutton0(View v) {  
		Log.i("KEYCODE_BACK", "退出");
		HttpUtil.sendPostRequest(getResources().getString(R.string.url)+ "user/user.do?act=androidQuit", null);
    	this.finish();
    	MainActivity.instance.finish();//关闭Main 这个Activity
      }  
	
}
