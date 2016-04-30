package com.org.efit.home;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;

import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.myqiyi.R;
import com.org.efit.clothes.InfoClothes;
import com.org.efit.entity.MatchClothes;
import com.org.efit.login.Login;
import com.org.efit.search.DetailsActivity;
import com.org.efit.search.ModelActivity;
import com.org.efit.util.AnalysisJson;
import com.org.efit.util.HttpUtil;
import com.org.efit.util.ImageUtil;
import com.org.efit.widget.FlowIndicator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends Activity {
	static final int SCROLL_ACTION = 0;
	MyListAdapter adapter;
	String[] groups = { "推荐搭配", "时尚潮流", "个性潮人", "青春阳光", "商务优雅" };
	ExpandableListView mExpandableListView;
	Gallery mGallery;
	GalleryAdapter mGalleryAdapter;
	private ProgressDialog pd; 
//	Handler mHandler = new Handler() {
//		public void handleMessage(Message paramMessage) {
//			super.handleMessage(paramMessage);
//			switch (paramMessage.what) {
//			default:
//				return;
//			case 0:
//			}
//			MotionEvent localMotionEvent1 = MotionEvent.obtain(
//					SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0,
//					89.333336F, 265.33334F, 0);
//			MotionEvent localMotionEvent2 = MotionEvent.obtain(
//					SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1,
//					300.0F, 238.00003F, 0);
//			HomeActivity.this.mGallery.onFling(localMotionEvent1,
//					localMotionEvent2, -1300.0F, 0.0F);
//		}
//	};
	private Handler handler =new Handler(){ 
		@Override
		//当有消息发送出来的时候就执行Handler的这个方法 
		public void handleMessage(Message msg){ 
		super.handleMessage(msg); 
		//只要执行到这里就关闭对话框 
		pd.dismiss(); 
		} 
		};
	FlowIndicator mMyView;
	Timer mTimer;
	int[] tags = new int[5];

	private void jumpToDetailsActivity(int paramInt1, int paramInt2) {
		MatchClothes localMatchClothes = this.adapter.getResultList(paramInt1,
				paramInt2);
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

	private void jumpToModelActivity(int paramInt1, int paramInt2) {
		MatchClothes localMatchClothes = this.adapter.getResultList(paramInt1,
				paramInt2);
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

	private void longClickListIteam(View paramView) {
		final int i = ((Integer) paramView.getTag(2131296292)).intValue();
		final int j = ((Integer) paramView.getTag(2131296302)).intValue();
		Log.i("TAG", "groupPos:" + i + ",childPos:" + j);
		new AlertDialog.Builder(this).setItems(new String[] { "查看", "试穿" },
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						if (which == 0) {
							HomeActivity.this.jumpToDetailsActivity(i, j);
						} else {
							HomeActivity.this.jumpToModelActivity(i, j);
						}
					}
				}).show();
	}

	private void prepareView() {
		this.mExpandableListView = ((ExpandableListView) findViewById(R.id.expandableListView1));

		ArrayList localArrayList = new ArrayList();
		
		String msg = sendRequest(null);
		
		List localList =new ArrayList();
		if (msg != null&&!msg.equals("")) {

		   localList = AnalysisJson.JSONArrayToList(msg);
		}
		
			Log.i("localList.size()", localList.size() + "");
			localArrayList.add(localList);
			localArrayList.add(localList);
			localArrayList.add(localList);
			localArrayList.add(localList);
			localArrayList.add(localList);
		
		this.adapter = new MyListAdapter(localArrayList, this);
		View localView = LayoutInflater.from(this).inflate(
				R.layout.header_view, null);
		this.mGallery = ((Gallery) localView.findViewById(R.id.home_gallery));
		this.mMyView = ((FlowIndicator) localView.findViewById(R.id.myView));
		this.mGalleryAdapter = new GalleryAdapter(this);
		this.mMyView.setCount(this.mGalleryAdapter.getCount());
		this.mGallery.setAdapter(this.mGalleryAdapter);
		this.mExpandableListView.addHeaderView(localView);
		this.mExpandableListView.setAdapter(this.adapter);
		this.mExpandableListView
				.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
					public boolean onChildClick(
							ExpandableListView paramExpandableListView,
							View paramView, int paramInt1, int paramInt2,
							long paramLong) {
						int i = ((Integer) paramView.getTag(2131296292))
								.intValue();
						int j = ((Integer) paramView.getTag(2131296302))
								.intValue();
						HomeActivity.this.jumpToModelActivity(i, j);
						return false;
					}
				});
		
		this.mExpandableListView
				.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
					public boolean onItemLongClick(
							AdapterView<?> paramAdapterView, View paramView,
							int paramInt, long paramLong) {
						HomeActivity.this.longClickListIteam(paramView);
						return true;
					}
				});
		
	}

	private String sendRequest(HashMap paramHashMap) {
		Log.i("ccf", getResources().getString(R.string.url));
		String str = HttpUtil.sendPostRequest(this,
				getResources().getString(R.string.url)
						+ "user/match.do?act=androidRecommend", paramHashMap);
		if (str == null) {
			popTip("结果为空");
			str = null;
		}
		return str;
	}

	public void Info_Clothes(View paramView) {
		Intent localIntent = new Intent();
		localIntent.setClass(this, InfoClothes.class);
		startActivity(localIntent);
	}

	public void login(View paramView) {
		Intent localIntent = new Intent();
		localIntent.setClass(this, Login.class);
		startActivity(localIntent);
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.home_activity);
		
		prepareView();
		
		//this.mTimer = new Timer();
		//this.mTimer.scheduleAtFixedRate(new MyTask(), 0L, 5000L);
	}

	public void popTip(String paramString) {
		Toast.makeText(this, paramString, 1).show();
	}

	class MyListAdapter extends BaseExpandableListAdapter {
		List<List<MatchClothes>> arrayList;
		Context context;

		public MyListAdapter(ArrayList localObject1, Context arg2) {
			// Object localObject2;
			this.context = arg2;
			// Object localObject1;
			this.arrayList = localObject1;
		}

		public Object getChild(int paramInt1, int paramInt2) {
			return ((List) this.arrayList.get(paramInt1)).get(paramInt2);
		}

		public long getChildId(int paramInt1, int paramInt2) {
			return paramInt2;
		}

		public View getChildView(int paramInt1, int paramInt2,
				boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
			Log.i("tag11111", paramInt1 + "");
			MatchClothes localMatchClothes = null;
			String str = null;
			if (paramView == null) {

				paramView = LayoutInflater.from(HomeActivity.this).inflate(
						R.layout.list_result_item, null);
			}
			localMatchClothes = (MatchClothes) ((List) this.arrayList
					.get(paramInt1)).get(paramInt2);
			paramView.setTag(2131296292, Integer.valueOf(paramInt1));
			paramView.setTag(2131296302, Integer.valueOf(paramInt2));
			str = this.context.getResources().getString(R.string.url);
			Bitmap localBitmap1 = HttpUtil.getHttpBitmap(str + "clothes/"
					+ localMatchClothes.gettThumbAdress());
			if (localBitmap1 != null) {
				((ImageView) paramView.findViewById(R.id.imageView1))
						.setImageBitmap(ImageUtil.createBitmapThumbnail(
								localBitmap1, 144, 216));
			}

			Bitmap localBitmap2 = HttpUtil.getHttpBitmap(str + "clothes/"
					+ localMatchClothes.getdThumbAdress());
			if (localBitmap2 != null) {
				((ImageView) paramView.findViewById(R.id.imageView3))
						.setImageBitmap(ImageUtil.createBitmapThumbnail(
								localBitmap2, 144, 216));
			}
			return paramView;
		}

		public int getChildrenCount(int paramInt) {
			List children = (List) this.arrayList.get(paramInt);
			int count = children.size();
			return count;
		}

		public Object getGroup(int paramInt) {
			return HomeActivity.this.groups[paramInt];
		}

		public int getGroupCount() {
			return HomeActivity.this.groups.length;
		}

		public long getGroupId(int paramInt) {
			return paramInt;
		}

		public View getGroupView(int paramInt, boolean paramBoolean,
				View paramView, ViewGroup paramViewGroup) {
			
			GroupHolder localGroupHolder;
			if (paramView == null) {
				paramView = LayoutInflater.from(HomeActivity.this).inflate(
						R.layout.list_group_item, null);
				localGroupHolder = new GroupHolder();
				localGroupHolder.img = ((ImageView) paramView
						.findViewById(R.id.tag_img));
				localGroupHolder.title = ((TextView) paramView
						.findViewById(R.id.title_view));
				paramView.setTag(localGroupHolder);
				if (HomeActivity.this.tags[paramInt] != 0)
					localGroupHolder.img
							.setImageResource(R.drawable.list_indecator_button);
				localGroupHolder.title
						.setText(HomeActivity.this.groups[paramInt]);
			}
			paramView.setTag(2131296292, Integer.valueOf(paramInt));
			paramView.setTag(2131296302, Integer.valueOf(-1));
			return paramView;
			// localGroupHolder = (GroupHolder)paramView.getTag();
		}

		public MatchClothes getResultList(int paramInt1, int paramInt2) {
			return (MatchClothes) ((List) this.arrayList.get(paramInt1))
					.get(paramInt2);
		}

		public boolean hasStableIds() {
			return true;
		}

		public boolean isChildSelectable(int paramInt1, int paramInt2) {
			return true;
		}


		class GroupHolder {
			ImageView img;
			TextView title;

			GroupHolder() {
			}
		}
	}

//	private class MyTask extends TimerTask {
//		private MyTask() {
//		}
//
//		public void run() {
//			HomeActivity.this.mHandler.sendEmptyMessage(0);
//		}
//	}
}

