package com.shuai.taobaounion.ui.fragment;


import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.shuai.taobaounion.R;
import com.shuai.taobaounion.base.BaseFragment;
import com.shuai.taobaounion.model.domain.Categories;
import com.shuai.taobaounion.presenter.imp.HomePresenter;
import com.shuai.taobaounion.ui.adapter.HomePageAdapter;
import com.shuai.taobaounion.view.IHomeCallback;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeCallback {

    private HomePresenter mHomePresenter;

    @BindView(R.id.home_indicator)
    public TabLayout mTabLayout;

    @BindView(R.id.page_home)
    public ViewPager mPageHome;

    private HomePageAdapter mHomePageAdapter;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initPresenter() {
        mHomePresenter = new HomePresenter();
        mHomePresenter.registerCallBack(this);
    }

    @Override
    protected void initView(View rootView) {
        //加载布局
        mTabLayout.setupWithViewPager(mPageHome);
        mHomePageAdapter = new HomePageAdapter(getChildFragmentManager());
        mPageHome.setAdapter(mHomePageAdapter);
    }

    @Override
    protected void loadData() {
        //加载数据
        mHomePresenter.getCategories();
    }

    @Override
    public void getCategories(Categories categories) {
        //数据加载完成
        if (mHomePageAdapter != null) {
            mHomePageAdapter.setCategories(categories);
        }
    }

    @Override
    protected void release() {
        if (mHomePresenter != null) {
            mHomePresenter.unRegisterCallBack(this);
        }
    }
}
