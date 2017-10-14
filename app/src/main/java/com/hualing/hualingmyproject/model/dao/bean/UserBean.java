package com.hualing.hualingmyproject.model.dao.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 用户表
 */

@DatabaseTable(tableName = "t_user")
public class UserBean {
    @DatabaseField(columnName = "_id",id = true)
    private long _id;
    //需要一个集合去装用户所有地址的对应信息
    @ForeignCollectionField(eager = true)
    private ForeignCollection<UserAddressBean> addressList;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public ForeignCollection<UserAddressBean> getAddressList() {
        return addressList;
    }

    public void setAddressList(ForeignCollection<UserAddressBean> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "_id=" + _id +
                ", addressList=" + addressList +
                '}';
    }
}
