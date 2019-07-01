# Spring必知必会
## SpringBoot是什么，能做什么
- 概述
    - 是一个快速开发的脚手架
    - 作用：快速创建独立的，生产级的基于Spring的应用程序
- 特性：
    - 无需部署WAR文件
    - 提供starter简化配置
    - 尽可能自动配置Spring以及第三方库
    - 提供“生产部署”功能，例如指标、健康检查、外部配置等
    - 无代码生产&无XML
## SpringBoot 应用组成分析
- 依赖：pom.xml
- 启动类：注解
- 配置：application.properties 
- static目录：静态文件
- templates目录：模板文件
## SpringBoot开发三板斧
- 加依赖
    - SpringBoot官方提供的：spring-boot-starter-xxx
    - 非SpringBoot官方提供的：xxx-spring-boot-starter
- 写注解
- 写配置
## SpringBootActuator
- 是什么？
- 如何整合?
    - 加依赖 spring-boot-starter-Actuator
    - 加配置
        - management.endpoint.health.show-details=always
            - 把 health详情展示出来
            - /health
            - 作用：是健康检查
        - info.app-name=spring-boot-demo
        - info.author=show
        - info.email=1004108488@qq.com
            - 建议描述应用
    - 加注解
- 内容：
    - status 取值：
        * UP： 正常
        * DOWN：遇到了问题，不正常
        * OUT_OF_SERVICE：资源未在使用，或者不该使用
        * UNKNOWN：不知道
- 常用端点
    - ![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/SpringBootActuator.png)
- 常用配置
    -  management.endpoint.health.show-details=always
        - 开启health详情页展示
    - info.xxx
        - 描述应用
- 健康检查详解

## SpringBoot配置管理
- 支持的配置格式
    - yaml (Yet Anther Markup Language)==>JSON子集
    - properties
- SpringBoot配置管理-17种姿势
    - ![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/SpringBoot%E9%85%8D%E7%BD%AE%E7%AE%A1%E7%90%8617%E7%A7%8D%E5%A7%BF%E5%8A%BF.png)
- 配置管理常用方式
    - 配置文件
    - 环境变量
    - 外部配置系统
    - 命令行参数    
# Profile
- 如何实现不同环境不同配置
- 怎么使用
    ````yaml
    # 所有环境公用的配置属性
    management:
      endpoint:
        health:
          show-details: always
      endpoints:
        web:
          exposure:
            include: '*'
    info:
      app-name: spring-boot-demo
      author: show
      email: 1004108488@qq.com
    
    #默认启动 dev 环境的配置
    spring:
      profiles:
        active: dev
    # 连字符
    ---
    # profile=x的专用属性，也就是某个环境下的专用属性
    # 开发环境
    spring:
      profiles: dev
    
    ---
    # profile=y的专用属性，也就是某个环境下的专用属性
    # 生产环境
    spring:
      profiles: prod
    server:
      tomcat:
        max-threads: 300
        max-connections: 1000
    ````
    - application-dev.properties
    - application-prod.properties 
