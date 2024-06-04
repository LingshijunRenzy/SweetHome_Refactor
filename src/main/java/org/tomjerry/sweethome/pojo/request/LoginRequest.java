package org.tomjerry.sweethome.pojo.request;

public class LoginRequest {
    private String loginContext;
    private String password;

    public String getLoginContext() {
        return loginContext;
    }

    public void setLoginContext(String loginContext) {
        this.loginContext = loginContext;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
