package com.hualing.hualingmyproject.presenter.activity;

import com.hualing.hualingmyproject.model.net.bean.SplashAdsBean;
import com.hualing.hualingmyproject.presenter.BasePresenter;
import com.hualing.hualingmyproject.presenter.api.SplashAdsAPI;
import com.hualing.hualingmyproject.ui.activity.SplashActivity;
import com.hualing.hualingmyproject.utils.Logger;
import com.hualing.hualingmyproject.utils.MyConstants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 启动页面获取广告数据的业务类
 */

public class SplashActivityPresenter extends BasePresenter<SplashAdsAPI>{
    private SplashActivity mActivity;

    @Override
    protected Class<SplashAdsAPI> setCallBackResultInfoAPI() {
        return SplashAdsAPI.class;
    }

    @Override
    protected String setBaseUrl() {
        return MyConstants.HUALING_ADS_BASE_URL;
    }

    public SplashActivityPresenter(SplashActivity activity){
        this.mActivity=activity;
    }

    public void getAdsData(){
        Call<SplashAdsBean> call=mHttpAPI.getData(
                "7A16FBB6",
                "android",
                "STARTUP",
                "1",
                "1462779408364",
                "OaBKRDb%2B9FBz%2FXnwAuMBWF38KIbARZdnRLDJ6Kkt9ZMAI3VEJ0RIR9SBSPvaUWjrFtfw1N%2BgxquT0B2pjMN5zsxz13RwOIZQqXxgjCY8cfS8XlZuu2bJj%2FoHqOuDmccGyNEtV%2FX%2FnBofofdcXyudJDmBnAUeMBtnIzHPha2wl%2FQnUPI4%2FNuAdXkYqX028puyLDhnigFtrX1oiC2F7UUuWhDLo0%2BE0gUyeyslVNqLqJCLQ0VeayQa%2BgbsGetk8JHQ"
        );
        call.enqueue(new Callback<SplashAdsBean>() {
            @Override
            public void onResponse(Call<SplashAdsBean> call, Response<SplashAdsBean> response) {
                if(response!=null){
                    if(response.isSuccessful()){
                        Logger.i("HuaLing","数据结果为："+response.body().toString());
                        //handleSuccessDataFormNetwork(call,response);
                    }else{
                        onFailure(call, new Throwable("服务器异常！请稍后重试"));
                    }
                }else{
                    onFailure(call, new Throwable("获取服务器数据失败!请重试"));
                }
            }

            @Override
            public void onFailure(Call<SplashAdsBean> call, Throwable t) {
                //handleSuccessDataFormNetwork(call,response);
                Logger.i("HuaLing","数据失败原因为");
            }
        });
    }
}
