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