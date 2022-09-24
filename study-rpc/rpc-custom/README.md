# 自定义RPC框架
使用 Java Socket 实现一个简单的RPC框架

整个调用流程分为四个角色：

- Service API：定义对外服务的接口规范
- Consumer Proxy：Service API 接口的代理类，内部逻辑通过 Socket 与服务的提供方进行通信，包括写入调用参数和获取调用返回的结果对象，通过代理使通信及获取返回结果等复杂逻辑对接口调用方透明
- Provider Reflect：服务的提供方，通过接收 Consumer Proxy 通过 Socket 写入的参数，定位到服务的具体实现，并通过 Java 反射技术实现服务的调用，然后将调用结果写入 Socket，返回到 Consumer Proxy
- Service Impl：远程服务的实现类