package com.gange.packagegroup.activity;

import android.databinding.ObservableArrayList;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gange.common.newsViewPager.PagerItemMp;
import com.gange.component.head.HeadMp;
import com.gange.component.newsViewPager.NewsViewPagerMp;
import com.gange.packagegroup.BR;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.ActivityListBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

@Route(path = "/test/activity")
public class ListActivity extends BaseActivity<ActivityListBinding, NewsViewPagerMp> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_list;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setHead(new HeadMp(getApplication(), true, "列表页"));
        ObservableArrayList<PagerItemMp> list = new ObservableArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new PagerItemMp("页面" + i, R.layout.view_pager_test, BR.item, "页面" + i));
        }
        binding.setMp(new NewsViewPagerMp(getApplication(), list));
    }

    @Override
    public int initVariableId() {
        return BR.mp;
    }
}
