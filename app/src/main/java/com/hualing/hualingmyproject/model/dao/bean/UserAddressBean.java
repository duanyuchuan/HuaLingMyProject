package com.hualing.hualingmyproject.model.dao.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 用户地址的表
 */

@DatabaseTable(tableName = "t_user_address")
public class UserAddressBean {
    @DatabaseField(id = true)
    private long _id;
    @DatabaseField(canBeNull = false)
    private String goodsAddress;
    @DatabaseField(canBeNull = false)
    private String vallige;
    @DatabaseField(canBeNull = false,foreign = true,foreignColumnName = "_id",columnName = "user_id")
    private UserBean userBean;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }

    public String getVallige() {
        return vallige;
    }

    public void setVallige(String vallige) {
        this.vallige = vallige;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @Override
    public String toString() {
        return "UserAddressBean{" +
                "_id=" + _id +
                ", goodsAddress='" + goodsAddress + '\'' +
                ", vallige='" + vallige + '\'' +
                ", userBean=" + userBean +
                '}';
    }
}
