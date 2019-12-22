## 项目需求

### 客户端：

**针对普通用户。**

功能模块：用户登录、用户退出、菜品订购、我的订单。

### 后台管理系统：

**针对管理员。**

功能模块：管理员登录、管理员退出、添加菜品、查询菜品、删除菜品、订单处理、添加用户、编辑用户、查询用户、删除用户。

**微服务根据业务拆分**

:partly_sunny:account 提供账户服务：包括用户和管理员的登录退出。

:partly_sunny:menu 提供菜品服务：添加菜品、删除菜品、修改菜品、查询菜品。

:partly_sunny:order 提供订单服务 ：添加订单、查询订单、删除订单、处理订单。

:partly_sunny:user 提供用户服务 ：添加用户、查询用户、删除用户。

:partly_sunny:client 服务消费者：在不同服务提供者之间调用服务。

分离出一个**服务消费者**，调用以上四个**服务提供者**，服务消费者包含了客户端的前端页面和后台接口（不会直接调用数据库）、后台管理系统的前端页面和后台接口。用户/管理员直接访问的资源都保存在服务消费者中，服务消费者根据具体的需求调用四个服务提供者的业务逻辑，通过Feign实现负载均衡。

四个服务提供者和一个服务消费者都需要在注册中心进行注册，同时可以使用配置中心来对配置文件进行统一集中管理。(配置不会写在服务提供者的代码包里)

---

