package com.hualing.hualingmyproject.model.net;

/**
 * Created by Administrator on 2017/10/14.
 */

public class ResponesInfo {
    protected long beanId;

    public long getBeanId() {
        return beanId;
    }

    public void setBeanId(long beanId) {
        this.beanId = beanId;
    }

    @Override
    public String toString() {
        return "ResponesInfo{" +
                "beanId=" + beanId +
                '}';
    }
}
