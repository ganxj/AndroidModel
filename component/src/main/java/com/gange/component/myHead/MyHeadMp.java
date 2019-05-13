package com.gange.component.myHead;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class MyHeadMp extends BaseViewModel {


    public ObservableField<String> avatar = new ObservableField<>();
    public ObservableField<String> nickName = new ObservableField<>();
    public ObservableField<String> money = new ObservableField<>();


    public MyHeadMp(@NonNull Application application , String avatar , String nickName , String money) {
        super(application);
        this.avatar = new ObservableField<>(avatar);
        this.nickName = new ObservableField<>(nickName);
        this.money = new ObservableField<>(money);
    }

    public void click(View view){
        ToastUtils.showShort("签到");
    }

}
