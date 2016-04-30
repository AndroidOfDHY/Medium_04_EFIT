package com.org.efit.channel;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dream.myqiyi.R;
import com.org.efit.entity.Share;
import com.org.efit.util.HttpUtil;
import com.org.efit.util.ImageUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChannelListAdapter extends BaseAdapter
{
  private Context context;
  private LayoutInflater mInflater;
  private List<Share> resultList = new ArrayList();

  public ChannelListAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public void addMore(List<Share> paramList)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return;
      this.resultList.add((Share)paramList.get(i));
    }
  }

  public int getCount()
  {
    Log.i("数量", this.resultList.size()+"");
    return this.resultList.size();
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public List<Share> getResultList()
  {
    return this.resultList;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Share localShare = (Share)this.resultList.get(paramInt);
    Log.i("图片地址", localShare.getSharePath());
    if (localShare == null)
      return null;
    Log.i("matchClothes.getdName() ", localShare.getdName());
    View localView = LayoutInflater.from(this.context).inflate(R.layout.list_channel_item, null);
    String str = this.context.getResources().getString(R.string.url);

      Bitmap localBitmap = HttpUtil.getHttpBitmap(str + localShare.getSharePath());
      if(localBitmap!=null)
      ((ImageView)localView.findViewById(R.id.share_img )).setImageBitmap(ImageUtil.createBitmapThumbnail(localBitmap, 144, 160));
      ((TextView)localView.findViewById(R.id.title_text )).setText(localShare.gettName() + "&" + localShare.getdName());
      ((TextView)localView.findViewById(R.id.username_text )).setText("分享者:" + localShare.getUserName());
      ((TextView)localView.findViewById(R.id.top_text )).setText("上身：" + localShare.gettName());
      ((TextView)localView.findViewById(R.id.down_text )).setText("下身：" + localShare.getdName());
      ((TextView)localView.findViewById(R.id.down_text )).setText("评分：" + localShare.getScore());
      ((TextView)localView.findViewById(R.id.share_time_text )).setText("分享时间：" + localShare.getShareTime());
      return localView;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.channel.ChannelListAdapter
 * JD-Core Version:    0.6.0
 */