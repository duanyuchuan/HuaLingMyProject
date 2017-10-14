package com.hualing.hualingmyproject.ui.activity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hualing.hualingmyproject.R;
import com.hualing.hualingmyproject.dagger.component.activity.DaggerSplashActivityComponent;
import com.hualing.hualingmyproject.dagger.module.activity.SplashActivityModule;
import com.hualing.hualingmyproject.presenter.activity.SplashActivityPresenter;
import com.hualing.hualingmyproject.utils.MyActivityManager;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 启动页面
 */
public class SplashActivity extends BaseActivity {

    //对象的注入
    @Inject
    SplashActivityPresenter mSplashActivityPresenter;

    //xml文件的注解
    @InjectView(R.id.iv_ads)
    ImageView mIvAds;
    @InjectView(R.id.lly_button_bar)
    LinearLayout mLlyButtonBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFeatureNoTitle(true);
        setImmersion(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //xml文件的注解
        ButterKnife.inject(this);
        //activity的管理
        MyActivityManager.getInstance().addActivity(this);

        //设置动画启动
        setAnimation();
        //加载网络数据
        initDataByNetwork();
    }

    /**
     * 加载广告数据
     */
    private void initDataByNetwork() {
        DaggerSplashActivityComponent component = (DaggerSplashActivityComponent)DaggerSplashActivityComponent
                .builder()
                .splashActivityModule(new SplashActivityModule(this))
                .build();
        component.inject(this);
        mSplashActivityPresenter.getAdsData();
    }

    /**
     * 设置动画启动
     */
    private void setAnimation() {
        AlphaAnimation alphaAnimation=new AlphaAnimation(0.2f,1f);
        alphaAnimation.setDuration(3*1000);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(alphaAnimationListener);
        mLlyButtonBar.startAnimation(alphaAnimation);
    }

    private Animation.AnimationListener alphaAnimationListener=new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    @Override
    protected void initSetDataForUI() {
        super.initSetDataForUI();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyActivityManager.getInstance().removeActivity(this);
    }
}
