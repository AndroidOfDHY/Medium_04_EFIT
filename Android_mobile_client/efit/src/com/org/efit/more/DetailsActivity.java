package com.org.efit.more;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;

import com.dream.myqiyi.R;
import com.org.efit.clothes.InfoClothes;
import com.org.efit.clothes.MapAcivity;
import com.org.efit.entity.Clothes;
import com.org.efit.util.HttpUtil;
import com.org.efit.util.ImageUtil;

public class DetailsActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.info_clothes);
    Clothes clothes = (Clothes)getIntent().getSerializableExtra("clothes");
//    String str1 = (String)localHashMap.get("tName");
//    String str2 = (String)localHashMap.get("dName");
    ((Button) findViewById(R.id.daoGou)).setOnClickListener(new OnClickListener() {
		
 		@Override
 		public void onClick(View v) {
 			Log.i("asdasd", "adsasdasdasdasfdfdf");
 			setContentView(R.layout.map);
 		   ProgressDialog pd=ProgressDialog.show(DetailsActivity.this, "Load", "Loading…"); 
 		   try {
 			Thread.sleep(3000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		   pd.dismiss();
 		    Intent localIntent = new Intent();
 		    localIntent.setClass(DetailsActivity.this, MapAcivity.class);
 		    startActivity(localIntent);
 			
 		}
 	});
    String str = this.getResources().getString(R.string.url);
    
    Bitmap localBitmap1 = HttpUtil.getHttpBitmap(str + "clothes/" + clothes.getThumbAdress());
    ((ImageView)findViewById(R.id.clothesPic )).setImageBitmap(ImageUtil.createBitmapThumbnail(localBitmap1, localBitmap1.getWidth()/3, localBitmap1.getHeight()/3));
    ((TextView)findViewById(R.id.clothesName )).setText(clothes.getClothesName());
    ((TextView)findViewById(R.id.size )).setText(clothes.getSize());
    ((TextView)findViewById(R.id.sex )).setText(clothes.getSex());
    ((TextView)findViewById(R.id.type )).setText(clothes.getType());
    ((TextView)findViewById(R.id.brand )).setText(clothes.getBrand());
    ((TextView)findViewById(R.id.score )).setText(clothes.getScore());
    ((TextView)findViewById(R.id.detail )).setText(clothes.getDetail());
    ((TextView)findViewById(R.id.time )).setText(clothes.getSubmitTime());
    ((TextView)findViewById(R.id.position )).setText(clothes.getPosition());
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.DetailsActivity
 * JD-Core Version:    0.6.0
 */