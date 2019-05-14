package com.gange.component.homeTab;

import android.app.Activity;
import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.gange.component.BR;
import com.gange.component.R;
import com.gange.component.newsViewPager.NewsViewPagerMp;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class HomeTabMp extends BaseViewModel {

    public ObservableArrayList<HomeTabItemMp> tabList = new ObservableArrayList<>();
    public ObservableField<Integer> view = new ObservableField<>(R.layout.item_home_tab);
    public ObservableField<Integer> itemId = new ObservableField<>(BR.item);
    public ObservableField<Integer> currentIndex = new ObservableField<>(0);
    public ObservableField<OnHomeTabChangeListener> listener = new ObservableField<>();
    public ObservableField<BaseActivity> activity = new ObservableField<>();

    public HomeTabMp(@NonNull Application application, BaseActivity activity, final ObservableArrayList<HomeTabItemMp> tabList) {
        super(application);
        if (tabList != null && tabList.size() > 0) {
            tabList.get(0).choose.set(true);
        }
        this.tabList = tabList;
        this.activity = new ObservableField<>(activity);
        this.listener = new ObservableField<OnHomeTabChangeListener>(new HomeTabMp.OnHomeTabChangeListener() {
            @Override
            public void changed(int i) {
                currentIndex.set(i);
                for (int j = 0; j < tabList.size(); j++) {
                    if (i == j) {
                        tabList.get(j).choose.set(true);
                    } else {
                        tabList.get(j).choose.set(false);
                    }
                }
            }

            @Override
            public void clickTitleIndex(int i) {
                currentIndex.set(i);
                for (int j = 0; j < tabList.size(); j++) {
                    if (i == j) {
                        tabList.get(j).choose.set(true);
                    } else {
                        tabList.get(j).choose.set(false);
                    }
                }
            }
        });

    }


    public interface OnHomeTabChangeListener {
        void changed(int i);

        void clickTitleIndex(int i);
    }

}
