package com.shuai.taobaounion.presenter.imp;

import com.shuai.taobaounion.model.Api;
import com.shuai.taobaounion.model.domain.Categories;
import com.shuai.taobaounion.presenter.IHomePresenter;
import com.shuai.taobaounion.utils.LogUtils;
import com.shuai.taobaounion.utils.RetrofitManager;
import com.shuai.taobaounion.view.IHomeCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenter implements IHomePresenter {

    private IHomeCallback mCallback;

    @Override
    public void getCategories() {
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<Categories> task = api.getCategories();
        task.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                //数据加载成功
                if(response.code()== HttpURLConnection.HTTP_OK){
                    if(mCallback!=null){
                        LogUtils.d(HomePresenter.class,"数据加载——>"+response.body().toString());
                        mCallback.getCategories(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                //数据加载失败
                LogUtils.i(HomePresenter.class,t.toString());
            }
        });
    }

    @Override
    public void registerCallBack(IHomeCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unRegisterCallBack(IHomeCallback callback) {
        mCallback=null;
    }
}
