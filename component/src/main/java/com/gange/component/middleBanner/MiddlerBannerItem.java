package com.gange.component.middleBanner;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.gange.common.Router;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class MiddlerBannerItem extends BaseViewModel {

    public ObservableField<String> imageUrl = new ObservableField<>("");
    public ObservableField<String> path = new ObservableField<>("");

    public MiddlerBannerItem(@NonNull Application application) {
        super(application);
        loadData();
    }

    private void loadData() {

    }

    public MiddlerBannerItem(@NonNull Application application ,String imageUrl , String path) {
        super(application);
        this.imageUrl = new ObservableField<>(imageUrl);
        this.path = new ObservableField<>(path);
    }

    public void click(View view){
        Router.router(path.get());
    }

}
