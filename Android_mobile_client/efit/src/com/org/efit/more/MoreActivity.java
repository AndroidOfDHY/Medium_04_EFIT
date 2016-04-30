package com.org.efit.more;

import java.util.HashMap;

import com.dream.myqiyi.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MoreActivity extends Activity {

	  private String dSize = "";
	  private Spinner dSizeSpinner;
	  private EditText keyword;
	  GridView mHistoryGridView;
	  GridView mHotGridView;
	  ImageButton mImageButton;
	  private String sex = "";
	  private Spinner sexSpinner;
	  View.OnClickListener submmitListenter = new View.OnClickListener()
	  {
	    @SuppressWarnings("unchecked")
		public void onClick(View paramView)
	    {
	      HashMap localHashMap = new HashMap();
	      localHashMap.put("sex", MoreActivity.this.sex);
	      localHashMap.put("type", MoreActivity.this.tSize);
	      localHashMap.put("size", MoreActivity.this.dSize);
	      localHashMap.put("searchKey", MoreActivity.this.keyword.getText().toString());
	      localHashMap.put("pageNo", "0");
	      Intent localIntent = new Intent();
	      localIntent.setClass(MoreActivity.this, com.org.efit.more.ResultActivity.class);
	      localIntent.putExtra("hashMap", localHashMap);
	      MoreActivity.this.startActivity(localIntent);
	    }
	  };
	  private String tSize = "";
	  private Spinner tSizeSpinner;






	  protected void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle);
	    setContentView(R.layout.search_activity_2);
	    this.sexSpinner = ((Spinner)findViewById(R.id.sexSpinner));
        
	    this.tSizeSpinner = ((Spinner)findViewById(R.id.tSizeSpinner ));

	    this.dSizeSpinner = ((Spinner)findViewById(R.id.dSizeSpinner ));

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
	        MoreActivity.this.sex = "";
	        return;
	      case 1:
	        MoreActivity.this.sex = "M";
	        return;
	      case 2:
	      }
	      MoreActivity.this.sex = "W";
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
	        MoreActivity.this.tSize = "";
	        return;
	      case 1:
	        MoreActivity.this.tSize = "T";
	        return;
	      case 2:
	        MoreActivity.this.tSize = "D";
	        return;
	      }
	      
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
	        MoreActivity.this.dSize = "";
	        return;
	      case 1:
	        MoreActivity.this.dSize = "s";
	        return;
	      case 2:
	        MoreActivity.this.dSize = "m";
	        return;
	      case 3:
	      }
	      MoreActivity.this.dSize = "l";
	    }

	    public void onNothingSelected(AdapterView<?> paramAdapterView)
	    {
	    }
	  }	
	
	
//	TextView mTitleView;
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		//super.onCreate(savedInstanceState);
//		//setContentView(R.layout.more_info);
//		//prepareView();
//		//mTitleView.setText(R.string.category_more);
//	}

}
