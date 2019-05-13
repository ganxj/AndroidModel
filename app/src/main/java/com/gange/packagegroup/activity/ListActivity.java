package com.gange.packagegroup.activity;

import android.databinding.ObservableArrayList;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gange.common.newsViewPager.PagerItemMp;
import com.gange.component.head.HeadMp;
import com.gange.component.itemView.ItemListViewMp;
import com.gange.component.itemView.ItemView1Mp;
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
        ObservableArrayList<ItemView1Mp> itemView1Mps = new ObservableArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemView1Mps.add(new ItemView1Mp(getApplication(), "http://img1.juimg.com/140915/330635-14091515495980.jpg", "哈哈哈哈哈哈哈哈吞吞吐吐吞吞吐吐天天", "哈哈哈哈哈哈哈哈哈哈哈哈哈吞吞吐吐吞吞吐吐天天哈哈哈哈哈哈哈哈吞吞吐吐吞吞吐吐天天啊 啊啊啊啊啊啊 啊啊 啊啊啊啊啊啊 啊啊啊啊啊 ", "/my/my", "发布者。。。", "http://b-ssl.duitang.com/uploads/item/201811/04/20181104203324_xfeme.thumb.700_0.jpg"));
        }
        ItemListViewMp itemListViewMp = new ItemListViewMp(getApplication(), itemView1Mps);
        list.add(new PagerItemMp("列表", R.layout.component_item_view3, itemListViewMp, BR.item));
        for (int i = 0; i < 10; i++) {
            list.add(new PagerItemMp("页面" + i, R.layout.view_pager_test, "页面" + i, BR.item));
        }
        binding.setMp(new NewsViewPagerMp(getApplication(), list));
    }

    @Override
    public int initVariableId() {
        return BR.mp;
    }
}
