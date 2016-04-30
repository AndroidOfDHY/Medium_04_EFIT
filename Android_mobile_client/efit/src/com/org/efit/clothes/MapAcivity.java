package com.org.efit.clothes;

import com.dream.myqiyi.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MapAcivity extends Activity {
   @Override
protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);
	setContentView(R.layout.map);

	((ImageView) findViewById(R.id.map)).setImageResource(R.drawable.map);
}
}
