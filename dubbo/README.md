# Dubbo
## 简介
> `dubbo`项目，提供了dubbo入门级的一些代码示例,服务提供者（demo-provider）、服务消费者(demo-consumer)、公共API(demo-api)
## 子模块介绍
### 服务提供者（demo-provider）
> 服务提供者（demo-provider），实现了公共API(demo-api)定义的服务接口，实现某种业务逻辑，通过zookeeper注册中心将服务暴露出去,供服务消费者(demo-consumer)进行订阅消费.

### 服务消费者(demo-consumer)
> 服务消费者(demo-consumer)，通过Zookeeper注册中心，进行订阅公共API（demo-api）暴露的接口服务，生成远程服务代理服务类进行订阅消费

### 公共API(demo-api)
> 公共API(demo-api)，定义公共服务接口，再Zookeeper注册中心进行注册，提供给服务提供者（demo-provider）进行实现，提供给服务消费者(demo-consumer)进行订阅消费