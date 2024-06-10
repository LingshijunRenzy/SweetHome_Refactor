package org.tomjerry.sweethome.vo.response;

public class LoginResponse {
    private UserResponse user;
    private String token;

    //Getter and Setter

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
