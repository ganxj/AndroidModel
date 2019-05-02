package com.gange.component.recyclerView;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import com.gange.common.recyclerView.HomeRvMp;
import com.gange.common.recyclerView.RvViewTypeMp;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class RecyclerMp extends BaseViewModel {

    public ObservableArrayList<HomeRvMp> dataList = new ObservableArrayList<>();
    public ObservableArrayList<RvViewTypeMp> viewList = new ObservableArrayList<>();

    public RecyclerMp(@NonNull Application application, ObservableArrayList<HomeRvMp> dataList, ObservableArrayList<RvViewTypeMp> viewList) {
        super(application);
        this.dataList = dataList;
        this.viewList = viewList;
    }

    public RecyclerMp(@NonNull Application application) {
        super(application);
    }



}
