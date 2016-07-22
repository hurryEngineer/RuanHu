package edu.nju.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Dora on 2016/7/22.
 */
@Component
public class ApiConfig {

    @Value("${tss.server.address}")
    private String tssApiAddress;

    @Value("${wiki.server.address}")
    private String wikiApiAddress;

    public void setTssApiAddress(String tssApiAddress) {
        this.tssApiAddress = tssApiAddress;
    }

    public void setWikiApiAddress(String wikiApiAddress) {
        this.wikiApiAddress = wikiApiAddress;
    }

    public String getTssApiAddress() {
        return tssApiAddress;
    }

    public String getWikiApiAddress() {
        return wikiApiAddress;
    }
}
