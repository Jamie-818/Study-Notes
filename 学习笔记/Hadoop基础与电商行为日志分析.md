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
- Introduction
    - The Hadoop Distributed File System (HDFS) is a distributed file system designed to run on commodity hardware. It has many similarities with existing distributed file systems. However, the differences from other distributed file systems are significant. HDFS is highly fault-tolerant and is designed to be deployed on low-cost hardware. HDFS provides high throughput access to application data and is suitable for applications that have large data sets. HDFS relaxes a few POSIX requirements to enable streaming access to file system data. HDFS was originally built as infrastructure for the Apache Nutch web search engine project. HDFS is part of the Apache Hadoop Core project. The project URL is http://hadoop.apache.org/.
      - 分布式
      - Commodity hardware 通用硬件
      - fault-tolerant 容错 
      - high throughput
      - large data sets
      
- 分布式的文件系统
- 文件系统：Linux、Windows、Mac...
    - 目录结构
    - 存放的是文件或者文件夹
    - 对象提供服务：创建、修改、删除、查看、移动等等
- 普通文件系统 vs 分布式文件系统
    - 单机
    - 分布式文件系统能够横跨N个机器
    
---
### HDFS  Assumptions and Goals(设计目标)
- Hardware Failure
    - Hardware failure is the norm rather than the exception. An HDFS instance may consist of hundreds or thousands of server machines, each storing part of the file system’s data. The fact that there are a huge number of components and that each component has a non-trivial probability of failure means that some component of HDFS is always non-functional. Therefore, detection of faults and quick, automatic recovery from them is a core architectural goal of HDFS.
    - 硬件故障是常态而不是例外。HDFS实例可能由数百或数千台服务器机器组成，每台机器存储文件系统数据的一部分。有大量的组件，而且每个组件都有一个非平凡的失败概率，这意味着HDFS的某些组件始终是非功能性的。因此，故障检测和快速、自动的恢复是HDFS的核心架构目标。
        - Hardware failure 
            - 每个机器只存储文件的部分数据，blocksize=128M，Blocksize存放在不同的机器上，由于容错，HDFS默认采用3副本机制
- Streaming Data Access
    - Applications that run on HDFS need streaming access to their data sets. They are not general purpose applications that typically run on general purpose file systems. HDFS is designed more for batch processing rather than interactive use by users. The emphasis is on high throughput of data access rather than low latency of data access. POSIX imposes many hard requirements that are not needed for applications that are targeted for HDFS. POSIX semantics in a few key areas has been traded to increase data throughput rates.
    - 在HDFS运行的应用程序需要对其数据集进行流式访问。它们不是通常在通用文件系统上运行的通用应用程序。HDFS更多的是为批量处理而设计的，而不是供用户交互使用。重点是数据访问的高吞吐量，而不是数据访问的低延迟。POSIX提出了许多针对HDFS的应用程序不需要的硬性要求。一些关键领域的POSIX语义已经被用来提高数据吞吐率。
        - 流式访问
        - 批处理
        - 高吞吐量(不适合做实时处理)      
- Large Data Sets
    - Applications that run on HDFS have large data sets. A typical file in HDFS is gigabytes to terabytes in size. Thus, HDFS is tuned to support large files. It should provide high aggregate data bandwidth and scale to hundreds of nodes in a single cluster. It should support tens of millions of files in a single instance.
    - 在HDFS运行的应用程序有大量数据集。在HDFS，一个典型的文件大小是千兆字节到万亿字节。因此，HDFS被调整为支持大文件。它应该提供高聚合数据带宽，并扩展到单个集群中的数百个节点。它应该在一个实例中支持数千万个文件。
- Moving Computation is Cheaper than Moving Data 移动计算比移动数据更划算     
   - A computation requested by an application is much more efficient if it is executed near the data it operates on. This is especially true when the size of the data set is huge. This minimizes network congestion and increases the overall throughput of the system. The assumption is that it is often better to migrate the computation closer to where the data is located rather than moving the data to where the application is running. HDFS provides interfaces for applications to move themselves closer to where the data is located.
   - 应用程序请求的计算如果在它操作的数据附近执行，效率会高得多。当数据集很大时，尤其如此。这最大限度地减少了网络拥塞，提高了系统的整体吞吐量。假设将计算迁移到更靠近数据所在的位置通常比将数据移动到应用程序运行的位置更好。HDFS为应用程序提供接口，使其更靠近数据所在的位置。
    
---

