package com.hualing.hualingmyproject.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.hualing.hualingmyproject.model.dao.bean.UserAddressBean;
import com.hualing.hualingmyproject.model.dao.bean.UserBean;
import com.hualing.hualingmyproject.utils.UiUtil;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;


/**
 * 创建数据库
 */

public class DBHelper extends OrmLiteSqliteOpenHelper{
    private static final String HUALING_PROJECT_DATABASE_NAME="hualing_project_database_name";
    private static final int HUALING_PROJECT_DATABASE_VERSION=1;
    private static DBHelper sInstants;

    private DBHelper(Context context) {
        super(context, HUALING_PROJECT_DATABASE_NAME, null, HUALING_PROJECT_DATABASE_VERSION);
    }

    /**
     * 单例获取数据库实例
     * 双重锁提过效率
     * @return
     */
    public static DBHelper getInstants(){
        if(sInstants==null){//第一次校验，为了提高效率
            synchronized (DBHelper.class){
                if(sInstants==null){//第二次校验，防止对象的多次创建
                    sInstants=new DBHelper(UiUtil.getContext());
                }
            }
        }
        return sInstants;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, UserBean.class);
            TableUtils.createTable(connectionSource, UserAddressBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
