package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.vo.response.Result;

public interface AdminController {


    Result<String> refreshUserInfo();


    Result<String> refreshArticleInfo();


    Result<String> testAdminConnection(Integer userId);
}
