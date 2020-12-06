package com.shuai.taobaounion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shuai.taobaounion.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        View rootView =  loadRootView(inflater,container,savedInstanceState);
        LogUtils.d(BaseFragment.class,"-->"+"绑定");
        mBind = ButterKnife.bind(this, rootView);
        LogUtils.d(BaseFragment.class,"-->"+"加载布局");
        initView(rootView);
        LogUtils.d(BaseFragment.class,"-->"+"加载presenter");
        initPresenter();
        loadData();
        return rootView;
    }

    protected  void initView(View rootView){
        //加载布局
    }

    @Override
    public void onDestroyView() {
        if (mBind != null) {
            mBind.unbind();
        }
        super.onDestroyView();
        release();
    }

    protected  void release(){
        //释放资源
    }

    protected  void initPresenter(){
        //创建presenter
    }

    protected  void loadData(){
        //加载数据
    }

    protected View loadRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getResourceId(),container,false);
    }

    protected abstract int getResourceId();


}
