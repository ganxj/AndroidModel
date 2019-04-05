package com.gange.component.menu;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.gange.component.R;


import me.goldze.mvvmhabit.base.BaseViewModel;

public class MenuMp extends BaseViewModel {

    public ObservableField<Integer> numColumns= new ObservableField<>(4);
    public ObservableField<Integer> menuView= new ObservableField<>(R.layout.item_menu_list);
    public ObservableArrayList<MenuItemMp> menuData= new ObservableArrayList<>();

    public MenuMp(@NonNull Application application) {
        super(application);
    }

    public MenuMp(@NonNull Application application, Integer numColumns, ObservableArrayList<MenuItemMp> data) {
        super(application);
        this.numColumns = new ObservableField<>(numColumns);
        this.menuData = data;
    }

    public ObservableList<MenuItemMp> getMenuData() {
        return menuData;
    }

    public void setMenuData(ObservableArrayList<MenuItemMp> menuData) {
        this.menuData = menuData;
    }
}
