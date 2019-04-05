package com.gange.packagegroup.activity;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.os.Bundle;


import com.gange.component.head.HeadMp;
import com.gange.component.menu.MenuItemMp;
import com.gange.component.menu.MenuMp;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.ActivityMainBinding;
import com.gange.packagegroup.model.HomeModel;

import me.goldze.mvvmhabit.base.BaseActivity;

import com.gange.packagegroup.BR;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, HomeModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setHead(new HeadMp(getApplication(), true, "首页", "更多", "/home/list", true));
        ObservableArrayList<MenuItemMp> menuItemMps = new ObservableArrayList<>();
        for (int i = 0; i < 8; i++) {
            menuItemMps.add(new MenuItemMp(getApplication(), "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554408789465&di=4f876c6f667fafb4cdc37bc9aae1d1f7&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01ea8b57f784f9a84a0d304fa0d887.png%401280w_1l_2o_100sh.png", "测试", "/test/activity"));
        }
        binding.setMenu(new MenuMp(getApplication(), 4, menuItemMps));
    }

    @Override
    public int initVariableId() {
        return BR.home;
    }
}
