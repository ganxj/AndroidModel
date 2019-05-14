package com.gange.component.newsViewPager;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.gange.common.newsViewPager.PagerItemMp;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class NewsViewPagerMp extends BaseViewModel {

    public ObservableArrayList<PagerItemMp> list = new ObservableArrayList<>();
    public ObservableField<OnPagerChangeListener> listener = new ObservableField<>();
    public ObservableField<Integer> currentIndex = new ObservableField<>(0);

    public NewsViewPagerMp(@NonNull Application application) {
        super(application);
    }

    public NewsViewPagerMp(@NonNull Application application, ObservableArrayList<PagerItemMp> list) {
        super(application);
        this.list = list;
        this.listener = new ObservableField<OnPagerChangeListener>(new OnPagerChangeListener() {
            @Override
            public void changed(int i) {
                currentIndex.set(i);
            }

            @Override
            public void clickTitleIndex(int i) {
                currentIndex.set(i);
            }
        });
    }


    public interface OnPagerChangeListener{
        void changed(int i);
        void clickTitleIndex(int i);
    }

}
