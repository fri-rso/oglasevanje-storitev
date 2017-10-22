package com.adverts;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdvertsProperties {
    private String advertsUrl = "http://localhost:3000";

    public String getAdvertsUrl() {
        return advertsUrl;
    }

    public void setAdvertsUrl(String advertsUrl) {
        this.advertsUrl = advertsUrl;
    }
}
