package com.example.adapter;

import android.content.Context;
import android.content.Intent;
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


    private Context mContext;
    private DemoInfo[] datas;

    public MainAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_main_list, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);

        /**
         *  放在此处为-1
         */
//        final int postion = viewHolder.getAdapterPosition();
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int postion = viewHolder.getAdapterPosition();
                Intent intent = new Intent(mContext, datas[postion].actitity);
                mContext.startActivity(intent);
//                Toast.makeText(mContext, "llllllllllll", Toast.LENGTH_SHORT).show();


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
