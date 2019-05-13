package com.gange.packagegroup.activity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gange.component.itemEntry.ItemEntryMp;
import com.gange.component.myHead.MyHeadMp;
import com.gange.packagegroup.BR;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.ActivityMyBinding;
import com.gange.packagegroup.model.MyModel;

import me.goldze.mvvmhabit.base.BaseActivity;

@Route(path = "/my/my")
public class MyActivity extends BaseActivity<ActivityMyBinding, MyModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_my;

    }

    @Override
    public void initData() {
        super.initData();
        binding.setMp(new MyModel(getApplication()));
        binding.setMyHead(new MyHeadMp(getApplication() , "http://img1.juimg.com/140915/330635-14091515495980.jpg" , "哈哈哈" , "102"));
        binding.setItem(new ItemEntryMp(getApplication() , "http://img1.juimg.com/140915/330635-14091515495980.jpg" , "意见反馈" , "/test/activity" , false));
    }

    @Override
    public int initVariableId() {
        return BR.mp;
    }
}
