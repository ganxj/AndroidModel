package com.gange.packagegroup.model;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class ListModel extends BaseViewModel {

    public ObservableField<String> userName = new ObservableField<>("");

    public ListModel(@NonNull Application application) {
        super(application);
    }


}
