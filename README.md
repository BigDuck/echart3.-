# echart3.-
模块化实现

## 关于aop问题
如果你是使用配置文件进行配置的话，如果发现@aspectj失效的话如下面所述：
如果使用了spring mvc后，如果把<aop:aspectj-autoproxy proxy-target-class="true"/>放在application.xml文件中可能会aop无效，最好把它放在dispatcher-servlet.xml文件中
