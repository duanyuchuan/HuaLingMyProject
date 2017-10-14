package com.hualing.hualingmyproject.model.net.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/13.
 */

public class SplashAdsBean{
    private String error;
    private int next_req;
    private int result;
    private int rolls;
    private ArrayList<AdsBean> ads;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getNext_req() {
        return next_req;
    }

    public void setNext_req(int next_req) {
        this.next_req = next_req;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public ArrayList<AdsBean> getAds() {
        return ads;
    }

    public void setAds(ArrayList<AdsBean> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "SplashAdsBean{" +
                "error='" + error + '\'' +
                ", next_req=" + next_req +
                ", result=" + result +
                ", rolls=" + rolls +
                ", ads=" + ads +
                '}';
    }
}
