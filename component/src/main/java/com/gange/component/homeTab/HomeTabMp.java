package com.gange.component.homeTab;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class HomeTabMp extends BaseViewModel {

    public ObservableArrayList<HomeTabItemMp> tabList = new ObservableArrayList<>();

    public HomeTabMp(@NonNull Application application) {
        super(application);
    }
}
