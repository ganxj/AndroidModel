package com.gange.common.recyclerView;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gange on 2018/3/16.
 */

public class DataBindingRVAdapter extends BaseRecyclerAdapter<DataBindingRVAdapter.ViewHolder> {

    private Context context;
    private List<HomeRvMp> list;
    private List<RvViewTypeMp> rvViewTypeMpList;

    public void setList(List<HomeRvMp> list) {
        if (this.list != null) {
            this.list.clear();
        }else {
            list = new ArrayList<>();
        }
        this.list.addAll(list);
    }

    public List<HomeRvMp> getList() {
        return list;
    }

    public List<RvViewTypeMp> getRvViewTypeMpList() {
        return rvViewTypeMpList;
    }

    public void setRvViewTypeMpList(List<RvViewTypeMp> rvViewTypeMpList) {
        this.rvViewTypeMpList = rvViewTypeMpList;
    }

    public DataBindingRVAdapter(Context context, List<HomeRvMp> list, List<RvViewTypeMp> rvViewTypeMpList) {
        this.context = context;
//        this.list=new ArrayList<>();
        this.list = list;
        this.rvViewTypeMpList = rvViewTypeMpList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        DataBindingRVAdapter.ViewHolder viewHolder = null;
        for (RvViewTypeMp r : rvViewTypeMpList) {
            if (viewType == r.getType()) {
                ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), r.getView(), parent, false);
                viewHolder = new DataBindingRVAdapter.ViewHolder(binding.getRoot(), binding);
            }
        }
        return viewHolder;
    }

    @Override
    public ViewHolder getViewHolder(View view) {
        return null;
    }

    @Override
    public int getAdapterItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, boolean isItem) {
        holder.binding.setVariable(list.get(position).getItemId(), list.get(position).getData());
    }

    @Override
    public int getAdapterItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public ViewHolder(View itemView, ViewDataBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}