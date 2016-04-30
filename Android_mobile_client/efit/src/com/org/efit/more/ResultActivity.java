package com.org.efit.more;

import android.R.integer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.dream.myqiyi.R;
import com.org.efit.DoCommentActivity;
import com.org.efit.channel.CommentActivity;
import com.org.efit.entity.Clothes;
import com.org.efit.entity.MatchClothes;
import com.org.efit.entity.User;
import com.org.efit.search.DetailsActivity;
import com.org.efit.search.ModelActivity;
import com.org.efit.util.AnalysisJson;
import com.org.efit.util.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
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
        paramContextMenu.add(0, 1, 0, "评论");
      }
    });
  }

  private void jumpToDetailsActivity(int paramInt)
  {
    Log.i("点击", paramInt+"");
    Clothes localClothes = (Clothes)this.adapter.getResultList().get(paramInt);
    if (localClothes == null)
      return;
    HashMap localHashMap = new HashMap();
    Intent localIntent = new Intent();
    localIntent.setClass(this, com.org.efit.more.DetailsActivity.class);
    localIntent.putExtra("clothes", localClothes);
    startActivity(localIntent);
  }

  private void jumpToModelActivity(int paramInt)
  {
    Log.i("点击", paramInt+"");
    Clothes clothes = (Clothes)this.adapter.getResultList().get(paramInt);
    if (clothes == null)
      return;

    Intent localIntent = new Intent();
    localIntent.setClass(this, CommentActivity.class);
    localIntent.putExtra("shareId", clothes.getClothesId());
    startActivity(localIntent);
  }

private void loadMoreData()
  {
    Log.i("loadMoreData", "加载");
    this.hashMap.put("pageNo", ""+(1 + Integer.parseInt((String)this.hashMap.get("pageNo"))));
    JSONObject localJSONObject = AnalysisJson.AnalysisJSONObject(sendRequest());
    Log.i("loadMoreData", localJSONObject.toString());
    this.recordCount = AnalysisJson.getInt(localJSONObject, "recordCount");
  JSONArray jsonArray= AnalysisJson.StringToJSONArray(AnalysisJson.getString(localJSONObject, "jsonArray"));
  List<Clothes> localList=new ArrayList<Clothes>();
  if (jsonArray==null) {
	return;
   }
     for(int i=0;i<jsonArray.length();i++){
    	 Clothes clothes=new Clothes();
    	 JSONObject jObject;
		try {
			jObject = jsonArray.getJSONObject(i);
		} catch (JSONException e) {
			
			e.printStackTrace();
			continue;
		}
    	 clothes.setClothesId(AnalysisJson.getString(jObject, "clotesId"));
    	 clothes.setClothesName(AnalysisJson.getString(jObject, "clothesName"));
    	 clothes.setType(AnalysisJson.getString(jObject, "type").endsWith("D")?"下身":"上身");
    	 clothes.setSex(AnalysisJson.getString(jObject, "sex").endsWith("M")?"男":"女");
    	 clothes.setSize(AnalysisJson.getString(jObject, "size"));
    	 clothes.setBrand(AnalysisJson.getString(jObject, "brand"));
    	 clothes.setDetail(AnalysisJson.getString(jObject, "detail"));
    	 clothes.setThumbAdress(AnalysisJson.getString(jObject, "thumbAdress"));
    	 clothes.setImageAdress(AnalysisJson.getString(jObject, "imageAdress"));
    	 clothes.setMatchValue(AnalysisJson.getInt(jObject, "matchValue"));
    	 clothes.setSubmitTime(AnalysisJson.getString(jObject, "subTime"));
    	 clothes.setPosition(AnalysisJson.getString(jObject, "position"));
    	 String ts=AnalysisJson.getString(jObject, "score");
  
    	 clothes.setScore(ts==null?"":ts);
    	 localList.add(clothes);
     }
    Log.i("huoqu", jsonArray.toString());
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
        ResultActivity.this.jumpToDetailsActivity(paramInt);
      }
    });
  }

  private String sendRequest()
  {
    String str = HttpUtil.sendPostRequest(this,getResources().getString(R.string.url) + "user/clothes.do?act=getAndroidClothes", this.hashMap);
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
   //Button button=  ((Button)findViewById(R.id.comment_btn));
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