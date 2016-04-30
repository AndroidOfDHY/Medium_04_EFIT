package com.org.efit;



import com.dream.myqiyi.R;
import com.org.efit.account.AccountActivity;
import com.org.efit.channel.ChannelActivity;
import com.org.efit.exit.Exit;
import com.org.efit.home.HomeActivity;
import com.org.efit.login.Welcome;
import com.org.efit.more.MoreActivity;
import com.org.efit.search.SearchActivity;
import com.org.efit.util.HttpUtil;


import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends TabActivity implements OnClickListener {
	public static MainActivity instance = null;
	private LinearLayout mClose;
    private LinearLayout mCloseBtn;
	private long exitTime = 0; 
	private View layout;	
	private boolean menu_display = false;
	private PopupWindow menuWindow;
	private LayoutInflater inflater;
	public static String TAB_TAG_HOME = "home";
	public static String TAB_TAG_CHANNEL = "channel";
	public static String TAB_TAG_ACCOUNT = "account";
	public static String TAB_TAG_SEARCH = "search";
	public static String TAB_TAB_MORE = "more";
	public static TabHost mTabHost;
	static final int COLOR1 = Color.parseColor("#787878");
	static final int COLOR2 = Color.parseColor("#ffffff");
	ImageView mBut1, mBut2, mBut3, mBut4, mBut5;
	TextView mCateText1, mCateText2, mCateText3, mCateText4, mCateText5;

	Intent mHomeItent, mChannelIntent, mSearchIntent, mAccountIntent,
			mMoreIntent;

	int mCurTabId = R.id.channel1;

	// Animation
	private Animation left_in, left_out;
	private Animation right_in, right_out;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
        instance = this;
		prepareAnim();
		prepareIntent();
		setupIntent();
		prepareView();
	}

	private void prepareAnim() {
		left_in = AnimationUtils.loadAnimation(this, R.anim.left_in);
		left_out = AnimationUtils.loadAnimation(this, R.anim.left_out);

		right_in = AnimationUtils.loadAnimation(this, R.anim.right_in);
		right_out = AnimationUtils.loadAnimation(this, R.anim.right_out);
	}

	private void prepareView() {
		mBut1 = (ImageView) findViewById(R.id.imageView1);
		mBut2 = (ImageView) findViewById(R.id.imageView2);
		mBut3 = (ImageView) findViewById(R.id.imageView3);
		mBut4 = (ImageView) findViewById(R.id.imageView4);
		mBut5 = (ImageView) findViewById(R.id.imageView5);
		findViewById(R.id.channel1).setOnClickListener(this);
		findViewById(R.id.channel2).setOnClickListener(this);
		findViewById(R.id.channel3).setOnClickListener(this);
		findViewById(R.id.channel4).setOnClickListener(this);
		findViewById(R.id.channel5).setOnClickListener(this);
		mCateText1 = (TextView) findViewById(R.id.textView1);
		mCateText2 = (TextView) findViewById(R.id.textView2);
		mCateText3 = (TextView) findViewById(R.id.textView3);
		mCateText4 = (TextView) findViewById(R.id.textView4);
		mCateText5 = (TextView) findViewById(R.id.textView5);
	}

	private void prepareIntent() {
		mHomeItent = new Intent(this, HomeActivity.class);
		mChannelIntent = new Intent(this, ChannelActivity.class);
		mAccountIntent = new Intent(this, AccountActivity.class);
		mSearchIntent = new Intent(this, SearchActivity.class);
		mMoreIntent = new Intent(this, MoreActivity.class);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

			mBut1.performClick();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
		
	}

	private void setupIntent() {
		mTabHost = getTabHost();
		mTabHost.addTab(buildTabSpec(TAB_TAG_HOME, R.string.category_home,
				R.drawable.icon_1_n, mHomeItent));
		mTabHost.addTab(buildTabSpec(TAB_TAG_CHANNEL,
				R.string.category_channel, R.drawable.icon_2_n, mChannelIntent));
		mTabHost.addTab(buildTabSpec(TAB_TAG_SEARCH, R.string.category_search,
				R.drawable.icon_3_n, mSearchIntent));
		mTabHost.addTab(buildTabSpec(TAB_TAG_ACCOUNT,
				R.string.category_account, R.drawable.icon_4_n, mAccountIntent));
		mTabHost.addTab(buildTabSpec(TAB_TAB_MORE, R.string.category_more,
				R.drawable.icon_5_n, mMoreIntent));
	}

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return mTabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),
						getResources().getDrawable(resIcon))
				.setContent(content);
	}

	public static void setCurrentTabByTag(String tab) {
		mTabHost.setCurrentTabByTag(tab);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (mCurTabId == v.getId()) {
			return;
		}
		mBut1.setImageResource(R.drawable.icon_1_n);
		mBut2.setImageResource(R.drawable.icon_2_n);
		mBut3.setImageResource(R.drawable.icon_3_n);
		mBut4.setImageResource(R.drawable.icon_4_n);
		mBut5.setImageResource(R.drawable.icon_5_n);
		mCateText1.setTextColor(COLOR1);
		mCateText2.setTextColor(COLOR1);
		mCateText3.setTextColor(COLOR1);
		mCateText4.setTextColor(COLOR1);
		mCateText5.setTextColor(COLOR1);
		int checkedId = v.getId();
		final boolean o;
		if (mCurTabId < checkedId)
			o = true;
		else
			o = false;
		if (o)
			mTabHost.getCurrentView().startAnimation(left_out);
		else
			mTabHost.getCurrentView().startAnimation(right_out);
		switch (checkedId) {
		case R.id.channel1:
			mTabHost.setCurrentTabByTag(TAB_TAG_HOME);
			mBut1.setImageResource(R.drawable.icon_1_c);
			mCateText1.setTextColor(COLOR2);
			break;
		case R.id.channel2:
			mTabHost.setCurrentTabByTag(TAB_TAG_CHANNEL);
			mBut2.setImageResource(R.drawable.icon_2_c);
			mCateText2.setTextColor(COLOR2);
			break;
		case R.id.channel3:
			mTabHost.setCurrentTabByTag(TAB_TAG_SEARCH);
			mBut3.setImageResource(R.drawable.icon_3_c);
			mCateText3.setTextColor(COLOR2);
			break;
		case R.id.channel4:
			mTabHost.setCurrentTabByTag(TAB_TAG_ACCOUNT);
			mBut4.setImageResource(R.drawable.icon_4_c);
			mCateText4.setTextColor(COLOR2);
			break;
		case R.id.channel5:
			mTabHost.setCurrentTabByTag(TAB_TAB_MORE);
			mBut5.setImageResource(R.drawable.icon_5_c);
			mCateText5.setTextColor(COLOR2);
			break;
		default:
			break;
		}

		if (o)
			mTabHost.getCurrentView().startAnimation(left_in);
		else
			mTabHost.getCurrentView().startAnimation(right_in);
		mCurTabId = checkedId;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
   	if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 && event.getAction() == KeyEvent.ACTION_DOWN) {  //获取 back键
    		
        	if(menu_display){         //如果 Menu已经打开 ，先关闭Menu
        		menuWindow.dismiss();
        		menu_display = false;
        		}
        	else {
        		Intent intent = new Intent();
            	intent.setClass(MainActivity.this,Exit.class);
            	startActivity(intent);
        	}
    	}
    	
    	else if(event.getKeyCode() == KeyEvent.KEYCODE_MENU && event.getAction() == KeyEvent.ACTION_DOWN){   //获取 Menu键			
			if(!menu_display){
				//获取LayoutInflater实例
				inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
				//这里的main布局是在inflate中加入的哦，以前都是直接this.setContentView()的吧？呵呵
				//该方法返回的是一个View的对象，是布局中的根
				layout = inflater.inflate(R.layout.main_menu, null);
				
				//下面我们要考虑了，我怎样将我的layout加入到PopupWindow中呢？？？很简单
				menuWindow = new PopupWindow(layout,LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT); //后两个参数是width和height
				//menuWindow.showAsDropDown(layout); //设置弹出效果
				//menuWindow.showAsDropDown(null, 0, layout.getHeight());
				menuWindow.showAtLocation(this.findViewById(R.id.mainweixin), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
				//如何获取我们main中的控件呢？也很简单
				mClose = (LinearLayout)layout.findViewById(R.id.menu_close);
				mCloseBtn = (LinearLayout)layout.findViewById(R.id.menu_close_btn);
				
				
				//下面对每一个Layout进行单击事件的注册吧。。。
				//比如单击某个MenuItem的时候，他的背景色改变
				//事先准备好一些背景图片或者颜色
				mCloseBtn.setOnClickListener (new View.OnClickListener() {					
					@Override
					public void onClick(View arg0) {						
						//Toast.makeText(Main.this, "退出", Toast.LENGTH_LONG).show();
						Intent intent = new Intent();
			        	intent.setClass(MainActivity.this,Exit.class);
			        	startActivity(intent);
			        	menuWindow.dismiss(); //响应点击事件之后关闭Menu
					}
				});				
				menu_display = true;				
			}else{
				//如果当前已经为显示状态，则隐藏起来
				menuWindow.dismiss();
				menu_display = false;
				}
			
			return false;
		}
    	return false;
	/*	
		if(event.getKeyCode() == KeyEvent.KEYCODE_BACK 
			   && event.getAction() == KeyEvent.ACTION_DOWN){ 
	     if((System.currentTimeMillis()-exitTime) > 2000){ 
	         Toast.makeText(getApplicationContext(), "再按一次退出系统", Toast.LENGTH_SHORT).show(); 
	         exitTime = System.currentTimeMillis(); 
	  } else { 
		  onDestroy();
	   finish(); 
	  // Welcome.wel.finish();
	   System.exit(0); 
	  } 
	     return true; 
	    } */
	//return super.onKeyDown(event.getKeyCode(), event); 
	//return super.dispatchKeyEvent(event);
	}

}