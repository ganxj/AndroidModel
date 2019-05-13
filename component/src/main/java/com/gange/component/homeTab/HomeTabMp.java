package com.gange.component.homeTab;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.gange.component.BR;
import com.gange.component.R;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class HomeTabMp extends BaseViewModel {

    public ObservableArrayList<HomeTabItemMp> tabList = new ObservableArrayList<>();
    public ObservableField<Integer> view = new ObservableField<>(R.layout.item_home_tab);
    public ObservableField<Integer> itemId = new ObservableField<>(BR.item);

    public HomeTabMp(@NonNull Application application, ObservableArrayList<HomeTabItemMp> tabList) {
        super(application);
        this.tabList = tabList;
    }
}
