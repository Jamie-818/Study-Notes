# 什么是Spring Cloud Alibaba
 - Spring Cloud 的子项目
 - 致力于提供微服务开发的一站式解决方案
    - 包含微服务开发的必备组件
    - 基于SpringCloud，符合SpringCloud标准
    - 阿里的微服务解决方案
# 什么是Spring Cloud？
 - 快速构建分布式系统的工具集
# SpringCloud的主要功能
  ![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/SpringCloud%E7%9A%84%E4%B8%BB%E8%A6%81%E5%8A%9F%E8%83%BD.png)
# SpringCloud 常用的子项目
![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/SpringCloud%E5%B8%B8%E7%94%A8%E5%AD%90%E9%A1%B9%E7%9B%AE.png)  
# SpringCloudAlibaba主要功能
- **服务限流降级**：默认支持 Servlet、Feign、RestTemplate、Dubbo 和 RocketMQ 限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级 Metrics 监控。
- **服务注册与发现**：适配 Spring Cloud 服务注册与发现标准，默认集成了 Ribbon 的支持。
- **分布式配置管理**：支持分布式系统中的外部化配置，配置更改时自动刷新。
- **消息驱动能力**：基于 Spring Cloud Stream 为微服务应用构建消息驱动能力。
- **分布式事务**：使用 @GlobalTransactional 注解， 高效并且对业务零侵入地解决分布式事务问题。。
- **阿里云对象存储**：阿里云提供的海量、安全、低成本、高可靠的云存储服务。支持在任何应用、任何时间、任何地点存储和访问任意类型的数据。
- **分布式任务调度**：提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。同时提供分布式的任务执行模型，如网格任务。网格任务支持海量子任务均匀分配到所有 Worker（schedulerx-client）上执行。
- **阿里云短信服务**：覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

# 版本与兼容性
## SpringCloud版本命名
- Release Trains
    - Spring Cloud is an umbrella project consisting of independent projects with, in principle, different release cadences. To manage the portfolio a BOM (Bill of Materials) is published with a curated set of dependencies on the individual project (see below). The release trains have names, not versions, to avoid confusion with the sub-projects. The names are an alphabetic sequence (so you can sort them chronologically) with names of London Tube stations ("Angel" is the first release, "Brixton" is the second). When point releases of the individual projects accumulate to a critical mass, or if there is a critical bug in one of them that needs to be available to everyone, the release train will push out "service releases" with names ending ".SRX", where "X" is a number.
    - Spring Cloud是一个由独立项目组成的总体项目，原则上具有不同的发布节奏。 为了管理投资组合，发布了BOM（物料清单），其中包含一组针对单个项目的依赖关系（见下文）。 发布列车有名称而不是版本，以避免与子项目混淆。 名称是字母序列（因此您可以按时间顺序对它们进行排序）使用伦敦地铁站的名称（“天使”是第一个版本，“布里克斯顿”是第二个版本）。 当各个项目的点数累积到临界质量时，或者其中一个项目中存在一个需要每个人都可用的关键错误时，发布序列将推出名称结尾为“.SRX”的“服务版本”， 其中“X”是一个数字。
    - SR{number}
        - Service Release:第N个bug修复版本
    - RELEASE
        - 第一个正式版本
    - RELEASE => SR1 => SR2 ....  
    
|Release Train|Boot Version|
|:---|:---:|
|Greenwich|2.1.x|
|Finchley|2.0.x|
|Edgware|1.5.x|
|Dalston|1.5.x|

## SpringCloud生命周期
  - 版本发布规则
    - https://github.com/spring-cloud/spring-cloud-release/milestones
  - 版本发布记录
    - https://github.com/spring-cloud/spring-cloud-release/releases
  - 版本终止声明
    - https://spring.io/projects/spring-cloud#overview
## 版本兼容性(目前)

|Spring Cloud版本|Spring Cloud Alibaba版本|Spring Boot版本
|:---|:---:|:---:|
|Spring Cloud Greenwich|0.9.0.RELEASE|2.1.x.RELEASE|
|Spring Cloud Finchley|0.2.x.RELEASE|2.0.x.RELEASE|
|Spring Cloud Edgware|0.1.x.RELEASE|1.5.x.RELEASE|

## 生产环境如何选择版本
- 坚决不用非稳定版本/end-of-life版本
- 尽量用最新一代版本
    - RELEASE版本缓一缓(因为是第一个正式版)
    - SR2之后一般可大规模使用

