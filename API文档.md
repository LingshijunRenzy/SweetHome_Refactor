# 猫鼠小窝博客 API 文档

## 目录

1. 用户相关接口

2. 文章相关接口

3. 评论相关接口

## 用户相关接口

### 登录
- 请求方式：`POST`
- 请求地址：`/login`
- 请求参数：
  - `loginContext`: 登录账号（邮箱或电话号码）
  - `password`：密码
- 返回参数：
  - 'code': 状态码，200表示成功，400表示失败
  - 'message': 提示信息
  - 'data': 返回数据
    - 'user': 用户信息
      - 'id': 用户ID
      - 'username': 用户名
      - 'password': 密码
      - 'email': 邮箱
      - 'phone': 电话
      - 'create_time': 创建时间
      - 'update_time': 更新时间
      - 'avatar': 头像
      - 'signature': 个性签名
      - 'article_count': 文章数
      - 'comment_count': 评论数
      - 'liked_count': 点赞数
      - 'follow_count': 关注数
      - 'fans_count': 粉丝数
      - 'is_admin': 是否管理员
      - 'status': 状态
    - 'token': token
- 请求示例(shell)
```shell
POST http://localhost:8080/login?
loginContext=18988112345&
password=123456
```
- 返回示例
```json
{
  "code": 200,
  "message": "Login success",
  "data": {
    "user": {
      "id": 2,
      "username": "鲁迅",
      "password": "123456",
      "email": "123@456.com",
      "phone": "18988112345",
      "create_time": "2024-05-21T07:00:32.000+00:00",
      "update_time": "2024-05-21T07:00:32.000+00:00",
      "avatar": "avatar2.jpg",
      "signature": "两颗枣树",
      "article_count": 1,
      "comment_count": 2,
      "liked_count": 3,
      "follow_count": 4,
      "fans_count": 5,
      "is_admin": 0,
      "status": 1
    },
    "token": "token"
  }
}
```

### 注册
- 请求方式：`POST`
- 请求地址：`/register`
- 请求参数：
  - `username`: 用户名
  - `password`: 密码
  - `email`: 邮箱
  - `phone`: 电话
- 返回参数：
  - 'code': 状态码，200表示成功，400表示失败
  - 'message': 提示信息
  - 'data': 返回数据
    - 'user': 用户信息
      - 'id': 用户ID
      - 'username': 用户名
      - 'password': 密码
      - 'email': 邮箱
      - 'phone': 电话
      - 'create_time': 创建时间
      - 'update_time': 更新时间
      - 'avatar': 头像
      - 'signature': 个性签名
      - 'article_count': 文章数
      - 'comment_count': 评论数
      - 'liked_count': 点赞数
      - 'follow_count': 关注数
      - 'fans_count': 粉丝数
      - 'is_admin': 是否管理员
      - 'status': 状态
    - 'token': token
- 请求示例(shell)
```shell
POST http://localhost:8080/register?
    username=张三&
    email=LuoXiang@ShuoXingFa.com&
    phone=13954123232&
    password=asdasd
```
- 返回示例
```json
{
	"code": 200,
	"message": "Register success",
	"data": {
		"user": {
			"id": 7,
			"username": "张三",
			"password": "asdasd",
			"email": "LuoXiang@ShuoXingFa.com",
			"phone": "13954123232",
			"create_time": "2024-05-21T07:48:20.155+00:00",
			"update_time": "2024-05-21T07:48:20.155+00:00",
			"avatar": "default.jpg",
			"signature": "这个人很懒，什么都没有留下",
			"article_count": 0,
			"comment_count": 0,
			"liked_count": 0,
			"follow_count": 0,
			"fans_count": 0,
			"is_admin": 0,
			"status": 1
		},
		"token": "token"
	}
}
```

## 文章相关接口
### 发布文章
- 请求方式：`POST`
- 