package com.hualing.hualingmyproject.model.net.bean;

/**
 * Created by Administrator on 2017/10/13.
 */

public class ActionParamsBean {
    private String fullscreen;
    private String link_url;

    public String getFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(String fullscreen) {
        this.fullscreen = fullscreen;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    @Override
    public String toString() {
        return "ActionParamsBean{" +
                "fullscreen='" + fullscreen + '\'' +
                ", link_url='" + link_url + '\'' +
                '}';
    }
}
