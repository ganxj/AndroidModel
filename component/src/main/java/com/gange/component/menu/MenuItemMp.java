package com.gange.component.menu;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.gange.common.Router;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class MenuItemMp extends BaseViewModel {

    public ObservableField<String> image = new ObservableField<>("");
    public ObservableField<String> text = new ObservableField<>("");
    public ObservableField<String> path = new ObservableField<>("");

    public MenuItemMp(@NonNull Application application, String image, String text, String path) {
        super(application);
        this.image = new ObservableField<>(image);
        this.text = new ObservableField<>(text);
        this.path = new ObservableField<>(path);
    }

    public MenuItemMp(@NonNull Application application) {
        super(application);
    }

    public void click(View view){
        Router.router(path.get());
    }
}
