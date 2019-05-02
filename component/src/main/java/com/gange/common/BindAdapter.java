package com.gange.common;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.WrapperListAdapter;

import com.bumptech.glide.Glide;
import com.gange.component.R;
import com.gange.common.recyclerView.DataBindingRVAdapter;
import com.gange.component.databinding.VpItemImageBannerBinding;
import com.gange.component.databinding.VpItemImageNormalBannerBinding;
import com.gange.component.middleBanner.MiddleBannerMp;
import com.gange.component.middleBanner.MiddlerBannerItem;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;


public class BindAdapter {

    @BindingAdapter("imageUrl")
    public static void imageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }


    @BindingAdapter({"list_data", "list_view"})
    public static void listViewData(AdapterView adapterView, List data, int view) {
        Adapter adapter = adapterView.getAdapter();
        if (adapter == null) {
            adapterView.setAdapter(new DataBindAdapter(adapterView.getContext(), data, view));
        } else {
            while (true) {
                if (!(adapter instanceof WrapperListAdapter)) {
                    if (adapter instanceof DataBindAdapter) {
                        ((DataBindAdapter) adapter).setData(data);
                        ((DataBindAdapter) adapter).notifyDataSetChanged();
                    } else {
                        Log.d("tag", "无法自动刷新");
                    }
                    break;
                }
                adapter = ((WrapperListAdapter) adapter).getWrappedAdapter();
            }
        }
    }


    @BindingAdapter({"home_banner_adapter", "home_banner_adapter_type"})
    public static void homeBannerAdapter(UltraViewPager ultraViewPager, MiddleBannerMp itemMp, String type) {
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        List<View> viewList = new ArrayList<>();
        ObservableArrayList<MiddlerBannerItem> bannerItemList = itemMp.bannerItemList;

        for (MiddlerBannerItem menuItemMp : bannerItemList) {
            if (type.equals("120")) {
                VpItemImageBannerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(ultraViewPager.getContext()), R.layout.vp_item_image_banner, null, false);
                binding.setItem(menuItemMp);
                viewList.add(binding.getRoot());
            } else if (type.equals("200")) {
                VpItemImageNormalBannerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(ultraViewPager.getContext()), R.layout.vp_item_image_normal_banner, null, false);
                binding.setItem(menuItemMp);
                viewList.add(binding.getRoot());
            }
        }

        PagerAdapter adapter = new UltraPagerAdapter(viewList);
        ultraViewPager.setAdapter(adapter);
        ultraViewPager.setCurrentItem(0);
        ultraViewPager.setInfiniteLoop(false);

        //圆点
        ultraViewPager.initIndicator();
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(ultraViewPager.getResources().getColor(R.color.theme_color))
                .setNormalColor(ultraViewPager.getResources().getColor(R.color.gray))
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, ultraViewPager.getResources().getDisplayMetrics()));
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        if (bannerItemList.size() > 1) {
            ultraViewPager.getIndicator().build();
            ultraViewPager.setAutoScroll(2000);
        }
    }


    /**
     * 暂时没用，菜单分页用
     *
     * @param ultraViewPager
     * @param itemMp
     */
    @BindingAdapter("home_menu_adapter")
    public static void homeMenuAdapter(UltraViewPager ultraViewPager, MiddleBannerMp itemMp) {
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        List<View> viewList = new ArrayList<>();
        ObservableArrayList<MiddlerBannerItem> bannerItemList = itemMp.bannerItemList;
        int size = bannerItemList.size();
//        for (int i = 0; i < size; i++) {
//            if (i % 10 == 0) {
//                menuItemMpList.add(new HomeMenuItemMp(menuItemModelList.subList(i, i + 10 < size ? i + 10 : size)));
//            }
//        }

//        for (HomeMenuItemMp menuItemMp : menuItemMpList) {
//            VpItemMenuGridBinding binding = android.databinding.DataBindingUtil.inflate(LayoutInflater.from(ultraViewPager.getContext()), R.layout.vp_item_menu_grid, null, false);
//            binding.setItem(menuItemMp);
//            viewList.add(binding.getRoot());
//        }

//        PagerAdapter adapter = new UltraPagerAdapter(viewList);
//        ultraViewPager.setAdapter(adapter);
        ultraViewPager.setCurrentItem(0);
        ultraViewPager.setInfiniteLoop(false);

        //圆点
        ultraViewPager.initIndicator();
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
//                .setFocusColor(ultraViewPager.getResources().getColor(R.color.theme_color))
                .setNormalColor(ultraViewPager.getResources().getColor(R.color.gray))
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, ultraViewPager.getResources().getDisplayMetrics()));
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//        ultraViewPager.getIndicator().build();
    }


    @BindingAdapter({"recycler_data", "recycler_view"})
    public static void recyclerViewData(RecyclerView recyclerView, List data, List view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setAdapter(new DataBindingRVAdapter(recyclerView.getContext(), data, view));
    }


}