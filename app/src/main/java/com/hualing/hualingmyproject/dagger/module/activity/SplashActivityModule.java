package com.hualing.hualingmyproject.dagger.module.activity;

import com.hualing.hualingmyproject.presenter.activity.SplashActivityPresenter;
import com.hualing.hualingmyproject.ui.activity.SplashActivity;
import dagger.Module;
import dagger.Provides;

/**
 * 启动页面业务对象的module
 */

@Module
public class SplashActivityModule {
    SplashActivity mActivity;

    public SplashActivityModule(SplashActivity activity){
        this.mActivity=activity;
    }

    @Provides
    SplashActivityPresenter provideSplashActivityPresenter(){
        return new SplashActivityPresenter(mActivity);
    }

}
