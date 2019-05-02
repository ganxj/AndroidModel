package com.gange.component.TitleView;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.gange.common.Router;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class TitleViewMp extends BaseViewModel {

    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> moreText = new ObservableField<>("");
    public ObservableField<String> morePath = new ObservableField<>("");
    public ObservableField<Boolean> haveMore = new ObservableField<>(true);


    public TitleViewMp(@NonNull Application application, String title, String moreText, boolean haveMore , String morePath) {
        super(application);
        this.title = new ObservableField<>(title);
        this.haveMore = new ObservableField<>(haveMore);
        this.moreText = new ObservableField<>(moreText);
        this.morePath = new ObservableField<>(morePath);
    }

    public TitleViewMp(@NonNull Application application, String title) {
        super(application);
        this.title = new ObservableField<>(title);
        this.haveMore = new ObservableField<>(false);
        this.moreText = new ObservableField<>("");
    }

    public TitleViewMp(@NonNull Application application) {
        super(application);
    }

    public void click(View view){
        Router.router(morePath.get());
    }

}
