package com.hualing.hualingmyproject.presenter.api;

import com.hualing.hualingmyproject.model.net.bean.SplashAdsBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 启动页面获取广告数据的API接口
 */

public interface SplashAdsAPI {

    @GET("madr?")
    Call<SplashAdsBean> getData(
            @Query("app")String app,
            @Query("platform")String platform,
            @Query("category")String category,
            @Query("location")String location,
            @Query("timestamp")String timestamp,
            @Query("uid")String uid
    );

}
