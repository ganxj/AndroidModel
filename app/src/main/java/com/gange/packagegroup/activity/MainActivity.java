package com.gange.packagegroup.activity;

import android.databinding.ObservableArrayList;
import android.os.Bundle;

import com.gange.component.TitleView.TitleViewMp;
import com.gange.component.common.recyclerView.HomeRvMp;
import com.gange.component.common.recyclerView.RvViewTypeMp;
import com.gange.component.head.HeadMp;
import com.gange.component.imageView.ImageViewMp;
import com.gange.component.itemView.ItemView1Mp;
import com.gange.component.menu.MenuItemMp;
import com.gange.component.menu.MenuMp;
import com.gange.component.middleBanner.MiddleBannerMp;
import com.gange.component.middleBanner.MiddlerBannerItem;
import com.gange.component.recyclerView.RecyclerMp;
import com.gange.packagegroup.BR;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.ActivityMainBinding;
import com.gange.packagegroup.model.HomeModel;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.ItemViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, HomeModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setHead(new HeadMp(getApplication(), true, "首页", "更多", "/home/list", true));
        ObservableArrayList<HomeRvMp> homeRvMps = new ObservableArrayList<>();
        ObservableArrayList<RvViewTypeMp> viewList = new ObservableArrayList<>();
        viewList.add(new RvViewTypeMp(1 , R.layout.component_normal_banner_view));
        viewList.add(new RvViewTypeMp(2 , R.layout.component_menu_view ));
        viewList.add(new RvViewTypeMp(3 , R.layout.component_middle_banner_view ));
        viewList.add(new RvViewTypeMp(4 , R.layout.component_title_view ));
        viewList.add(new RvViewTypeMp(5 , R.layout.component_item_view1 ));


        ObservableArrayList<MenuItemMp> menuItemMps = new ObservableArrayList<>();
        for (int i = 0; i < 8; i++) {
            menuItemMps.add(new MenuItemMp(getApplication(), "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554408789465&di=4f876c6f667fafb4cdc37bc9aae1d1f7&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01ea8b57f784f9a84a0d304fa0d887.png%401280w_1l_2o_100sh.png", "测试", "/test/activity"));
        }
        binding.setMenu(new MenuMp(getApplication(), 4, menuItemMps));

        ObservableArrayList<MiddlerBannerItem> middleBannerMps = new ObservableArrayList<>();
        for (int i = 0; i < 3; i++) {
            middleBannerMps.add(new MiddlerBannerItem(getApplication(), "http://pic29.nipic.com/20130517/9252150_140653449378_2.jpg", "/home/list"));
        }
        binding.setNormalBanner(new MiddleBannerMp(getApplication(), middleBannerMps));
        binding.setBanner(new MiddleBannerMp(getApplication(), middleBannerMps));

        homeRvMps.add(new HomeRvMp(1 ,new MiddleBannerMp(getApplication(), middleBannerMps)  ,com.gange.component.BR.normalBanner) );
        homeRvMps.add(new HomeRvMp(2 ,new MenuMp(getApplication(), 4, menuItemMps) ,com.gange.component.BR.menu));
        homeRvMps.add(new HomeRvMp(3 ,new MiddleBannerMp(getApplication(), middleBannerMps),com.gange.component.BR.banner ));
        homeRvMps.add(new HomeRvMp(4 ,new TitleViewMp(getApplication(), "特惠精选" , "更多>" , true , "/home/list"),com.gange.component.BR.title ));

        for (int i = 0; i < 10; i++) {
            homeRvMps.add(new HomeRvMp(5 ,  new ItemView1Mp(getApplication() , "http://pic29.nipic.com/20130517/9252150_140653449378_2.jpg" , "哈哈哈哈哈哈哈哈吞吞吐吐吞吞吐吐天天" , "哈哈哈哈哈哈哈哈哈哈哈哈哈吞吞吐吐吞吞吐吐天天哈哈哈哈哈哈哈哈吞吞吐吐吞吞吐吐天天啊 啊啊啊啊啊啊 啊啊 啊啊啊啊啊啊 啊啊啊啊啊 "  , "/home/list") ));
        }

        binding.setRecycler(new RecyclerMp(getApplication() , homeRvMps , viewList));
    }

    @Override
    public int initVariableId() {
        return BR.home;
    }
}
