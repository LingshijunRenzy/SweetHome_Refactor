# 猫鼠小窝博客 API 文档

## 目录

1. 用户相关接口

2. 文章相关接口

3. 评论相关接口

## 用户相关接口

### 获取用户信息

- 请求方式：GET
- 请求 URL：/api/user
- 请求参数：
  - userID: 用户 ID
- 返回参数：
  - code: 状态码
  - data: 用户信息
    - username: 用户昵称
    - email: 用户邮箱
    - phone: 用户手机
    - create_time: 用户创建时间
    - update_time: 用户更新时间
    - avatar: 用户头像
    - signature: 用户签名
    - article_count: 用户文章数
    - comment_count: 用户评论数
    - liked_count: 用户获赞数
    - follow_count: 用户关注数
    - fans_count: 用户粉丝数
    - is_admin: 是否为管理员
    - status: 用户状态
- 返回示例：
```json
{
	"code": 200,
	"data": {
		"username": "TomJerry",
		"email": "123@456.com",
		"phone": "12345678901",
		"create_time": "2021-01-01 00:00:00",
		"update_time": "2021-01-01 00:00:00",
		"avatar": "https://www.tomjerry.com/avatar.jpg",
		"signature": "Hello, world!",
		"article_count": 10,
		"comment_count": 20,
		"liked_count": 30,
		"follow_count": 40,
		"fans_count": 50,
		"is_admin": false
	}
}
```