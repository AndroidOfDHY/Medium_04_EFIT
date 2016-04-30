package com.org.efit.channel;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.myqiyi.R;
import com.org.efit.DoCommentActivity;
import com.org.efit.util.AnalysisJson;
import com.org.efit.util.HttpUtil;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class CommentActivity extends Activity
{
  private CommentListAdapter adapter;
  private Handler handler = new Handler();
  private HashMap<String, String> hashMap = new HashMap();
  private Button loadMoreButton;
  private View loadMoreView;
  private ListView mListView;
  TextView mTitleView;
  private Integer recordCount;
  private String shareId;
  private void loadMoreData()
  {
    Log.i("loadMoreData", "加载");
    this.hashMap.put("pageNo", ""+(1 + Integer.parseInt((String)this.hashMap.get("pageNo"))));
    String str = sendRequest();
    Log.i("获取的字符串", str);
    JSONObject localJSONObject = AnalysisJson.AnalysisJSONObject(str);
    this.recordCount = AnalysisJson.getInt(localJSONObject, "recordCount");
    List localList = AnalysisJson.JSONArrayToList3(AnalysisJson.getString(localJSONObject, "jsonArray"));
    Log.i("huoqu", AnalysisJson.getString(localJSONObject, "jsonArray"));
    this.adapter.addMore(localList);
    Log.i("ccf_count", adapter.getCount()+","+recordCount.intValue()+"");
    if (this.adapter.getCount() >= this.recordCount.intValue())
      this.mListView.removeFooterView(this.loadMoreView);
  }

  private void prepareView()
  {
	  findViewById(R.id.comment_btn).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			intent.setClass(CommentActivity.this,DoCommentActivity.class);
			intent.putExtra("id", shareId);
			startActivity(intent);
			
		}
	});
    this.hashMap.put("pageNo", "0");
    this.adapter = new CommentListAdapter(this);
    this.loadMoreView = getLayoutInflater().inflate(R.layout.loading_more , null);
    this.loadMoreButton = ((Button)this.loadMoreView.findViewById(R.id.moreBtn ));
    this.loadMoreButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        CommentActivity.this.loadMoreButton.setText("正在加载中...");
        CommentActivity.this.handler.postDelayed(new Runnable()
        {
          public void run()
          {
            CommentActivity.this.loadMoreData();
            CommentActivity.this.adapter.notifyDataSetChanged();
            CommentActivity.this.loadMoreButton.setText("查看更多...");
          }
        }
        , 2000L);
      }
    });
    this.mListView = ((ListView)findViewById(R.id.commentListView));
    this.mListView.addFooterView(this.loadMoreView);
    this.mListView.setAdapter(this.adapter);
    loadMoreData();
  }

  private String sendRequest()
  {
    String str = HttpUtil.sendPostRequest(this,getResources().getString(R.string.url) + "user/comment.do?act=androidContent", hashMap);
    if (str == null)
    {
      popTip("结果为空");
      str = null;
    }
    return str;
  }

  protected void onCreate(Bundle paramBundle)
  {
    setContentView(R.layout.comment);
    super.onCreate(paramBundle);
    Intent intent=getIntent();
    shareId= intent.getStringExtra("shareId");
    hashMap.put("shareId", shareId);
    prepareView();
  }

  public void popTip(String paramString)
  {
    Toast.makeText(this, paramString, 1).show();
    
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.channel.CommentActivity
 * JD-Core Version:    0.6.0
 */