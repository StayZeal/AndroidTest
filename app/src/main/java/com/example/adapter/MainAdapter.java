package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.constant.DemoInfo;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yangfeng on 2016/12/6.
 */
public class MainAdapter extends RecyclerView.Adapter {


    private Context context;
    private DemoInfo[] datas;

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_main_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context,datas[])
            }
        });
        return viewHolder;
    }

    public void setDatas(DemoInfo[] datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(datas[position].title);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_Tv)
        TextView title;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
