package com.org.efit.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.HashMap;

import com.dream.myqiyi.R;

public class DetailsActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.details_clothes);
    HashMap localHashMap = (HashMap)getIntent().getSerializableExtra("hashMap");
    String str1 = (String)localHashMap.get("tName");
    String str2 = (String)localHashMap.get("dName");
    TextView localTextView1 = (TextView)findViewById(R.id.titleText );
    TextView localTextView2 = (TextView)findViewById(R.id.topName );
    TextView localTextView3 = (TextView)findViewById(R.id.downName );
    TextView localTextView4 = (TextView)findViewById(R.id.topText );
    TextView localTextView5 = (TextView)findViewById(R.id.downText );
    TextView localTextView6 = (TextView)findViewById(R.id.sexView );
    localTextView1.setText(str1 + "&" + str2);
    localTextView2.setText(str1);
    localTextView3.setText(str2);
    localTextView4.setText((CharSequence)localHashMap.get("tDetail"));
    localTextView5.setText((CharSequence)localHashMap.get("dDetail"));
    localTextView6.setText((CharSequence)localHashMap.get("sex"));
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.DetailsActivity
 * JD-Core Version:    0.6.0
 */