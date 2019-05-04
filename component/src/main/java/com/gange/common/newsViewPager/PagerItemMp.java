package com.gange.common.newsViewPager;

import android.app.Application;
import android.support.annotation.NonNull;

import java.util.List;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class PagerItemMp {

    private String title;

    private int view;

    private int itemId;

    private Object data;

    public PagerItemMp() {
    }

    public PagerItemMp(String title, int view, int itemId, Object data) {
        this.title = title;
        this.view = view;
        this.itemId = itemId;
        this.data = data;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
