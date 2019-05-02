package com.gange.component.itemView;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.gange.common.Router;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class ItemView1Mp extends BaseViewModel {

    public ObservableField<String> imageUrl = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> subject = new ObservableField<>("");
    public ObservableField<String> path = new ObservableField<>("");

    public ItemView1Mp(@NonNull Application application) {
        super(application);
    }

    public ItemView1Mp(@NonNull Application application, String imageUrl, String title, String subject, String path) {
        super(application);
        this.imageUrl = new ObservableField<>(imageUrl);
        this.title = new ObservableField<>(title);
        this.subject = new ObservableField<>(subject);
        this.path = new ObservableField<>(path);
    }

   public void click(View view){
       Router.router(path.get());
   }
}
