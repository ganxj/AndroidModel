package com.gange.packagegroup.activity;

import android.databinding.ObservableField;
import android.os.Bundle;


import com.gange.component.head.HeadMp;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.ActivityMainBinding;
import com.gange.packagegroup.model.HomeModel;

import me.goldze.mvvmhabit.base.BaseActivity;

import com.gange.packagegroup.BR;

public class MainActivity extends BaseActivity<ActivityMainBinding, HomeModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setHead(new HeadMp(getApplication(), true, "首页", "更多", "/home/list", true));
    }

    @Override
    public int initVariableId() {
        return BR.home;
    }
}
