package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.vo.response.Result;

public interface AdminController {


    Result<String> login(String email, String password);


    Result<String> refreshUserInfo();


    Result<String> refreshArticleInfo();
}
