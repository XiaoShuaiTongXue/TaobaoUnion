package com.shuai.taobaounion.view;

import com.shuai.taobaounion.model.domain.Categories;

public interface IHomeCallback {
    /**
     * 获取数据
     */
    void getCategories(Categories categories);
}
