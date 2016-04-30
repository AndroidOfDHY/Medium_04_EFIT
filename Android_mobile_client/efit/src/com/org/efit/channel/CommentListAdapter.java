package com.org.efit.channel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dream.myqiyi.R;
import com.org.efit.entity.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentListAdapter extends BaseAdapter
{
  private Context context;
  private LayoutInflater mInflater;
  private List<Comment> resultList = new ArrayList();

  public CommentListAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public void addMore(List<Comment> paramList)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return;
      this.resultList.add((Comment)paramList.get(i));
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

  public List<Comment> getResultList()
  {
    return this.resultList;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Comment localComment = (Comment)this.resultList.get(paramInt);
    if (localComment == null)
      return null;
    View localView = LayoutInflater.from(this.context).inflate(R.layout.list_comment_item , null);
    ((TextView)localView.findViewById(R.id.username_text)).setText(localComment.getUsername());
    Log.i("名字", localComment.getUsername());
    ((TextView)localView.findViewById(R.id.content_text)).setText(localComment.getContent());
    ((TextView)localView.findViewById(R.id.sub_time_text)).setText(localComment.getSubTime());
    return localView;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.channel.CommentListAdapter
 * JD-Core Version:    0.6.0
 */