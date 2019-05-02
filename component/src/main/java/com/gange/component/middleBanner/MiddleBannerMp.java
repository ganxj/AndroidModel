package com.gange.component.middleBanner;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.gange.component.menu.MenuItemMp;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class MiddleBannerMp extends BaseViewModel {

    public ObservableArrayList<MiddlerBannerItem> bannerItemList = new ObservableArrayList<>();


    public MiddleBannerMp(@NonNull Application application, ObservableArrayList<MiddlerBannerItem> bannerItemList) {
        super(application);
        this.bannerItemList = bannerItemList;
    }


}
