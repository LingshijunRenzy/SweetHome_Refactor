# 猫鼠小窝博客项目后端
## 简介
本项目是2024OOP的课程大作业，是一个博客项目，  
分为前端和后端两部分。本项目是后端部分，使用SpringBoot框架，数据库使用MySQL，前端使用Vue.js框架。  
本项目实现了用户的注册、登录、发表文章、评论文章、点赞文章、关注用户等功能。  
本文将介绍此后端仓库从下载到开发和运行的详细步骤  

注意：本项目强烈推荐使用IDEA开发！

## 文档目录
- [下载/设置/运行](#下载设置运行)
- [着手开发](#着手开发)
    - [项目主要结构](#项目主要结构)
    - [添加新功能](#添加新功能)
- [运行测试](#运行测试)
    - [使用IDEA自带的http客户端测试API接口](#使用IDEA自带的http客户端测试API接口)
    - [使用test包中的测试类来测试代码](#使用test包中的测试类来测试代码)
    - [使用Postman来测试API接口](#使用Postman来测试API接口)
- [上传更改](#上传更改)
## 下载/设置/运行
1. 下载本仓库
```shell
git clone https://github.com/LingshijunRenzy/SweetHome_Bakcend
```
2. 使用IDEA打开本项目
3. 数据库设置
    - 确保你的电脑上安装了MySQL数据库
    - 在项目根目录打开命令行或者使用图形化工具登录MySQL，运行数据库创建脚本
    ```shell
    mysql -u root -p < src/main/resources/sql/init.sql
    ```
    强烈建议在运行好创建脚本后，检查数据库是否创建成功，以及表是否创建成功
    也可以在IDEA中找到脚本并右键执行
    可以在此处查看如何检查数据库：<https://blog.csdn.net/Micaelyu/article/details/104852064>
    - 修改数据库连接配置
    打开`src/main/resources/application.properties`文件，修改数据库连接配置
    ```properties
    # 修改为你的数据库连接地址,如果你的端口号不是3306，请修改
    spring.datasource.url=jdbc:mysql://localhost:3306/sweethome?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8 
    # 修改为你的数据库用户名 
    spring.datasource.username=root
    # 修改为你的数据库密码
    spring.datasource.password=123456
    ```
5. 运行项目  
    - 确保运行项目前，已经启动了mysql服务
    - 在IDEA中运行项目，运行`src/main/java/com/tomjerry/sweethome/SweethomeApplication.java`文件
    - 如果一切正常，你将看到如下输出
    ```shell
    2021-06-20 16:00:00.000  INFO 12345 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2021-06-20 16:00:00.000  INFO 12345 --- [           main] c.r.sweethome.SweethomeApplication       : Started SweethomeApplication in 2.345 seconds (JVM running for 3.456)
    ```
    - 项目启动成功后，你可以在浏览器中输入`http://localhost:8080`来访问项目
    - 如果你看到以下内容，说明项目启动成功（由于项目中没有任何Html页面，看到Whitelabel Error Page是正常的）  
      **Whitelabel Error Page**  
         This application has no explicit mapping for /error, so you are seeing this as a fallback.

## 着手开发
### 项目主要结构
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── tomjerry
│   │           ├── controller # 控制器
│   │           ├── dao # 数据访问层, 当repository无法满足需求时，可以使用JpaRepository自定义SQL语句
│   │           ├── pojo # 数据库实体类
│   │           ├── repository # 数据访问层接口，使用JpaRepository，不需要自己写SQL语句
│   │           ├── response # 返回结果封装类
│   │           ├── service # 服务层
│   │           ├── util # 工具类
│   │           ├── exception # 异常类
│   │           └── SweethomeApplication.java # 项目启动类
│   └── resources
│       ├── application.properties # 配置文件
│       ├── sql # 数据库初始化脚本
│       │    ├── init.sql # 创建数据库和表
│       │    └── data.sql # 插入测试数据
│       └── static # 静态资源
└── test
    └── java
        └── com
            └── tomjerry
                └── SweethomeApplicationTests.java # 测试类
```

### 添加新功能
在开始写代码前，应先在IDEA中连接到数据库  
在此处查看如何连接数据库：<https://blog.csdn.net/Royalic/article/details/119604763>
1. 在`entity`包中添加新的数据库实体类  
- 示例代码 仅供参考
```java
package com.tomjerry.entity;

import ...

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String introduction;
    private String role;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    // 省略getter和setter
}
```
2. 在`repository`包中添加新的数据访问层接口  
在这里查看JpaRepository的教程: <https://blog.csdn.net/fly910905/article/details/78557110>
- 示例代码 仅供参考
```java
//UserRepository.java
package com.tomjerry.repository;

import ...

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
}
```
3. 在`service`包中添加新的服务层接口和实现类  
- 示例代码
```java
//UserService.java
package com.tomjerry.service;

import ...

public interface UserService {
    User register(User user);
    User login(String username, String password);
    User update(User user);
    User getUserById(Integer id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void deleteUser(Integer id);
}
```
```java
//UserServiceImpl.java
package com.tomjerry.service.impl;

import ...

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        // 你的代码
    }
    ...
}
```

5. 在`controller`包中添加新的控制器
- 示例代码 仅供参考
```java
package com.tomjerry.controller;

import ...

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Result register(@RequestBody User user) {
        return Result.success(userService.register(user));
    }

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        return Result.success(userService.login(user.getUsername(), user.getPassword()));
    }
}
```
6. 处理异常
- 在`exception`包中添加新的异常类
- 示例代码 仅供参考
```java
package com.tomjerry.exception;

import ...

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
```

## 运行测试
### 使用IDEA自带的http客户端测试API接口
- 在IDEA中，打开“端口”页面，可以看到当前整个项目中的所有API接口
- 点击接口名，可以看到接口的详细信息
- 确保项目处在运行状态
- 在“HTTP客户端”中，可以编辑要提交的请求信息，然后点击“提交请求”按钮，可以测试API接口
### 使用test包中的测试类来测试代码
在`test`包中，有一个测试类`SweethomeApplicationTests.java`
- 这个类中包含了一些测试方法，可以用来测试项目中的一些功能
- 你可以在这个类中添加新的测试方法，来测试你新添加的功能
- 运行测试方法的方式：在IDEA中，右键点击测试方法名，选择`Run 'testMethod()'`
- 如果测试通过，你将看到如下输出
```shell
2021-06-20 16:00:00.000  INFO 12345 --- [           main] c.r.sweethome.SweethomeApplicationTests  : Started SweethomeApplicationTests in 2.345 seconds (JVM running for 3.456)
```

### 使用Postman来测试API接口
- (文档该部分未完善，可以自行尝试)
- Postman是一个强大的API测试工具，可以帮助你测试API接口
- 可以在这里查看使用教程: <https://blog.csdn.net/huace3852/article/details/136712238>

## 上传更改
- 确保在上传到github前，你的代码是经过测试的，并且没有错误
- 确保在commit前，你的代码是经过格式化的
- 在提交信息中详细描述更改内容
