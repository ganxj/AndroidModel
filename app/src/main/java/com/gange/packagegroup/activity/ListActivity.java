package com.gange.packagegroup.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gange.component.head.HeadMp;
import com.gange.packagegroup.BR;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.ActivityListBinding;
import com.gange.packagegroup.model.ListModel;

import me.goldze.mvvmhabit.base.BaseActivity;

@Route(path = "/test/activity")
public class ListActivity extends BaseActivity<ActivityListBinding, ListModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_list;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setHead(new HeadMp(getApplication() , true , "列表页"));
    }

    @Override
    public int initVariableId() {
        return BR.mp;
    }
}
