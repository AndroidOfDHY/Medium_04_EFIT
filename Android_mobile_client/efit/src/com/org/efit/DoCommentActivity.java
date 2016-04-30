package com.org.efit;

import java.util.HashMap;
import java.util.Map;

import com.dream.myqiyi.R;
import com.org.efit.util.HttpUtil;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DoCommentActivity extends Activity {
	  String id=null;
  @Override

protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
    setContentView(R.layout.comment_activity);
    Intent intent=getIntent();
    id= intent.getStringExtra("id");
   findViewById(R.id.submmit).setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		int score=((Spinner)findViewById(R.id.spinnerScore)).getSelectedItemPosition();
		if (score==0) {
			toast("请评分");
			return;
		}
		String content=((TextView)findViewById(R.id.content)).getText().toString();
		if(content.equals("")){
			toast("请评论");
			return;
		}
		HashMap<String, String> hasMap=new HashMap<String, String>();
		hasMap.put("shareId",id );
		hasMap.put("score",score+"");
		hasMap.put("content", content);
	    String str = HttpUtil.sendPostRequest(DoCommentActivity.this,getResources().getString(R.string.url) + "user/comment.do?act=save", hasMap);
	    Log.i("doc", str);
		if(!"200".equals(str)){
			toast("评论失败"+str);
		}
		else {
			toast("评论成功");
		}
	}
});
}
  void toast(String msg){
	  Toast.makeText(this, msg, 1).show();
  }
}
