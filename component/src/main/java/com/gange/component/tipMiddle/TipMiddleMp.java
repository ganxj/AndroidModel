package com.gange.component.tipMiddle;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class TipMiddleMp extends BaseViewModel {

    public ObservableField<String> imageUrl = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> context = new ObservableField<>("");


    public TipMiddleMp(@NonNull Application application, String imageUrl, String title, String context) {
        super(application);
        this.imageUrl = new ObservableField<>(imageUrl);
        this.title = new ObservableField<>(title);
        this.context = new ObservableField<>(context);
    }
}
