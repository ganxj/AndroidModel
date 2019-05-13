package com.gange.component.homeTab;

import android.databinding.ObservableField;

public class HomeTabItemMp<T> {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> icon = new ObservableField<>();
    public ObservableField<Integer> view = new ObservableField<>();
    public ObservableField<T> fragment = new ObservableField<>();



}
