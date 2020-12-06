package com.shuai.taobaounion.presenter;

import com.shuai.taobaounion.model.domain.Categories;
import com.shuai.taobaounion.view.IHomeCallback;

public interface IHomePresenter {
    /**
     * 加载数据
     */
    void getCategories();

    /**
     * 注册接口
     */
    void registerCallBack(IHomeCallback callback);

    /**
     * 取消注册
     */
    void unRegisterCallBack(IHomeCallback callback);
}
