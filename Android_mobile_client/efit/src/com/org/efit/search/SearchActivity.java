package com.org.efit.search;

import android.R.integer;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.myqiyi.R;
import com.org.efit.BaseApp;
import com.org.efit.entity.User;
import com.org.efit.util.HttpUtil;
import java.util.HashMap;

public class SearchActivity extends Activity
{
  private String dSize = null;
  private Spinner dSizeSpinner;
  private EditText keyword;
  GridView mHistoryGridView;
  GridView mHotGridView;
  ImageButton mImageButton;
  private String sex = null;
  private Spinner sexSpinner;
  View.OnClickListener submmitListenter = new View.OnClickListener()
  {
    public void onClick(View paramView)
    {
      if ((SearchActivity.this.sex == null) || (SearchActivity.this.tSize == null) || (SearchActivity.this.dSize == null) || (SearchActivity.this.keyword.getText().toString().equals("")))
      {
        SearchActivity.this.popTip("请填写完整");
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("sex", SearchActivity.this.sex);
      localHashMap.put("topSize", SearchActivity.this.tSize);
      localHashMap.put("downSize", SearchActivity.this.dSize);
      localHashMap.put("keyword", SearchActivity.this.keyword.getText().toString());
      localHashMap.put("pageNo", "0");
      Intent localIntent = new Intent();
      localIntent.setClass(SearchActivity.this, ResultActivity.class);
      localIntent.putExtra("hashMap", localHashMap);
      SearchActivity.this.startActivity(localIntent);
    }
  };
  private String tSize = null;
  private Spinner tSizeSpinner;

  private String getKeywords()
  {
    return HttpUtil.sendPostRequest(this,getResources().getString(R.string.url) + "user/match.do?act=getAndroidKeywords", null);
  }


private void prepareView()
  {
    String[] arrayOfString = getKeywords().split(",");
    TableLayout localTableLayout = (TableLayout)findViewById(R.id.TableLayout01 );
    localTableLayout.setStretchAllColumns(true);
//    int i = 0;
//    int j = 0;
//    if (j >= 3)
//      return;
    int j=0;
    for (int k = 0; k < 3; k++) {
    	TableRow localTableRow = new TableRow(this);
    	   for (int i = 0; i < 3; i++) {
    		   TextView localTextView = new TextView(this);
    			if (j<arrayOfString.length) {
        	       	 localTextView.setText(arrayOfString[j]);
        	         localTextView.setOnClickListener(new View.OnClickListener()
        	         {
        	           public void onClick(View paramView)
        	           {
        	             TextView localTextView = (TextView)paramView;
        	             SearchActivity.this.keyword.setText(localTextView.getText());
        	           }
        	         });
        	         j++;
    			}
   	         localTextView.setTextSize(25.0F);
   	         localTableRow.addView(localTextView);
		   }
    	

         localTableLayout.addView(localTableRow, new TableLayout.LayoutParams(-1, -2));
    	
	}
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    User user=(User)((BaseApp)(getApplication())).get(BaseApp.USER_KEY);
    setContentView(R.layout.search_activity_1 );
    prepareView();
    this.sexSpinner = ((Spinner)findViewById(R.id.sexSpinner));
    int post=0;
  //  sexSpinner.setSelection(user.getSex().equals("M")?1:2);
    if(user!=null){
    if(user.getT_size().equals("M")){
    	post=1;
    }
    else post=2;
    }
    sexSpinner.setSelection(post);
    this.tSizeSpinner = ((Spinner)findViewById(R.id.tSizeSpinner ));
    if(user!=null){
    if(user.getT_size().equals("s")){
    	post=1;
    }
    else  if(user.getT_size().equals("m")){
    	post=2;
    }
    else post=3;
    }
    tSizeSpinner.setSelection(post);
    this.dSizeSpinner = ((Spinner)findViewById(R.id.dSizeSpinner ));
    if(user!=null){
    if(user.getD_size().equals("s")){
    	post=1;
    }
    else  if(user.getD_size().equals("m")){
    	post=2;
    }
    else post=3;
    }
    dSizeSpinner.setSelection(post);
    Button localButton = (Button)findViewById(R.id.submmit);
    this.keyword = ((EditText)findViewById(R.id.keyword ));
    this.sexSpinner.setOnItemSelectedListener(new OnItemSelectedListenerImpl1());
    this.tSizeSpinner.setOnItemSelectedListener(new OnItemSelectedListenerImpl2());
    this.dSizeSpinner.setOnItemSelectedListener(new OnItemSelectedListenerImpl3());
    localButton.setOnClickListener(this.submmitListenter);
  }

  public void popTip(String paramString)
  {
    Toast.makeText(this, paramString, 1).show();
  }

  private class OnItemSelectedListenerImpl1
    implements AdapterView.OnItemSelectedListener
  {
    private OnItemSelectedListenerImpl1()
    {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        SearchActivity.this.sex = null;
        return;
      case 1:
        SearchActivity.this.sex = "M";
        return;
      case 2:
      }
      SearchActivity.this.sex = "W";
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
    }
  }

  private class OnItemSelectedListenerImpl2
    implements AdapterView.OnItemSelectedListener
  {
    private OnItemSelectedListenerImpl2()
    {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        SearchActivity.this.tSize = null;
        return;
      case 1:
        SearchActivity.this.tSize = "s";
        return;
      case 2:
        SearchActivity.this.tSize = "m";
        return;
      case 3:
      }
      SearchActivity.this.tSize = "l";
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
    }
  }

  private class OnItemSelectedListenerImpl3
    implements AdapterView.OnItemSelectedListener
  {
    private OnItemSelectedListenerImpl3()
    {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        SearchActivity.this.dSize = null;
        return;
      case 1:
        SearchActivity.this.dSize = "s";
        return;
      case 2:
        SearchActivity.this.dSize = "m";
        return;
      case 3:
      }
      SearchActivity.this.dSize = "l";
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
    }
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.SearchActivity
 * JD-Core Version:    0.6.0
 */