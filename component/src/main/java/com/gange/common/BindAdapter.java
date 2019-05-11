package com.gange.common;

import android.app.Application;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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
import com.gange.common.newsViewPager.NewsTitleMp;
import com.gange.common.newsViewPager.PagerItemMp;
import com.gange.common.recyclerView.HomeRvMp;
import com.gange.common.recyclerView.RvViewTypeMp;
import com.gange.component.R;
import com.gange.common.recyclerView.DataBindingRVAdapter;
import com.gange.component.databinding.VpItemImageBannerBinding;
import com.gange.component.databinding.VpItemImageNormalBannerBinding;
import com.gange.component.middleBanner.MiddleBannerMp;
import com.gange.component.middleBanner.MiddlerBannerItem;
import com.gange.component.newsViewPager.NewsViewPagerMp;
import com.gange.component.recyclerView.RecyclerMp;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.utils.ToastUtils;


public class BindAdapter {

    public static Application application;
    public static int lastNewsItemIndex = 2;

    public static void setApplication(Application application) {
        BindAdapter.application = application;
    }

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

    @BindingAdapter({"news_view_pager", "pager_change"})
    public static void newsViewPager(UltraViewPager ultraViewPager, final List<PagerItemMp> list, final NewsViewPagerMp.OnPagerChangeListener listener) {
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        List<View> viewList = new ArrayList<>();

        for (PagerItemMp itemMp : list) {
            ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(ultraViewPager.getContext()), itemMp.getView(), null, false);
            binding.setVariable(itemMp.getItemId(), itemMp.getData());
            viewList.add(binding.getRoot());
        }

        PagerAdapter adapter = new UltraPagerAdapter(viewList);
        ultraViewPager.setAdapter(adapter);
        ultraViewPager.setCurrentItem(0);
        ultraViewPager.setInfiniteLoop(false);

        ultraViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                if (listener != null) {
                    listener.changed(i);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    @BindingAdapter({"view_pager_index_choose"})
    public static void view_pager_index_choose(UltraViewPager ultraViewPager, int currentIndex) {
        if (ultraViewPager.getAdapter() != null && ultraViewPager.getAdapter().getCount() > 0) {
            ultraViewPager.setCurrentItem(currentIndex);
        }
    }

    @BindingAdapter({"recycler_view_click"})
    public static void news_title_rv(final RecyclerView recyclerView, int position) {
        if (recyclerView.getAdapter() != null && ((DataBindingRVAdapter) recyclerView.getAdapter()).getList().size() > 0) {
            List<HomeRvMp> dataList = ((DataBindingRVAdapter) recyclerView.getAdapter()).getList();
            setNewsTitleChoose(recyclerView, position, dataList);
        }
    }

    @BindingAdapter({"news_title_rv", "title_click"})
    public static void news_title_rv(final RecyclerView recyclerView, final List<PagerItemMp> list, final NewsViewPagerMp.OnPagerChangeListener listener) {
        final ObservableArrayList<HomeRvMp> dataList = new ObservableArrayList<>();
        ObservableArrayList<RvViewTypeMp> viewList = new ObservableArrayList<>();
        viewList.add(new RvViewTypeMp(1, R.layout.item_news_title_text));
        for (int i = 0; i < list.size(); i++) {
            PagerItemMp p = list.get(i);
            dataList.add(new HomeRvMp(1, new NewsTitleMp(application, p.getTitle(), i == 0, i, new NewsTitleMp.OnTitleClickListener() {
                @Override
                public void click(int position) {
                    setNewsTitleChoose(recyclerView, position, dataList);
                    listener.clickTitleIndex(position);
                }
            })));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        recyclerView.setAdapter(new DataBindingRVAdapter(recyclerView.getContext(), dataList, viewList));

    }

    private static void setNewsTitleChoose(RecyclerView recyclerView, int position, List<HomeRvMp> dataList) {
        int p = position;
        p = p < 2 ? 2 : p;
        p = p > dataList.size() - 3 ? dataList.size() - 3 : p;
        int diff = p - lastNewsItemIndex;
        for (int i = 0; i < dataList.size(); i++) {
            HomeRvMp homeRvMp = dataList.get(i);
            ((NewsTitleMp) homeRvMp.getData()).choose.set(false);
        }
        ((NewsTitleMp) dataList.get(position).getData()).choose.set(true);
        // TODO: 2019/5/4 recyclerView 设置位置
        int width = recyclerView.getWidth();
        ToastUtils.showShort(width + "");
        recyclerView.smoothScrollBy(diff * 210, 0);
        lastNewsItemIndex = p;
    }

}