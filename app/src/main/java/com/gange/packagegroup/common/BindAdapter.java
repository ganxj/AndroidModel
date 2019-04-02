package com.gange.packagegroup.common;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.WrapperListAdapter;

import java.util.List;

public class BindAdapter {


    @BindingAdapter({"list_data", "list_view"})
    public static void listViewData(AdapterView adapterView, List data, int view) {
        Adapter adapter = adapterView.getAdapter();
        if (adapter == null) {
            adapterView.setAdapter(new DataBindAdapter(adapterView.getContext(), data, view));
        } else {
            while (true) {
                if (!(adapter instanceof WrapperListAdapter)) {
                    if (adapter instanceof DataBindAdapter) {
                        ((DataBindAdapter) adapter).setData(data);
                        ((DataBindAdapter) adapter).notifyDataSetChanged();
                    } else {
                        Log.d("tag", "无法自动刷新");
                    }
                    break;
                }

                adapter = ((WrapperListAdapter) adapter).getWrappedAdapter();
            }
        }
    }


}
