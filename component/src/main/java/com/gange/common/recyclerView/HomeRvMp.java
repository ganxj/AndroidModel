package com.gange.common.recyclerView;

import com.gange.component.BR;

/**
 * Created by gange on 2018/3/13.
 */

public class HomeRvMp {

    private int type;

    private Object data;

    private int itemId = BR.item;

    public HomeRvMp() {
    }

    public HomeRvMp(int type, Object data) {
        this.type = type;
        this.data = data;
    }

    public HomeRvMp(int type, Object data, int itemId) {
        this.type = type;
        this.data = data;
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
