package com.katti.tokens.load.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue
    private long id;

    private String token;
    private String appDomain;
    private String tokenFormat;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppDomain() {
        return appDomain;
    }

    public void setAppDomain(String appDomain) {
        this.appDomain = appDomain;
    }

    public String getTokenFormat() {
        return tokenFormat;
    }

    public void setTokenFormat(String tokenFormat) {
        this.tokenFormat = tokenFormat;
    }
}