### HDFS的架构
- NameNode(master) and DataNodes(slave)
    - HDFS has a master/slave architecture. An HDFS cluster consists of a single NameNode, a master server that manages the file system namespace and regulates access to files by clients. In addition, there are a number of DataNodes, usually one per node in the cluster, which manage storage attached to the nodes that they run on. HDFS exposes a file system namespace and allows user data to be stored in files. Internally, a file is split into one or more blocks and these blocks are stored in a set of DataNodes. The NameNode executes file system namespace operations like opening, closing, and renaming files and directories. It also determines the mapping of blocks to DataNodes. The DataNodes are responsible for serving read and write requests from the file system’s clients. The DataNodes also perform block creation, deletion, and replication upon instruction from the NameNode.
    - HDFS有主/从建筑。HDFS群集由单个名称节点组成，这是一个管理文件系统名称空间并控制客户端对文件访问的主服务器。此外，还有许多数据节点，通常集群中的每个节点一个，它们管理连接到运行节点的存储。HDFS公开了一个文件系统命名空间，并允许用户数据存储在文件中。在内部，文件被分割成一个或多个块，这些块存储在一组数据节点中。名称节点执行文件系统名称空间操作，如打开、关闭和重命名文件和目录。它还确定块到数据节点的映射。数据节点负责服务来自文件系统客户端的读写请求。数据节点还根据名称节点的指令执行块创建、删除和复制。
- 特点
    1. NameNode and DataNodes
    2. master/slave的架构
    3. NN：
        - the file system namespace 
        - regulates access to files by clients
    4. DN：storage
    5. HDFS exposes a file system namespace and allows user data to be stored in files
    6. a file is split into one or more blocks
    7. blocks are stored in a set of DataNodes
    8. The NameNode executes file system namespace operations like opening(CRUD)
    9. determines the mapping of blocks to DataNodes
    10. 通常情况下，一个node部署一个组件
   
    ![](http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/images/hdfsarchitecture.png)   
 
---

### 文件系统NameSpace详解
- The File System Namespace
    - HDFS supports a traditional hierarchical file organization. A user or an application can create directories and store files inside these directories. The file system namespace hierarchy is similar to most other existing file systems; one can create and remove files, move a file from one directory to another, or rename a file. HDFS supports user quotas and access permissions. HDFS does not support hard links or soft links. However, the HDFS architecture does not preclude implementing these features.
        - HDFS支持传统的分层文件组织。用户或应用程序可以创建目录并将文件存储在这些目录中。文件系统命名空间层次结构类似于大多数其他现有文件系统；可以创建和删除文件，将文件从一个目录移动到另一个目录，或者重命名文件。HDFS支持用户配额和访问权限。HDFS不支持硬链接或软链接。然而，HDFS架构并不排除实现这些功能。
    - The NameNode maintains the file system namespace. Any change to the file system namespace or its properties is recorded by the NameNode. An application can specify the number of replicas of a file that should be maintained by HDFS. The number of copies of a file is called the replication factor of that file. This information is stored by the NameNode.
        - 名称节点维护文件系统名称空间。对文件系统命名空间或其属性的任何更改都由名称节点记录。应用程序可以指定应该由HDFS维护的文件副本的数量。文件的拷贝数称为该文件的复制因子。该信息由名称节点存储。
            
---

### HDFS副本机制
- Data Replication
    - HDFS is designed to reliably store very large files across machines in a large cluster. It stores each file as a sequence of blocks. The blocks of a file are replicated for fault tolerance. The block size and replication factor are configurable per file.    
        - HDFS的设计目的是在大型集群中跨机器可靠地存储非常大的文件。它将每个文件存储为块序列。复制文件的块是为了容错。每个文件都可以配置块大小和复制因子。       
    - All blocks in a file except the last block are the same size, while users can start a new block without filling out the last block to the configured block size after the support for variable length block was added to append and hsync.
        - 除了最后一个块之外，文件中的所有块大小都相同，而用户可以在append和hsync中添加了对可变长度块的支持之后，启动一个新块，而不需要将最后一个块填充到所配置的块大小。
    - An application can specify the number of replicas of a file. The replication factor can be specified at file creation time and can be changed later. Files in HDFS are write-once (except for appends and truncates) and have strictly one writer at any time. 
        - 应用程序可以指定文件的副本数量。复制因子可以在文件创建时指定，稍后可以更改。HDFS中的文件是写一次的(除了追加和截断)，并且任何时候只有一个写器。
    - The NameNode makes all decisions regarding replication of blocks. It periodically receives a Heartbeat and a Blockreport from each of the DataNodes in the cluster. Receipt of a Heartbeat implies that the DataNode is functioning properly. A Blockreport contains a list of all blocks on a DataNode.
        -NameNode做出关于复制块的所有决策。它定期从集群中的每个数据节点接收心跳和块报告。接收到心跳意味着DataNode正常工作。块报告包含DataNode上的所有块的列表。
    ![](http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/images/hdfsdatanodes.png)         

---

    
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
