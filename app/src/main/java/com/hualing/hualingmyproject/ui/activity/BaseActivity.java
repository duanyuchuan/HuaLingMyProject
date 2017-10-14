package com.hualing.hualingmyproject.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Activity的基类
 */

public class BaseActivity extends AppCompatActivity {
    private boolean mIsFeatureNoTitle=false;
    private boolean mIsFlagFullScreen=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 填充数据
     */
    protected void initSetDataForUI(){
        //default implements
    }

    /**
     * 设置Activity没有actionbar
     * @param isSetNoTitle
     */
    public void setFeatureNoTitle(boolean isSetNoTitle){
        mIsFeatureNoTitle=isSetNoTitle;
        if(mIsFeatureNoTitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }
    /**
     * 设置沉浸式
     */
    public void setImmersion(boolean isFlagFullScreen){
        mIsFlagFullScreen=isFlagFullScreen;
        if(mIsFlagFullScreen){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

}
