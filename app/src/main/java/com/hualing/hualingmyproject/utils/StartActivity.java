package com.hualing.hualingmyproject.utils;

import android.app.Activity;
import android.content.Intent;

/**跳转页面的工具类
 * Created by Administrator on 2017/7/16.
 */

public class StartActivity<T> {
    private static boolean mIsFinish=true;
    /**跳转页面的方法
     * @param activity
     * @param clazz
     * @param isFinish
     */
    public static void startActivity(Activity activity, Class<?> clazz,boolean isFinish){
        mIsFinish=isFinish;

        Intent intent=new Intent(UiUtil.getContext(),clazz);
        activity.startActivity(intent);
        if(mIsFinish){
            activity.finish();
        }
    }
}
