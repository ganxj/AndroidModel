package com.gange.component.itemEntry;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.gange.common.Router;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class ItemEntryMp extends BaseViewModel {

    public ObservableField<String> icon = new ObservableField<>();

    public ObservableField<String>  title = new ObservableField<>();

    public ObservableField<String>  path = new ObservableField<>();

    public ObservableField<Boolean>  haveRight = new ObservableField<>();



    public ItemEntryMp(@NonNull Application application , String icon , String title , String path , Boolean haveRight) {
        super(application);
        this.icon = new ObservableField<>(icon);
        this.title = new ObservableField<>(title);
        this.path = new ObservableField<>(path);
        this.haveRight = new ObservableField<>(haveRight);
    }

    public void click(View view){
        Router.router(path.get());
    }
}
