package site.duqian.weex.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import site.duqian.weex.R;

/**
 * Description:
 *
 * @author 杜乾-Dusan,Created on 2018/2/6 - 16:31.
 *         E-mail:duqian2010@gmail.com
 */
public class LocalJsAdapter extends RecyclerView.Adapter<LocalJsAdapter.ViewHolder> {

    private List<String> mData;

    private Context context;
    private LayoutInflater layoutInflater;

    public LocalJsAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void updateData(List<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_local_js, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // 绑定数据
        holder.mTextView.setText(mData.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_js_name);
        }
    }


    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public abstract static class OnItemClickListener {
        protected abstract void onItemClick(View view, int position);

        protected void onItemLongClick(View view, int position) {
        }
    }

}
