# Hadoop基础与电商行为日志分析
## 环境参数
 - Linux版本：Centos7
 - Hadoop版本：CDH-5.15.1
 - 开发工具：IDEA

---

## 大数据概述
  - 大数据故事
  - 什么是大数据
  - 大数据带来的技术变革
  - 大数据现存的模式
  - 大数据的技术概念
  - 大数据带来的挑战
  - 大数据典型应用

---

### 什么是大数据
####  大数据之4V特征：
   - 数据量（Volume）
   - 多样性，复杂性（Variety）
   - 速度（Velocity）
   - 基于高度分析的新价值（Value）

---

#### 大数据带来的技术变革
  - 技术驱动：数据量大
     - 存储：文件存储  ==> 分布式存储 
     - 计算：单机 ==> 分布式计算
     - 网络：万兆
     - DB：RDBMS  ==> NoSQL
  - 商业驱动

---

#### 大数据现存的模式
  - 手握大数据、没有大数据思维
  - 没有大数据、有大数据思维
  - 既有大数据、也有大数据思维

---

#### 大数据的技术概念
  - 传统 vs 大数据
    - 单机：CPU Memory Disk
    - 分布式：并行计算/处理
  - 技术概念
    - 数据采集 ： Flume Sqoop
    - 大数据存储：Hadoop
    - 数据处理、分析、挖掘：Hadoop、Spark、Fliink...
    - 可视化：
  
---

#### 大数据带来的挑战
   - 主要挑战：
     - 对现有数据库管理技术的挑战
     - 经典的数据库技术并没有考虑数据的多类别
     - 实时性的技术挑战
     - 网络架构、数据中心、运维的挑战
    - 其他挑战
      - 数据隐私
      - 数据源复杂多样
      
---
#### 如何应对大数据的挑战
  - 系统瓶颈
    - 存储容量
    - 读写数据
    - 计算效率
  - Google数据技术
    - MapReduce
    - BigTable
    - GFS
> Google只发表了技术论文，并没有开发源代码
> Hadoop模仿了Google大数据技术 并且开源
---
#### 大数据典型应用
- 技术
  - count/sum/avg
  - group by/join
  - 窗口分析函数
  - 异常/欺诈检测
  - 人工智能
- 业务
  - 报表
  - 用户细分
  - 指标监控
  - 指标预警
---
## 初识Hadoop

--- 

### Hadoop概述

---

#### Hadoop名字的由来
- Hadoop项目作者的孩子给一个棕黄色的大象样子的填充玩具的命名

#### Hadoop的介绍
- The Apache™ Hadoop® project develops open-source software for reliable, scalable, distributed computing.
- The Apache Hadoop software library is a framework that allows for the distributed processing of large data sets across clusters of computers using simple programming models. It is designed to scale up from single servers to thousands of machines, each offering local computation and storage. Rather than rely on hardware to deliver high-availability, the library itself is designed to detect and handle failures at the application layer, so delivering a highly-available service on top of a cluster of computers, each of which may be prone to failures.
- reliable
- scalable
- distributed computing
 - Hadoop：
    - 提供分布式的存储(一个文档被拆分成很多块，并且以副本的方式存储在各个节点中)和计算，是一个分布式的系统基础架构，用户可以在不了解分布式底层细节的情况下进行使用。
  
---

