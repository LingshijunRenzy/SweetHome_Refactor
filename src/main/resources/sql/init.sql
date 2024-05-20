-- 创建名为oop_sweethome的数据库,并设置默认字符集为utf8
CREATE DATABASE IF NOT EXISTS oop_sweethome
       DEFAULT CHARACTER SET utf8;
-- 使用oop_sweethome数据库
USE oop_sweethome;

-- 创建名为user的表
CREATE TABLE IF NOT EXISTS user(
    id INT PRIMARY KEY AUTO_INCREMENT,  -- 主键自增
    username VARCHAR(20) NOT NULL,      -- 用户名
    password VARCHAR(20) NOT NULL,      -- 密码
    email VARCHAR(50) NOT NULL,         -- 邮箱
    phone VARCHAR(20) NOT NULL,         -- 电话
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,       -- 创建时间
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,    -- 更新时间
    avatar VARCHAR(100) NOT NULL DEFAULT 'default.jpg',    -- 头像路径
    signature VARCHAR(100) NOT NULL DEFAULT '这个人很懒，什么都没留下',    -- 个性签名
    article_count INT NOT NULL DEFAULT 0,    -- 文章数量
    comment_count INT NOT NULL DEFAULT 0,    -- 评论数量
    liked_count INT NOT NULL DEFAULT 0,    -- 获赞数量
    follow_count INT NOT NULL DEFAULT 0,    -- 关注数量
    fans_count INT NOT NULL DEFAULT 0,    -- 粉丝数量
    is_admin INT NOT NULL DEFAULT 0,    -- 是否为管理员
    status INT NOT NULL DEFAULT 1    -- 状态
);

-- 创建名为article的表
CREATE TABLE IF NOT EXISTS article(
    id INT PRIMARY KEY AUTO_INCREMENT,  -- 主键自增
    title VARCHAR(255) NOT NULL,      -- 标题
    content TEXT NOT NULL,      -- 内容（纯文字）
    user_id INT NOT NULL,      -- 作者用户id
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,       -- 创建时间
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,    -- 更新时间
    view_count INT NOT NULL DEFAULT 0,    -- 浏览数量
    like_count INT NOT NULL DEFAULT 0,    -- 点赞数量
    comment_count INT NOT NULL DEFAULT 0,    -- 评论数量
    status INT NOT NULL DEFAULT 1    -- 状态
);

-- 创建名为article_media的表,用于存储文章的多媒体文件
CREATE TABLE IF NOT EXISTS article_media(
    id INT PRIMARY KEY AUTO_INCREMENT,  -- 主键自增
    article_id INT NOT NULL,      -- 文章id
    media_type INT NOT NULL,      -- 媒体类型（1-图片，2-音频，3-视频）
    media_url VARCHAR(255) NOT NULL,      -- 媒体url
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP    -- 创建时间
);