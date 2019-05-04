package com.gange.common.newsViewPager;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class NewsTitleMp extends BaseViewModel {

    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<Boolean> choose = new ObservableField<>(false);
    public ObservableField<Integer> index = new ObservableField<>();
    private OnTitleClickListener listener = null;

    public NewsTitleMp(@NonNull Application application) {
        super(application);
    }

    public NewsTitleMp(@NonNull Application application, String title , Boolean choose ,Integer index, OnTitleClickListener listener) {
        super(application);
        this.title = new ObservableField<>(title);
        this.choose = new ObservableField<>(choose);
        this.index = new ObservableField<>(index);
        this.listener = listener;
    }

    public void click(View view){
        if (listener != null){
            listener.click(index.get());
        }
    }

    public interface OnTitleClickListener{
        void click(int i);
    }
}
