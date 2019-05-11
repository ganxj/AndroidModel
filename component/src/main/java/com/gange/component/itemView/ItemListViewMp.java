package com.gange.component.itemView;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.gange.component.R;

import java.util.List;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class ItemListViewMp extends BaseViewModel {

    public ObservableArrayList<ItemView1Mp> list = new ObservableArrayList<>();
    public ObservableField<Integer> view = new ObservableField<>(R.layout.item_grid_view1);


    public ItemListViewMp(@NonNull Application application , ObservableArrayList<ItemView1Mp> list) {
        super(application);
        this.list = list;
    }

}
