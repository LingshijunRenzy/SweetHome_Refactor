package org.tomjerry.sweethome.response;

import org.tomjerry.sweethome.pojo.entity.UserEntity;

public class LoginResponse {
    private UserEntity user;
    private String token;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
