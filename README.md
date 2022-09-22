# SpringCloudDemo

# SpringCloudDemo

##一、单体架构
###1、新增
POST http://localhost:8000/producer/user/create
{
    "name": "zhangsan"
}
###2、查询
http://localhost:8000/producer/user/get/1


###3、查询
http://localhost:9000/consumer/user/get/1
###4、新增
POST http://localhost:9000/consumer/user/create
{
    "name": "lisi"
}

##二、Eureka 使用 -- 单机版
【基本说明：】
    Eureka 使用 分为 server 与 client。
    首先需要创建一个 Eureka Server 模块（eureka_server_7000），作为 服务注册中心。
    前面创建的两个模块 consumer_9000、producer_8000 可以作为 Eureka Client 模块。
注：
    producer_8000 作为 服务提供者，向 Eureka Server 中注册。
    consumer_9000 作为 服务消费者，从 Eureka Server 中发现服务。
    创建与 consumer_9000 一样的 eureka_client_consumer_9001 作为服务消费者进行演示。
    创建与 producer_8000 一样的 eureka_client_producer_8001 作为服务提供者进行演示。 
    
    单机版没使用价值，主要是为了由浅入深，为后面的集群版做铺垫。
也即：
    单机版需要创建三个子工程。
        eureka_server_7000                作为服务注册中心
        eureka_client_producer_8001       作为服务提供者（提供服务）
        eureka_client_consumer_9001       作为服务消费者（调用服务）
    
    eureka_client_producer_8001 与 eureka_client_consumer_9001 都会注册进 eureka_server_7000。
    eureka_client_consumer_9001 通过 eureka_client_producer_8001 配置的服务名，在 eureka_server_7000 注册中心中找到 eureka_client_producer_8001 真实地址。
    然后再通过 RestTemplate 远程调用该地址，从而完成 服务之间的交互。

1、请求
http://localhost:9001/consumer/user/get/1

##三、Eureka 伪集群版

【为什么使用集群：】
    远程服务调用 最重要的一个问题 就是 高可用，如果只有一个服务，那么当服务挂掉了，整个系统将会崩溃，
    所以需要部署多个服务（集群），除非所有服务都挂掉了，整个系统才会崩溃。
    同样的，注册中心也需要部署多个（集群）。
    采用集群方式部署、并实现负载均衡以及故障容错 从而提高 可用性。
    
【集群搭建基本说明：】
    前面单机版创建了 eureka_server_7000、eureka_client_producer_8001、eureka_client_consumer_9001 三个工程。
    此处为了区分，并演示集群的操作，
        创建与 eureka_server_7000 一样的 eureka_server_7001、eureka_server_7002、eureka_server_7003 作为 注册中心 集群。
        创建与 eureka_client_producer_8001 一样的 eureka_client_producer_8002、eureka_client_producer_8003、eureka_client_producer_8004 作为 服务提供者 集群。
        创建与 eureka_client_consumer_9001  一样的 eureka_client_consumer_9002 作为 服务消费者（可以不做集群）。
注：
    创建流程基本一致，但是配置文件有些许差别。

##1、配置hosts
127.0.0.1          eureka.server.7001.com
127.0.0.1          eureka.server.7002.com
127.0.0.1          eureka.server.7003.com
127.0.0.1       eureka.client.producer.8002
127.0.0.1       eureka.client.producer.8003
127.0.0.1       eureka.client.producer.8004
127.0.0.1       eureka.client.consumer.9002

##2、请求
http://localhost:9002/consumer/user/get/1
通过负载均衡，轮询（默认）的访问三个服务

##四、配置 actuator、服务发现、自我保护机制
（1）配置 actuator
　　用于监控 springboot 应用，比如：查看状态、健康检查等。

五、Zookeeper注册与发现
1、集群搭建

六、Consul注册与发现

七、Nacos注册与发现
【Nacos：】
    Nacos 即 Dynamic Naming and Configuration Service（动态命名与配置服务）。由 Naming 前两个字母，Configuration 前两个字母，以及 Service 首字母组成。
    Nacos 是一个更易于构建云原生应用的动态服务发现、配置管理 以及 服务管理平台。
简单的理解：
    Nacos 就是 注册中心 + 配置中心。 
    即 Nacos = Eureka + Config + Bus。
    
【相关地址：】
    https://nacos.io/zh-cn/index.html
    https://github.com/alibaba/nacos
 
【如何使用 Nacos：】
    Nacos 分为 Server、Client，其中 Server 作为注册中心以及配置中心，可以独立部署。
    而想要使用 Nacos，仅需在 微服务当中引入 client 相关依赖即可。
其中：
    Server 最新版本为 1.4.1，根据实际情况可以自行选择版本。
    使用注册中心功能，需要引入 spring-cloud-starter-alibaba-nacos-discovery 依赖。
    使用配置中心功能，需要引入 spring-cloud-starter-alibaba-nacos-config 依赖。
注：
    下载地址：https://github.com/alibaba/nacos/releases/download/1.4.1/nacos-server-1.4.1.tar.gz
    
【构建数据表：】
    进入解压后的 nacos 的 conf 目录，可以看到有 nacos-mysql.sql 文件。
    连接上 MySQL，新建一个数据库（nacos_config），并执行 nacos-mysql.sql 文件中的 SQL 语句。
注：
    可以直接使用官方提供的 nacos-mysql.sql 文件。
    https://github.com/alibaba/nacos/blob/master/distribution/conf/nacos-mysql.sql
   
经过查询：1.4.0以下使用的mysql驱动是8.0以下的，1.4.0以上使用的驱动就是8.0以上的，使nacos和数据库的版本对应。

##docker命令
docker-compose -f 指定某个docker-compose.yml文件 up -d

