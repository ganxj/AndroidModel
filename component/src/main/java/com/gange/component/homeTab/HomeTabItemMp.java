package com.gange.component.homeTab;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class HomeTabItemMp<T> extends BaseViewModel {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> icon = new ObservableField<>();
    public ObservableField<T> fragment = new ObservableField<>();


    public HomeTabItemMp(@NonNull Application application, String name, String icon,  T fragment) {
        super(application);
        this.name = new ObservableField<>(name);
        this.icon = new ObservableField<>(icon);
        this.fragment = new ObservableField<>(fragment);
    }

    public void click(View view) {
        ToastUtils.showShort("点击了" + name.get());
    }
}
