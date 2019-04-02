package com.gange.component.head;


import android.app.Activity;
import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.gange.component.common.Router;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class HeadMp extends BaseViewModel {

    public ObservableField<Boolean> showBack = new ObservableField<>(true);
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> right = new ObservableField<>("");
    public ObservableField<String> path = new ObservableField<>("");
    public ObservableField<Boolean> goView = new ObservableField<>(true);

    public HeadMp(@NonNull Application application, Boolean showBack, String title, String right, String path, Boolean goView) {
        super(application);
        this.showBack = new ObservableField<>(showBack);
        this.title = new ObservableField<>(title);
        this.right = new ObservableField<>(right);
        this.path = new ObservableField<>(path);
        this.goView = new ObservableField<>(goView);
    }

    public HeadMp(@NonNull Application application, Boolean showBack, String title) {
        super(application);
        this.showBack = new ObservableField<>(showBack);
        this.title = new ObservableField<>(title);
    }


    public void back(View view) {
        ((Activity) view.getContext()).finish();
    }

    public void rightClick(View view) {
        if (goView.get()) {
            Router.router(path.get());
        } else {
            ToastUtils.showShort("弹框");
        }
    }
}