#### Hadoop包含哪些单元
*   **Hadoop Common**: The common utilities that support the other Hadoop modules.
*   **Hadoop Distributed File System (HDFS™)**: A distributed file system that provides high-throughput access to application data.
*   **Hadoop YARN**: A framework for job scheduling and cluster resource management.
*   **Hadoop MapReduce**: A YARN-based system for parallel processing of large data sets.
*   **[Hadoop Ozone](https://hadoop.apache.org/ozone/)**: An object store for Hadoop.
*   **[Hadoop Submarine](https://hadoop.apache.org/submarine/)**: A machine learning engine for Hadoop.
分布式文件系统：HDFS 实现将文件分布式存储在很多服务器上
分布式计算框架：MapReduce 实现在很多机器上分布式并行计算
分布式资源调度框架：YARN实现集群资源管理以及作业的调度

---


### Hadoop核心组件

#### 分布式文件系统HDFS
- 来源：
  - 源自于Google的GFS论文，论文发表于2003年10月
  - HDFS是GFS的克隆版
  - HDFS特点：扩展性&容错性&海量数量存储

- 工作原理：
  - 将文件切分成指定大小的数据库并以多副本的方式存储在多个机器上
  - 数据切分，多副本，容错等操作对用户是透明的
#### 分布式计算系统MapReduce
- 来源：
  - 源自于Google的MapReduce论文，论文发表于2004年12月
  - MapReduce是Google MapReduce的克隆版
  - MapReduce特点：扩展性&容错性&海量数据离线处理

#### 资源调度系统YARN
- 来源
  - YARM : Yet Another Resource Negotiator
  - 负责整个集群资源的管理和调度
  - YARN优点：扩展性&容错性&多框架资源统一调度

---

### Hadoop优势
#### 高可靠性
 - 数据存储：数据库多副本
 - 数据计算：重新调度作业计算
#### 扩展性
 - 存储/计算资源不够时，可以横向的线性扩展机器
 - 一个集群中可以包含数以千计的节点 
#### 其他
 - 存储在廉价机器上，降低成本
 - 成熟的生态圈

---

### Hadoop发展史
[Hadoop 十年解读与发展预测](https://www.infoq.cn/article/hadoop-ten-years-interpretation-and-development-forecast)
- 2002 年 10 月，Doug Cutting 和 Mike Cafarella 创建了开源网页爬虫项目 Nutch。
- 2003 年 10 月，Google 发表 Google File System 论文。
- 2004 年 7 月，Doug Cutting 和 Mike Cafarella 在 Nutch 中实现了类似 GFS 的功能，即后来 HDFS 的前身。
- 2004 年 10 月，Google 发表了 MapReduce 论文。
- 2005 年 2 月，Mike Cafarella 在 Nutch 中实现了 MapReduce 的最初版本。
- 2005 年 12 月，开源搜索项目 Nutch 移植到新框架，使用 MapReduce 和 NDFS(Nutch Distributed File System ) 来运行，在 20 个节点稳定运行。
- 2006 年 1 月，Doug Cutting 加入雅虎，Yahoo! 提供一个专门的团队和资源将 Hadoop 发展成一个可在网络上运行的系统。
- 2006年 2月，Apache Hadoop项目正式启动以支持 MapReduce和 HDFS**** 的独立发展。
- 2006 年 2 月，Yahoo! 的网格计算团队采用 Hadoop。
- 2006 年 3 月，Yahoo! 建设了第一个 Hadoop 集群用于开发。
- 2006 年 4 月，第一个 Apache Hadoop 发布。
- 2006 年 4 月，在 188 个节点上（每个节点 10GB）运行排序测试集需要 47.9 个小时。
- 2006 年 5 月，Yahoo! 建立了一个 300 个节点的 Hadoop 研究集群。
- 2006 年 5 月，在 500 个节点上运行排序测试集需要 42 个小时（硬件配置比 4 月的更好）。
- 2006 年 11 月，研究集群增加到 600 个节点。
- 2006 年 11 月，Google 发表了 Bigtable 论文，这最终激发了 HBase 的创建。
- 2006 年 12 月，排序测试集在 20 个节点上运行 1.8 个小时，100 个节点上运行 3.3 小时，500 个节点上运行 5.2 小时，900 个节点上运行 7.8 个小时。
- 2007 年 1 月，研究集群增加到 900 个节点。
- 2007 年 4 月，研究集群增加到两个 1000 个节点的集群。
- 2007年 10月，第一个 Hadoop**** 用户组会议召开，社区贡献开始急剧上升。
- 2007 年，百度开始使用 Hadoop 做离线处理。
- 2007 年，中国移动开始在“大云”研究中使用 Hadoop 技术。
- 2008 年，淘宝开始投入研究基于 Hadoop 的系统——云梯，并将其用于处理电子商务相关数据。
- 2008年 1月，Hadoop成为 Apache顶级项目。
- 2008 年 2 月，Yahoo! 运行了世界上最大的 Hadoop 应用，宣布其搜索引擎产品部署在一个拥有 1 万个内核的 Hadoop 集群上。
- 2008 年 4 月，在 900 个节点上运行 1TB 排序测试集仅需 209 秒，成为世界最快。
- 2008 年 6 月，Hadoop 的第一个 SQL 框架——Hive 成为了 Hadoop 的子项目。
- 2008 年 7 月，Hadoop 打破 1TB 数据排序基准测试记录。Yahoo! 的一个 Hadoop 集群用 209 秒完成 1TB 数据的排序 ，比上一年的纪录保持者保持的 297 秒快了将近 90 秒。
- 2008年 8月，第一个 Hadoop商业化公司 Cloudera成立。
- 2008 年 10 月，研究集群每天装载 10TB 的数据。
- 2008 年 11 月，Apache Pig 的最初版本发布。
- 2009 年 3 月，17 个集群总共 24000 台机器。
- 2009 年 3月，Cloudera推出世界上首个 Hadoop发行版——CDH（Cloudera’s Distribution including Apache Hadoop）平台，完全由开放源码软件组成。
- 2009 年 4 月，赢得每分钟排序，59 秒内排序 500GB（在 1400 个节点上）和 173 分钟内排序 100TB 数据（在 3400 个节点上）。
- 2009 年 5 月，Yahoo 的团队使用 Hadoop 对 1 TB 的数据进行排序只花了 62 秒时间。
- 2009 年 6 月，Cloudera 的工程师 Tom White 编写的《Hadoop 权威指南》初版出版，后被誉为 Hadoop 圣经。
- 2009 年 7 月 ，Hadoop Core 项目更名为 Hadoop Common;
- 2009 年 7 月 ，MapReduce 和 Hadoop Distributed File System (HDFS) 成为 Hadoop 项目的独立子项目。
- 2009 年 7 月 ，Avro 和 Chukwa 成为 Hadoop 新的子项目。
- 2009 年 8 月，Hadoop 创始人 Doug Cutting 加入 Cloudera 担任首席架构师。
- 2009 年 10 月，首届 Hadoop World 大会在纽约召开。
- 2010 年 5 月 ，Avro 脱离 Hadoop 项目，成为 Apache 顶级项目。
- 2010 年 5 月 ，HBase 脱离 Hadoop 项目，成为 Apache 顶级项目。
- 2010 年 5 月，IBM 提供了基于 Hadoop 的大数据分析软件——InfoSphere BigInsights，包括基础版和企业版。
- 2010 年 9 月，Hive( Facebook) 脱离 Hadoop，成为 Apache 顶级项目。
- 2010 年 9 月，Pig 脱离 Hadoop，成为 Apache 顶级项目。
- 2010年 -2011年，扩大的 Hadoop社区忙于建立大量的新组件（Crunch，Sqoop，Flume**，Oozie等）来扩展 Hadoop的使用场景和可用性。**
- 2011 年 1 月，ZooKeeper 脱离 Hadoop，成为 Apache 顶级项目。
- 2011 年 3 月，Apache Hadoop 获得 Media Guardian Innovation Awards 。
- 2011 年 3 月， Platform Computing 宣布在它的 Symphony 软件中支持 Hadoop MapReduce API。
- 2011年 5月，Mapr Technologies公司推出分布式文件系统和 MapReduce引擎——MapR Distribution for Apache Hadoop。
- 2011 年 5 月，HCatalog 1.0 发布。该项目由 Hortonworks 在 2010 年 3 月份提出，HCatalog 主要用于解决数据存储、元数据的问题，主要解决 HDFS 的瓶颈，它提供了一个地方来存储数据的状态信息，这使得 数据清理和归档工具可以很容易的进行处理。
- 2011 年 4 月，SGI（Silicon Graphics International）基于 SGI Rackable 和 CloudRack 服务器产品线提供 Hadoop 优化的解决方案。
- 2011 年 5 月，EMC 为客户推出一种新的基于开源 Hadoop 解决方案的数据中心设备——GreenPlum HD，以助其满足客户日益增长的数据分析需求并加快利用开源数据分析软件。Greenplum 是 EMC 在 2010 年 7 月收购的一家开源数据仓库公司。
- 2011 年 5 月，在收购了 Engenio 之后， NetApp 推出与 Hadoop 应用结合的产品 E5400 存储系统。
- 2011 年 6 月，Calxeda 公司发起了“开拓者行动”，一个由 10 家软件公司组成的团队将为基于 Calxeda 即将推出的 ARM 系统上芯片设计的服务器提供支持。并为 Hadoop 提供低功耗服务器技术。
- 2011 年 6 月，数据集成供应商 Informatica 发布了其旗舰产品，产品设计初衷是处理当今事务和社会媒体所产生的海量数据，同时支持 Hadoop。
- 2011年 7月，Yahoo!和硅谷风险投资公司 Benchmark Capital创建了 Hortonworks 公司，旨在让 Hadoop更加可靠，并让企业用户更容易安装、管理和使用 Hadoop。
- 2011 年 8 月，Cloudera 公布了一项有益于合作伙伴生态系统的计划——创建一个生态系统，以便硬件供应商、软件供应商以及系统集成商可以一起探索如何使用 Hadoop 更好的洞察数据。
- 2011 年 8 月，Dell 与 Cloudera 联合推出 Hadoop 解决方案——Cloudera Enterprise。Cloudera Enterprise 基于 Dell PowerEdge C2100 机架服务器以及 Dell PowerConnect 6248 以太网交换机。
- 2012 年 3 月，企业必须的重要功能 HDFS NameNode HA 被加入 Hadoop 主版本。
- 2012 年 8 月，另外一个重要的企业适用功能 YARN 成为 Hadoop 子项目。
- 2012 年 10 月，第一个 Hadoop 原生 MPP 查询引擎 Impala 加入到了 Hadoop 生态圈。
- 2014年 2月，Spark逐渐代替 MapReduce成为 Hadoop的缺省执行引擎，并成为 Apache基金会顶级项目。
- 2015 年 2 月，Hortonworks 和 Pivotal 抱团提出“Open Data Platform”的倡议，受到传统企业如 Microsoft、IBM 等企业支持，但其它两大 Hadoop 厂商 Cloudera 和 MapR 拒绝参与。
- 2015 年 10 月，Cloudera 公布继 HBase 以后的第一个 Hadoop 原生存储替代方案——Kudu。
- 2015 年 12 月，Cloudera 发起的 Impala 和 Kudu 项目加入 Apache 孵化器。

---

### Hadoop生态系统
#### 狭义Hadoop Vs 广义Hadoop
 - 狭义Hadoop：是一个适合大数据粗分布式存储、分布式计算、和资源调度的平台。
 - 广义Hadoop：指的是Hadoop生态系统，Hadoop生态系统是一个很庞大的概念，Hadoop是其中一个最基础的部分；生态系统中的每一子系统只解决某一个特定的问题域(甚至可能很窄)，不搞统一型的一个全能系统，而是小而精的多个小系统。
#### Hadoop生态系统的特点
 - 开源、社区活跃
 - 囊括了大数据处理的方方面面
 - 成熟的生态圈

---

### Hadoop发行版选择
常用的Hadoop发行版
 - Apache
   - 优点：纯开源
   - 缺点：不同版本/不同框架之间整合 jar。。。冲突
 - CDH:Http://www.cloudera.com 60-70%
 	- 优点：CM（Cloudera manager） 通过页面一键安装各种框架、升级
 	- 缺点：cm不开源、与社区版本有些许出入
 - Hortonworks：HDP 企业发布自己的数据平台可以直接基于页面框架进行改造
   -  优点：原装Hadoop、纯开源、支持tez
   -  缺点：企业级安全不开源


---

##  分布式文件系统HDFS

---

## 分布式资源调度YARN

---

## 分布式计算框架MapReduce

---

## Hadoop实战

---

## 数据仓库Hive

---

## Hive项目实战

---

## Hadoop分布式集群搭建

---
