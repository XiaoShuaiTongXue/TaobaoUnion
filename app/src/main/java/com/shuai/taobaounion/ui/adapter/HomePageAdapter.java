package com.shuai.taobaounion.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shuai.taobaounion.model.domain.Categories;
import com.shuai.taobaounion.ui.fragment.HomePageFragment;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends FragmentPagerAdapter {
    List<Categories.DataBean> data = new ArrayList<>();
    public HomePageAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getTitle();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        HomePageFragment homePageFragment = new HomePageFragment();
        return homePageFragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public void setCategories(Categories categories) {
        data.clear();
        data.addAll(categories.getData());
        notifyDataSetChanged();
    }
}
