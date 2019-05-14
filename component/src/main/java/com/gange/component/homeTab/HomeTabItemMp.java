package com.gange.component.homeTab;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class HomeTabItemMp extends BaseViewModel {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> icon = new ObservableField<>();
    public ObservableField<String> iconChoose = new ObservableField<>();
    public ObservableField<BaseFragment> fragment = new ObservableField<>();
    public ObservableField<Boolean> choose = new ObservableField<>(false);


    public HomeTabItemMp(@NonNull Application application, String name, String icon,String iconChoose,  BaseFragment fragment) {
        super(application);
        this.name = new ObservableField<>(name);
        this.icon = new ObservableField<>(icon);
        this.iconChoose = new ObservableField<>(iconChoose);
        this.fragment = new ObservableField<>(fragment);
    }

}
