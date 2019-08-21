# SpringCloud 微服务(架构篇)
---

## 软件架构的进化  

---

### 什么是软件架构  

- 软件架构是在软件的内部，经过<mark>综合各种因素</mark>的考量、权衡，<mark>选择特定的技术</mark>，将系统<mark>划分成不同的部分</mark>并使这些部分相互分工，彼此协作，为用户提供需要的价值  

---

### 有哪些因素  
- 业务需求  
- 技术栈  
- 成本  
- 组织架构  
- 可扩展性  
- 可维护性  

---

### 架构演进  

![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E6%9E%B6%E6%9E%84%E6%BC%94%E8%BF%9B.png)

----

- 单一应用架构  
![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E5%8D%95%E4%B8%80%E5%BA%94%E7%94%A8%E6%9E%B6%E6%9E%84.png)

----

- 垂直应用架构  
![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E5%9E%82%E7%9B%B4%E5%BA%94%E7%94%A8%E6%9E%B6%E6%9E%84.png)

----

- 分布式服务架构  
![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E5%88%86%E5%B8%83%E5%BC%8F%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84.png)

----

- 流动计算架构  
![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E6%B5%81%E5%8A%A8%E8%AE%A1%E7%AE%97%E6%9E%B6%E6%9E%84.png) 

---

### 单体架构  

- 优点  
  - 容易测试  
  - 容易部署  
- 缺点  
  - 开发效率低  
  - 代码维护难  
  - 部署不灵活  
  - 稳定性不高  
  - 扩展性不强  

---

### 分布式定义  

- 旨在支持应用程序和服务的开发，可以利用物理架构，由多个自治的处理元素，不共享主内存，但通过网络发送消息合作  

---

## 什么是微服务  
- 在此引用 ThoughtWorks 公司的首席科学家 Martin Fowler 的一段话：

----

  - In short, the microservice architectural style is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery. There is a bare minimum of centralized management of these services, which may be written in different programming languages and use different data storage technologies.  

----

- 谷歌翻译如下：  
    - 简而言之，微服务<mark>架构风格</mark>是一种将单个应用程序作为<mark>一套小型服务开发</mark>的方法，每种应用程序都在<mark>自己的进程</mark>中运行，并与<mark>轻量级机制</mark>（通常是HTTP资源API）进行通信。 这些服务是<mark>围绕业务功能</mark>构建的，可以通过全自动部署机制<mark>独立部署</mark>。 这些服务的集中管理最少，可以用不<mark>同的编程语言</mark>编写，并使用<mark>不同的数据存储</mark>技术。  

---

  - 微服务是一种架构风格  
  - 一系列微小的服务共同组成  
  - 跑在自己的进程里  
  - 每个服务为独立的业务开发  
  - 独立部署  
  - 独立数据  
  - 服务间可以是不同语言  

---

### 微服务的特征  

- 单一职责  
- 轻量级通讯  
- 隔离性  
- 有自己的数据  
- 技术多样性  

---

### 微服务兴起的原因  

- 互联网行业的快速发展  
- 敏捷开发，精益方式深入人心  
- 容器技术的成熟  

---

### 微服务架构的优势和不足  

- 优势  
  - 独立性
  - 敏捷性  
  - 技术栈灵活  
  - 高效团队  
- 不足  
  - 额外的工作（DDD【Domain-Driven Design 领域驱动设计】可以做微服务拆分的学习）
  - 数据一致性
  - 沟通成本  

---

## 微服务如何拆分  

---

### 微服务拆分的起点  

- 起点  
  - 既有架构的形态  

- 终点  
   - 好的架构不是设计出来的，而是进化出来的  
   - 一直在演进ing  

---

### 适合上微服务么？  

- 业务形态不适合的  
  - 系统中包含很多很多强事务场景的  
  - 业务相对稳定，迭代周期长  
  - 访问压力不大，可用性要求不高  
  - ...  

---

### 康威定律和微服务  

- 传统和微服务
  ![传统和微服务](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E4%BC%A0%E7%BB%9F%E5%92%8C%E5%BE%AE%E6%9C%8D%E5%8A%A1.png)

----

- 康威定律  

  - 任何组织在设计一套系统(广义概念上的系统)时，所交付的设计方案在结构上都与该组织的沟通结构保持一致  
  - 沟通的问题会影响系统的设计  

  > 所以，上不上微服务已经不是使用某个技术栈的技术问题了，已经上升到一个团队结构有关的管理问题了    

---

### 服务拆分的方法论  

---

#### 扩展立方模型（Scale Cube）  

   ![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E6%89%A9%E5%B1%95%E7%AB%8B%E6%96%B9%E6%A8%A1%E5%9E%8B%EF%BC%88Scale%20Cube%EF%BC%89.png)

----

##### X轴 水平复制  

- 通过将应用程序水平复制，通过负载均衡运行多个完全一样的副本，来实现应用程序的伸缩性，提高应用程序的容量和可用度  

##### Z轴 数据分区  

- 每个服务器负责的一个数据子集，每个服务器运行的代码是一样的  

##### Y轴 功能解耦  

- 将不同职等的模块分成不同的服务  

---

#### 如何拆“功能”  

- 单一职责，松耦合、高内聚  
- 关注点分离  
  - 按职责  
  - 按通用性  
  - 按粒度级别  

---

#### 服务和数据的关系  

