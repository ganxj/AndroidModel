package com.gange.component.itemView;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import java.util.List;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class ItemListViewMp extends BaseViewModel {

    public ObservableArrayList<ItemView1Mp> list = new ObservableArrayList<>();


    public ItemListViewMp(@NonNull Application application , ObservableArrayList<ItemView1Mp> list) {
        super(application);
        this.list = list;
    }
}
