package com.gange.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by liaozhihua on 2017/10/12.
 */

public class NoScollViewPager extends ViewPager {
    public NoScollViewPager(Context context) {
        super(context);
    }

    public NoScollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        return super.onTouchEvent(ev);
//        if (noScroll)
//            return false;
//        else
//            return super.onTouchEvent(arg0);
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
        return false;
    }
}
