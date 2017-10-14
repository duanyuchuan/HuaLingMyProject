package com.hualing.hualingmyproject.utils;

import android.app.Activity;
import java.util.Iterator;
import java.util.Stack;

/**
 * activity的管理工具类
 * 单例模式
 */

public class MyActivityManager {
    private static MyActivityManager sInstance;
    private Stack<Activity> mMyActivityStack=new Stack<>();

    private MyActivityManager(){

    }

    /**
     * 获取activity管理者对象
     * @return
     */
    public static MyActivityManager getInstance(){
        if(sInstance==null){
            sInstance=new MyActivityManager();
        }
        return sInstance;
    }

    /**
     * 向任务栈中添加一个activity
     * @param activity
     */
    public void addActivity(Activity activity){
        if(activity!=null && !mMyActivityStack.contains(activity)){
            mMyActivityStack.add(activity);
        }
    }

    /**
     * 从任务栈中删除一个activity
     * @param activity
     */
    /*
    public void removeActivityIterator(Activity activity){
        if(activity==null || !mMyActivityStack.contains(activity)){
            return;
        }
        Iterator<Activity> iterator = mMyActivityStack.iterator();
        while(iterator.hasNext()){
            Activity myActivity = iterator.next();
            if(myActivity.getClass().equals(activity.getClass())){
                activity.finish();
                mMyActivityStack.remove(activity);
            }
        }
    }
    */
    public void removeActivity(Activity activity){
        if(activity==null || !mMyActivityStack.contains(activity)){
            return;
        }
        //遍历集合是需要边遍历边删除要反着遍历或者采用迭代的方式遍历
        for(int i=getMyActivityStackSize()-1;i>0;i--){
            Activity myActivity = mMyActivityStack.get(i);
            if(myActivity.getClass().equals(activity.getClass())){
                activity.finish();
                mMyActivityStack.remove(activity);
            }
        }
    }

    /**
     * 移除当前的activity对象
     */
    public void removeCurrentActivity(){
        Activity activity = mMyActivityStack.lastElement();
        activity.finish();
        mMyActivityStack.remove(activity);
    }

    /**
     * 移除任务栈中所有的Activity对象
     */
    public void removeAllActivity(){
        Iterator<Activity> iterator = mMyActivityStack.iterator();
        while(iterator.hasNext()){
            Activity activity = iterator.next();
            activity.finish();
            mMyActivityStack.remove(activity);
        }
    }
    /**
     * 获取任务栈的长度
     * @return
     */
    public int getMyActivityStackSize(){
        return mMyActivityStack.size();
    }
}
