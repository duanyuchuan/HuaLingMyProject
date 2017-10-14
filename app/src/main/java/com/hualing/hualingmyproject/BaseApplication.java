package com.hualing.hualingmyproject;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2017/10/13.
 */

public class BaseApplication extends Application{
    private static Context sContext;
    private static Handler sHandler;
    private static int sUiThread;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
        sHandler=new Handler();
        sUiThread=android.os.Process.myPid();
    }

    /**
     * 获取UI线程
     * @return
     */
    public static int getUiThread(){
        return sUiThread;
    }

    /**
     * 获取应用全局的handler对象
     * @return
     */
    public static Handler getHandler(){
        return sHandler;
    }
    /**
     * 获取应用全局上下文对象
     * @return
     */
    public static Context getContext(){
        return sContext;
    }
}
