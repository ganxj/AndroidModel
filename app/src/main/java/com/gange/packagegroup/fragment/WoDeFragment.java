package com.gange.packagegroup.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gange.packagegroup.BR;
import com.gange.packagegroup.R;
import com.gange.packagegroup.databinding.FragmentWodeBinding;
import com.gange.packagegroup.model.WoDeFgMp;

import me.goldze.mvvmhabit.base.BaseFragment;

public class WoDeFragment extends BaseFragment<FragmentWodeBinding, WoDeFgMp> {


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_wode;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setMp(new WoDeFgMp(getActivity().getApplication()));
    }

    @Override
    public int initVariableId() {
        return BR.mp;
    }
}
