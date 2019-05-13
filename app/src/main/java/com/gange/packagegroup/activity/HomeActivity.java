package com.gange.packagegroup.activity;

import android.databinding.ObservableArrayList;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gange.component.homeTab.HomeTabItemMp;
import com.gange.component.homeTab.HomeTabMp;
import com.gange.packagegroup.BR;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.ActivityHomeBinding;
import com.gange.packagegroup.fragment.HomeFragment;
import com.gange.packagegroup.model.HomeMp;

import me.goldze.mvvmhabit.base.BaseActivity;
import retrofit2.http.Path;

@Route(path = "/home/home")
public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeMp> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        super.initData();
        ObservableArrayList<HomeTabItemMp> list = new ObservableArrayList<>();
        list.add(new HomeTabItemMp(getApplication() , "首页" , "http://img1.juimg.com/140915/330635-14091515495980.jpg" , new HomeFragment()));
        list.add(new HomeTabItemMp(getApplication() , "首页" , "http://img1.juimg.com/140915/330635-14091515495980.jpg" , new HomeFragment()));
        list.add(new HomeTabItemMp(getApplication() , "首页" , "http://img1.juimg.com/140915/330635-14091515495980.jpg" , new HomeFragment()));
        list.add(new HomeTabItemMp(getApplication() , "首页" , "http://img1.juimg.com/140915/330635-14091515495980.jpg" , new HomeFragment()));
        binding.setTab(new HomeTabMp(getApplication() , list));
    }

    @Override
    public int initVariableId() {
        return BR.mp;
    }
}
