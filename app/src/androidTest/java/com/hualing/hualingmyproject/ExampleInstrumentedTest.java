package com.hualing.hualingmyproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.hualing.hualingmyproject.model.dao.DBHelper;
import com.hualing.hualingmyproject.model.dao.bean.UserAddressBean;
import com.hualing.hualingmyproject.model.dao.bean.UserBean;
import com.j256.ormlite.dao.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private Context appContext= InstrumentationRegistry.getTargetContext();
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.hualing.hualingmyproject", appContext.getPackageName());
    }
    @Test
    public void testCreateDB(){
        DBHelper dbHelper=DBHelper.getInstants();
        dbHelper.getWritableDatabase();
    }
    @Test
    public void testUser() throws SQLException {
        DBHelper dbHelper= DBHelper.getInstants();
        Dao<UserBean, Long> dao = dbHelper.getDao(UserBean.class);
        UserBean userBean=new UserBean();
        userBean.set_id(1);
        dao.create(userBean);
        UserBean userBean1=new UserBean();
        userBean1.set_id(2);
        dao.create(userBean1);
    }
    @Test
    public void testAddAddress() throws SQLException {
        DBHelper dbHelper=DBHelper.getInstants();
        Dao<UserAddressBean, Long> dao = dbHelper.getDao(UserAddressBean.class);
        UserBean userBean=new UserBean();
        userBean.set_id(2);

        for(int i=0;i<10;i++){
            UserAddressBean userAddressBean=new UserAddressBean();

            userAddressBean.set_id(i);
            userAddressBean.setGoodsAddress("测试地址"+i);
            userAddressBean.setVallige("萌牌号："+i);
            userAddressBean.setUserBean(userBean);
            dao.create(userAddressBean);
        }
    }
    @Test
    public void testFind() throws SQLException {
        DBHelper dbHelper=DBHelper.getInstants();
        Dao<UserBean, Long> dao = dbHelper.getDao(UserBean.class);
        UserBean userBean = dao.queryForId(1L);
        Log.i("HuaLing",userBean.toString());

    }
}
