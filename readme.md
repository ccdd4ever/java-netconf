# 通过java进行网络设备管理DEMO

## 以h3c交换机为例，通过netconf协议下发交换机配置
steps
* 配置交换机。参考docs中文档，打开netconf 功能。h3c交换机netconf在transport层支持soap over http或者soap over http以及ssh协议。以ssh协议为例，需进行以下配置，
port-number可以使用缺省值，缺省为830
```shell
system-view
netconf ssh server enable 
netconf ssh server port port-number

```

* 参考docs中的netconf api文档，通过tail-f公司开业的jnc发送rpc请求。

## TODO 补充更多的方式，比如restconf,openflow等。
