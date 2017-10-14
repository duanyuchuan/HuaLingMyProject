package com.hualing.hualingmyproject.presenter;

import com.hualing.hualingmyproject.model.dao.DBHelper;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 业务的基类
 */

public abstract class BasePresenter<T> {
    //1、数据库业务
    //2、网络数据的业务
    protected  T mHttpAPI;
    protected  DBHelper mDatabaseHelper;

    public BasePresenter(){
        //1.初始化网络请求
        if(mHttpAPI==null){
            initNetworkRequest();
        }
        //2、数据库的初始化
        initDatabaseHelper();
    }

    /**
     * 数据库的初始化
     */
    private void initDatabaseHelper() {
        mDatabaseHelper = DBHelper.getInstants();
    }

    /**
     * 初始化网络请求
     */
    private void initNetworkRequest() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(setBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mHttpAPI = retrofit.create(setCallBackResultInfoAPI());
    }

    /**
     * 子类实现设置回到信息的接口
     * @return
     */
    protected abstract Class<T> setCallBackResultInfoAPI();

    /**
     * 子类实现设置baseurl地址
     * @return
     */
    protected abstract String setBaseUrl();
}
