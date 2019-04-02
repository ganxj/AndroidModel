package com.gange.packagegroup.common;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataBindAdapter<T> extends BaseAdapter {
    public static int BIND_ITEM_ID;
    public static int BIND_ITEM_INDEX_ID;
    private Context mContext;
    private List<T> data;
    private int layout;
    private int itemId;
    private int item_index;
    private Map<Integer, Object> commonData;

    public void setData(List<T> data) {
        this.data = data;
    }

    public DataBindAdapter(Context mContext, List<T> data, int layout) {
        this.itemId = BIND_ITEM_ID;
        this.item_index = BIND_ITEM_INDEX_ID;
        this.mContext = mContext;
        this.data = data;
        this.layout = layout;
    }

    public DataBindAdapter(Context mContext, List<T> data, int layout, int itemId) {
        this.itemId = BIND_ITEM_ID;
        this.item_index = BIND_ITEM_INDEX_ID;
        this.mContext = mContext;
        this.data = data;
        this.layout = layout;
        this.itemId = itemId;
    }

    public DataBindAdapter(Context mContext, List<T> data, int layout, Map<Integer, Object> commonData) {
        this.itemId = BIND_ITEM_ID;
        this.item_index = BIND_ITEM_INDEX_ID;
        this.mContext = mContext;
        this.data = data;
        this.layout = layout;
        this.commonData = commonData;
    }

    public int getCount() {
        return this.data.size();
    }

    public Object getItem(int position) {
        return this.data.get(position);
    }

    public long getItemId(int position) {
        return (long)position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding = null;
        DataBindAdapter<T>.CoinsDetailViewHolder holder = null;
        if (convertView == null) {
            holder = new DataBindAdapter.CoinsDetailViewHolder();
            binding = DataBindingUtil.inflate(LayoutInflater.from(this.mContext), this.layout, parent, false);
            convertView = binding.getRoot();
            holder.setItemCoinsDetailBinding(binding);
            convertView.setTag(holder);
        } else {
            holder = (DataBindAdapter.CoinsDetailViewHolder)convertView.getTag();
            binding = holder.getItemCoinsDetailBinding();
        }

        binding.setVariable(this.itemId, this.data.get(position));
        binding.setVariable(this.item_index, position);
        if (this.commonData != null) {
            Iterator var6 = this.commonData.entrySet().iterator();

            while(var6.hasNext()) {
                Map.Entry<Integer, Object> entry = (Map.Entry)var6.next();
                binding.setVariable((Integer)entry.getKey(), entry.getValue());
            }
        }

        return convertView;
    }

    private class CoinsDetailViewHolder {
        private ViewDataBinding itemCoinsDetailBinding;

        private CoinsDetailViewHolder() {
        }

        public void setItemCoinsDetailBinding(ViewDataBinding itemCoinsDetailBinding) {
            this.itemCoinsDetailBinding = itemCoinsDetailBinding;
        }

        public ViewDataBinding getItemCoinsDetailBinding() {
            return this.itemCoinsDetailBinding;
        }
    }
}
