## 博客介绍

<p align=center>
  <a href="http://www.deilumengyu.top">
    <img src="http://static.deilumengyu.top/upload/config/a96e0a8b586757512b91b795e55f0ab6.png" alt="得鹿梦鱼个人博客">
  </a>
</p>


<p align=center>
   基于Springboot + Vue 开发的前后端分离博客
</p>

<p align="center">
   <a target="_blank" href="https://github.com/X1192176811/blog">
      <img src="https://img.shields.io/hexpm/l/plug.svg"/>
      <img src="https://img.shields.io/badge/JDK-1.8+-green.svg"/>
      <img src="https://img.shields.io/badge/springboot-2.4.2.RELEASE-green"/>
      <img src="https://img.shields.io/badge/vue-2.5.17-green"/>
      <img src="https://img.shields.io/badge/mysql-8.0.20-green"/>
      <img src="https://img.shields.io/badge/mybatis--plus-3.4.0-green"/>
      <img src="https://img.shields.io/badge/redis-6.0.5-green"/>
   </a>
</p>
                                                                [在线地址](#在线地址) | [目录结构](#目录结构) | [项目特点](#项目特点) | [技术介绍](#技术介绍)  | [项目截图](#项目截图) | 

## 在线地址

**项目链接：** [www.delumengyu.top](http://www.delumengyu.top)

**后台链接：** [admin.delumengyu.top](http://admin.delumengyu.top)

测试账号：test@163.com，密码：123456，可登入后台查看。

**Github地址：** [https://github.com/deilumengyu/blog](https://github.com/deilumengyu/blog)

**Gitee地址：** [https://gitee.com/feng_meiyu/blog](https://gitee.com/feng_meiyu/blog)

**在线接口文档地址：** [http://www.deilumengyu.top/api/doc.html](http://www.deilumengyu.top/api/doc.html)

## 目录结构

前端项目，blog为前台，admin为后台。

SQL文件位于根目录下的blog-mysql8.sql，需要MYSQL8以上版本。

可直接导入该项目于本地，修改后端配置文件中的数据库等连接信息。

当你克隆项目到本地后可使用邮箱账号：admin@qq.com，密码：1234567 进行登录，也可自行注册账号并将其修改为admin角色。

本地访问接口文档地址：[http://127.0.0.1:8080/doc.html](http://127.0.0.1:8080/doc.html)

**ps：请先运行后端项目，再启动前端项目，前端项目配置由后端动态加载。** 

```
black_myblog
├── annotation    --  自定义注解
├── aspect        --  aop模块
├── config        --  配置模块
├── constant      --  常量模块
├── consumer      --  MQ消费者模块
├── controller    --  控制器模块
├── dao           --  框架核心模块
├── dto           --  dto模块
├── enums         --  枚举模块
├── exception     --  自定义异常模块
├── handler       --  处理器模块（扩展Security过滤器，自定义Security提示信息等）
├── service       --  服务模块
├── strategy      --  策略模块（搜索模式，上传文件模式等策略）
├── util          --  工具类模块
└── vo            --  vo模块
```

## 项目特点

- 前台参考"Hexo"的"Butterfly"设计，美观简洁，响应式体验好。
- 后台参考"element-admin"设计，侧边栏，历史标签，面包屑自动生成。
- 采用Markdown编辑器，写法简单。
- 评论支持表情输入回复等，样式参考Valine。
- 前后端分离部署，适应当前潮流。
- 支持发布说说，随时分享趣事。
- 留言采用弹幕墙，更加炫酷。
- 搜索文章支持，响应速度快。
- 新增文章目录、推荐文章等功能，优化用户体验。
- 新增在线聊天室，统计未读数量等功能。
- 新增aop注解实现日志管理。  
- 支持动态权限修改，采用RBAC模型，前端菜单和后台权限实时更新。
- 后台管理支持修改背景图片，博客配置等信息，操作简单，支持上传相册。
- 采用策略模式支持多种上传模式，可支持自行配置。
- 代码遵循阿里巴巴开发规范，利于开发者学习。

## 技术介绍

**前端：** vue + vuex + vue-router + axios + vuetify + element + echarts

**后端：** SpringBoot + nginx + SpringSecurity + Swagger2 + MyBatisPlus + Mysql + Redis  + Websocket

![image-20230619160842169](C:\Users\CH\AppData\Roaming\Typora\typora-user-images\image-20230619160842169.png)

![image-20230619161007519](C:\Users\CH\AppData\Roaming\Typora\typora-user-images\image-20230619161007519.png)





