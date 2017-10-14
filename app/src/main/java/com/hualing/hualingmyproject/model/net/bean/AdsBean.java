package com.hualing.hualingmyproject.model.net.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/13.
 */

public class AdsBean {
    private ActionParamsBean action_params;
    private ArrayList<String> res_url;

    public ActionParamsBean getAction_params() {
        return action_params;
    }

    public void setAction_params(ActionParamsBean action_params) {
        this.action_params = action_params;
    }

    public ArrayList<String> getRes_url() {
        return res_url;
    }

    public void setRes_url(ArrayList<String> res_url) {
        this.res_url = res_url;
    }

    @Override
    public String toString() {
        return "AdsBean{" +
                "action_params=" + action_params +
                ", res_url=" + res_url +
                '}';
    }
}
