package com.hualing.hualingmyproject.dagger.component.activity;

import com.hualing.hualingmyproject.dagger.module.activity.SplashActivityModule;
import com.hualing.hualingmyproject.ui.activity.SplashActivity;
import dagger.Component;

/**
 * 启动页面业务对象的Component
 */

@Component(modules = SplashActivityModule.class)
public interface SplashActivityComponent {
    void inject(SplashActivity activity);
}
