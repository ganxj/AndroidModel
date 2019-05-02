package com.gange.common.recyclerView;

/**
 * Created by gange on 2018/3/16.
 */

public class RvViewTypeMp {

    private int type;

    private int view;

    public RvViewTypeMp() {
    }

    public RvViewTypeMp(int type, int view) {
        this.type = type;
        this.view = view;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

}
