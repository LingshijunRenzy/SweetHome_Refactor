package org.tomjerry.sweethome.vo.request;

public class LoginRequest {
    private String loginContent;
    private String password;

    public String getLoginContent() {
        return loginContent;
    }

    public void setLoginContent(String loginContent) {
        this.loginContent = loginContent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
