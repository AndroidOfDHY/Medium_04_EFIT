package com.org.efit.search;

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
import android.widget.Toast;

import com.dream.myqiyi.R;
import com.org.efit.entity.MatchClothes;
import com.org.efit.util.AnalysisJson;
import com.org.efit.util.HttpUtil;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ResultActivity extends Activity
{
  private ResultListAdapter adapter;
  private Handler handler = new Handler();
  private HashMap<String, String> hashMap;
  private Button loadMoreButton;
  private View loadMoreView;
  private ListView mListView;
  private Integer recordCount;

  private void ItemOnLongClick()
  {
    this.mListView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        paramContextMenu.add(0, 0, 0, "查看");
        paramContextMenu.add(0, 1, 0, "试穿");
      }
    });
  }

  private void jumpToDetailsActivity(int paramInt)
  {
    Log.i("点击", paramInt+"");
    MatchClothes localMatchClothes = (MatchClothes)this.adapter.getResultList().get(paramInt);
    if (localMatchClothes == null)
      return;
    HashMap localHashMap = new HashMap();
    localHashMap.put("tName", localMatchClothes.gettName());
    localHashMap.put("tDetail", localMatchClothes.gettDetail());
    localHashMap.put("dName", localMatchClothes.getdName());
    localHashMap.put("dDetail", localMatchClothes.getdDetail());
    localHashMap.put("sex", localMatchClothes.getSex());
    Intent localIntent = new Intent();
    localIntent.setClass(this, DetailsActivity.class);
    localIntent.putExtra("hashMap", localHashMap);
    startActivity(localIntent);
  }

  private void jumpToModelActivity(int paramInt)
  {
    Log.i("点击", paramInt+"");
    MatchClothes localMatchClothes = (MatchClothes)this.adapter.getResultList().get(paramInt);
    if (localMatchClothes == null)
      return;
    HashMap localHashMap = new HashMap();
    localHashMap.put("upperClothes", localMatchClothes.gettImageAdress());
    localHashMap.put("downClothes", localMatchClothes.getdImageAdress());
    localHashMap.put("sex", localMatchClothes.getSex());
    Log.i("topSize", localMatchClothes.gettSize());
    localHashMap.put("topSize", localMatchClothes.gettSize());
    Intent localIntent = new Intent();
    localIntent.setClass(this, ModelActivity.class);
    localIntent.putExtra("hashMap", localHashMap);
    startActivity(localIntent);
  }

  private void loadMoreData()
  {
    Log.i("loadMoreData", "加载");
    this.hashMap.put("pageNo", ""+(1 + Integer.parseInt((String)this.hashMap.get("pageNo"))));
    JSONObject localJSONObject = AnalysisJson.AnalysisJSONObject(sendRequest());
    this.recordCount = AnalysisJson.getInt(localJSONObject, "recordCount");
    List localList = AnalysisJson.JSONArrayToList(AnalysisJson.getString(localJSONObject, "jsonArray"));
    Log.i("huoqu", AnalysisJson.getString(localJSONObject, "jsonArray"));
    this.adapter.addMore(localList);
    if (this.adapter.getCount() >= this.recordCount.intValue())
      this.mListView.removeFooterView(this.loadMoreView);
  }

  private void prepareView()
  {
    this.adapter = new ResultListAdapter(this);
    this.loadMoreView = getLayoutInflater().inflate(R.layout.loading_more , null);
    this.loadMoreButton = ((Button)this.loadMoreView.findViewById(R.id.moreBtn ));
    this.loadMoreButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        ResultActivity.this.loadMoreButton.setText("正在加载中...");
        ResultActivity.this.handler.postDelayed(new Runnable()
        {
          public void run()
          {
            ResultActivity.this.loadMoreData();
            ResultActivity.this.adapter.notifyDataSetChanged();
            ResultActivity.this.loadMoreButton.setText("查看更多...");
            if (ResultActivity.this.adapter.getCount() >= ResultActivity.this.recordCount.intValue())
              ResultActivity.this.mListView.removeFooterView(ResultActivity.this.loadMoreView);
          }
        }
        , 2000L);
      }
    });
    this.mListView = ((ListView)findViewById(R.id.searchResultListView ));
    this.mListView.addFooterView(this.loadMoreView);
    this.mListView.setAdapter(this.adapter);
    loadMoreData();
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        ResultActivity.this.jumpToModelActivity(paramInt);
      }
    });
  }

  private String sendRequest()
  {
    String str = HttpUtil.sendPostRequest(this,getResources().getString(R.string.url) + "user/match.do?act=androidMatch", this.hashMap);
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
    default:
    case 0:
    	jumpToDetailsActivity(localAdapterContextMenuInfo.position);
    	break;
    case 1:
    	jumpToModelActivity(localAdapterContextMenuInfo.position);
    	break;
    }
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(com.dream.myqiyi.R.layout.search_activity_result);
    this.hashMap = ((HashMap)getIntent().getSerializableExtra("hashMap"));
    prepareView();
    ItemOnLongClick();
  }

  public void popTip(String paramString)
  {
    Toast.makeText(this, paramString, 1).show();
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.ResultActivity
 * JD-Core Version:    0.6.0
 */