- 先考虑业务功能，再考虑数据  
- 无状态服务  
  ![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E6%97%A0%E7%8A%B6%E6%80%81%E6%9C%8D%E5%8A%A1.png)

---

#### 如何拆"数据"  

- 每个微服务都有单独的数据存储  
- 依据服务特点选择不同结构的数据库类型  
- 难点在于确定边界  
  - 针对边界设计API  
  - 依据边界权衡数据冗余  

---

## 微服务核心组件  

---

### 微服务带来的问题  

- 微服务间如何发现彼此  
- 服务间如何通讯  
- 微服务容错处理  
- 微服务的配置问题  

---

### SpringCloud核心组件  

- Eureka(注册中心)  
- Ribbon(负载均衡)  
- Hystrix(断路器)  
- Zuul(服务网关)  
- Config(配置中心)  

---

#### Eureka(注册中心)

- 在分布式系统里，必须要有一个角色对所有微服务的状态、地址、及实例数进行集中管理和收集，并能定期的监控所有微服务的状态，这就是Eureka，能提供服务注册和注册中心功能 
![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/eureka.png)

----

- 两个组件组成  
  - Eureka Server 注册中心  
  - Eureka Client 服务注册  
    - 服务端发现和客户端发现  
      ![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E6%9C%8D%E5%8A%A1%E7%AB%AF%E4%B8%8E%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%8F%91%E7%8E%B0.png)

---

#### Ribbon(负载均衡)  

- Ribbon是SpringCloudNetfilix微服务套件中的一部分，提供负责均衡、容错、异步和多协议(HTTP,TCP,UDP)支持、缓存、批处理功能 .
![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/eureka.png)

---

#### Hystrix(断路器)    

- 在一个分布式系统里，许多依赖不可避免的会调用失败，比如超时、异常等，如何能够保证在一个依赖出问题的情况下，不会导致整体服务失败，这个就是Hystrix需要做的事情。Hystrix提供了熔断、隔离、Fallback、cache、监控等功能，能够在一个、或多个依赖同时出现问题时保证系统依然可用。  

----

![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/Hystrix%E6%B5%81%E7%A8%8B.png)

----

- 熔断  
  - 当Hystrix Command请求后端服务失败数量超过一定比例(默认50%), 断路器会切换到开路状态(Open). 这时所有请求会直接失败而不会发送到后端服务. 

----

  - 断路器保持在开路状态一段时间后(默认5秒), 自动切换到半开路状态(HALF-OPEN). 这时会判断下一次请求的返回情况,如果请求成功, 断路器切回闭路状态(CLOSED), 否则重新切换到开路状态(OPEN). 

----

  - Hystrix的断路器就像我们家庭电路中的保险丝, 一旦后端服务不可用, 断路器会直接切断请求链, 避免发送大量无效请求影响系统吞吐量, 并且断路器有自我检测并恢复的能力.  

----

- 隔离  
  - 在Hystrix中, 主要通过线程池来实现资源隔离. 通常在使用的时候我们会根据调用的远程服务划分出多个线程池.
    - ![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E7%BA%BF%E7%A8%8B%E8%BF%9E%E6%8E%A5.png)

----

- Fallback  
  - Fallback相当于是降级操作. 对于查询操作, 我们可以实现一个fallback方法, 当请求后端服务出现异常的时候, 可以使用fallback方法返回的值. fallback方法的返回值一般是设置的默认值或者来自缓存.告知后面的请求服务不可用了，不要再来了。  

----

- cahce  
  - 比如一个请求过来请求我userId=1的数据，你后面的请求也过来请求同样的数据，这时我不会继续走原来的那条请求链路了，而是把第一次请求缓存过了，把第一次的请求结果返回给后面的请求。  

----

- 监控  
  - HyStrix自身提供了监控系统，可以对接口状态进行监控，但是实时性的，没有持久化存储，我们后期是可以用第三方系统监控数据的采集与报警 

---

#### Zuul(服务网关)    

- API网关可以提供一个单独且统一的API入口用于访问内部一个或多个API。简单来说嘛就是一个统一入口，比如现在的支付宝或者微信的相关api服务一样，都有一个统一的api地址，统一的请求参数，统一的鉴权。  

----
  ![服务网关](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E7%BD%91%E5%85%B3.png)

   服务网关  

----

- Zuul的核心一系列的过滤器：  
  - 身份认证与安全：识别每个资源的验证要求，并拒绝那些与要求不符的请求。  
  - 审查与监控：在边缘位置追踪有意义的数据和统计结果，从而带来精确的生产视图。  
  - 动态路由：动态地将请求路由到不同的后端集群。  
  - 压力测试：逐渐增加指向集群的流量，以了解性能。  
  - 负载分配：为每一种负载类型分配对应容量，并启用超出限定值的请求。  
  - 静态响应处理：在边缘位置直接建立部分相应，从而避免其转发到内部集群。  

---

#### Config(配置中心)  
- 在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。  
  - 核心功能  
  - 提供服务端和客户端支持  
  - 集中管理各环境的配置文件  
  - 配置文件修改之后，可以快速的生效  
  - 可以进行版本管理  
  - 支持大的并发查询  
  - 支持各种语言   

----

![](https://image-show.oss-cn-shenzhen.aliyuncs.com/%E7%AE%80%E4%B9%A6%E5%9B%BE%E7%89%87/%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83.png)