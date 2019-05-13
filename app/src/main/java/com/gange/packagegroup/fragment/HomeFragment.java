package com.gange.packagegroup.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gange.packagegroup.BR;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.FragmentHomeBinding;
import com.gange.packagegroup.model.HomeFgMp;

import me.goldze.mvvmhabit.base.BaseFragment;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeFgMp> {


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setMp(new HomeFgMp(getActivity().getApplication()));
    }

    @Override
    public int initVariableId() {
        return BR.mp;
    }
}
