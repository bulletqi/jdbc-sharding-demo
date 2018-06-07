### 读写分离
通过sharding-jdbc项目实现客户端的读写分离，只需要引入jar包并增加相关配置文件即可实现功能，应用层无侵入，使用方式如下:  
1.增加sharding-jdbc依赖
~~~
<dependency>
	<groupId>io.shardingjdbc</groupId>
	<artifactId>sharding-jdbc-spring-boot-starter</artifactId>
	<version>2.0.0.M3</version>
</dependency>
~~~
2.配置读写分离数据源
~~~
# 数据源配置，系统中所有数据源
sharding.jdbc.datasource.names=ds_0,ds_1

# 配置具体的数据源，数据源采用druid，关于druid数据源的一些配置项可以在datasource中加入
# 第一个数据源
sharding.jdbc.datasource.ds_0.type=com.alibaba.druid.pool.DruidDataSource
sharding.jdbc.datasource.ds_0.driverClassName=com.mysql.jdbc.Driver
sharding.jdbc.datasource.ds_0.url=jdbc:mysql://127.0.0.1:3306/ds_master?useSSL=false
sharding.jdbc.datasource.ds_0.username=root
sharding.jdbc.datasource.ds_0.password=root
# 开启druid监控
sharding.jdbc.datasource.ds_0.filters=stat

# 第二个数据源(存在多个继续配置)
sharding.jdbc.datasource.ds_1.type=com.alibaba.druid.pool.DruidDataSource
sharding.jdbc.datasource.ds_1.driverClassName=com.mysql.jdbc.Driver
sharding.jdbc.datasource.ds_1.url=jdbc:mysql://127.0.0.1:3306/ds_master?useSSL=false
sharding.jdbc.datasource.ds_1.username=root
sharding.jdbc.datasource.ds_1.password=root
sharding.jdbc.datasource.ds_1.filters=stat

# 指定主从数据源（关键配置）
# 主库
sharding.jdbc.config.masterslave.masterDataSourceName=ds_0
# 从库
sharding.jdbc.config.masterslave.slaveDataSourceNames=ds_1
# 名称
sharding.jdbc.config.masterslave.name=ds_masterslave

# druid相关配置项
spring.datasource.druid.use-global-data-source-stat=true
spring.datasource.druid.web-stat-filter.url-pattern=/*
spring.datasource.druid.stat-view-servlet.url-pattern=/druid/*
spring.datasource.druid.filter.stat.log-slow-sql=true
~~~
> 数据的主从同步由外部的服务实现，同时需要注意同步延迟引起的数据不一致问题

### 单数据源
如果项目中引用sharding-jdbc的依赖,单数据源的配置方式如下，如果采用老的方式，需要去到sharding-jdbc的依赖
~~~
# 数据源名称
sharding.jdbc.datasource.names=ds_source
sharding.jdbc.datasource.ds_source.type=com.alibaba.druid.pool.DruidDataSource
sharding.jdbc.datasource.ds_source.driverClassName=com.mysql.jdbc.Driver
sharding.jdbc.datasource.ds_source.url=jdbc:mysql://127.0.0.1:3306/ds_master?useSSL=false
sharding.jdbc.datasource.ds_source.username=root
sharding.jdbc.datasource.ds_source.password=root
~~~
