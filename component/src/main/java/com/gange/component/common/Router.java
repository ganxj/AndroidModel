package com.gange.component.common;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Map;

public class Router {

    public static void router(String path){
        ARouter.getInstance().build("/test/activity").navigation();
    }

    public static Postcard getRouter(String path ){
        Postcard build = ARouter.getInstance().build(path);
        return build;
    }

}
