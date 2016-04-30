package com.org.efit.channel;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.org.efit.entity.Share;
import com.org.efit.util.AnalysisJson;
import com.org.efit.util.HttpUtil;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ChannelActivity extends Activity
{
  private ChannelListAdapter adapter;
  private Handler handler = new Handler();
  private HashMap<String, String> hashMap = new HashMap();
  private Button loadMoreButton;
  private View loadMoreView;
  private ListView mListView;
  TextView mTitleView;
  private Integer recordCount;

  private void ItemOnLongClick()
  {
    this.mListView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        paramContextMenu.add(0, 0, 0, "查看大图");
        paramContextMenu.add(0, 1, 0, "查看评论");
      }
    });
  }

  private void jumpToCommentActivity(int paramInt)
  {
    Share localShare = (Share)this.adapter.getResultList().get(paramInt);
    Intent localIntent = new Intent();
    localIntent.setClass(this, CommentActivity.class);
    localIntent.putExtra("shareId", localShare.getShareId());
    startActivity(localIntent);
  }

  private void jumpToModelActivity(int paramInt)
  {
    Share localShare = (Share)this.adapter.getResultList().get(paramInt);
    Intent localIntent = new Intent();
    localIntent.setClass(this, ModelActivity.class);
    localIntent.putExtra("url", localShare.getSharePath());
    startActivity(localIntent);
  }

  private void loadMoreData()
  {
    Log.i("loadMoreData", "加载");
    this.hashMap.put("pageNo", (1 + Integer.parseInt((String)this.hashMap.get("pageNo")))+"");
    String str = sendRequest();
    Log.i("获取的字符串", str);
    JSONObject localJSONObject = AnalysisJson.AnalysisJSONObject(str);
    this.recordCount = AnalysisJson.getInt(localJSONObject, "recordCount");
    List localList = AnalysisJson.JSONArrayToList2(AnalysisJson.getString(localJSONObject, "jsonArray"));
    Log.i("huoqu", AnalysisJson.getString(localJSONObject, "jsonArray"));
    this.adapter.addMore(localList);
    
    if (this.adapter.getCount() >= this.recordCount.intValue())
    	
      this.mListView.removeFooterView(this.loadMoreView);
     }

  private void prepareView()
  {
    this.hashMap.put("pageNo", "0");
    this.adapter = new ChannelListAdapter(this);
    this.loadMoreView = getLayoutInflater().inflate(com.dream.myqiyi.R.layout.loading_more, null);
    this.loadMoreButton = ((Button)this.loadMoreView.findViewById(com.dream.myqiyi.R.id.moreBtn));
    this.loadMoreButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        ChannelActivity.this.loadMoreButton.setText("正在加载中...");
        ChannelActivity.this.handler.postDelayed(new Runnable()
        {
          public void run()
          {
            ChannelActivity.this.loadMoreData();
            ChannelActivity.this.adapter.notifyDataSetChanged();
            ChannelActivity.this.loadMoreButton.setText("查看更多...");
          }
        }
        , 2000L);
      }
    });
    this.mListView = ((ListView)findViewById(com.dream.myqiyi.R.id.searchResultListView));
    this.mListView.addFooterView(this.loadMoreView);
    this.mListView.setAdapter(this.adapter);
    loadMoreData();
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        ChannelActivity.this.jumpToModelActivity(paramInt);
      }
    });
  }

  private String sendRequest()
  {
    String str = HttpUtil.sendPostRequest(this,getResources().getString(com.dream.myqiyi.R.string.url) + "user/share.do?act=androidShareList", null);

    if (str == null)
    {
      popTip("结果为空");
      str = null;
    }
    return str;
  }
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    switch (paramMenuItem.getItemId())
    {
    
    case 0:
    	jumpToModelActivity(localAdapterContextMenuInfo.position);
    	break;
    case 1:
    	 jumpToCommentActivity(localAdapterContextMenuInfo.position);
    	 break;
    default:break;
    }
    return true;
  }
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(com.dream.myqiyi.R.layout.channel);
    prepareView();
    ItemOnLongClick();
  }

  public void popTip(String paramString)
  {
    Toast.makeText(this, paramString, 1).show();
  }
}
